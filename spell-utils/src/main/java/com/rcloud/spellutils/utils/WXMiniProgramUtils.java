package com.rcloud.spellutils.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.axis.encoding.Base64;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.net.*;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * 微信小程序工具类
 *
 * @author xuchenguang
 * @since 2018.11.22
 */
public class WXMiniProgramUtils {

    private static final Logger logger = LoggerFactory.getLogger("微信小程序工具类");

    /**
     * 获取sessionKey
     */
//    private static final String WECHAT_SESSION_KEY = "https://api.weixin.qq.com/sns/jscode2session";
    private static final String WECHAT_SESSION_KEY = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

    /**
     * 获取AccessToken
     */
    private static final String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";


    /**
     * 发送模板消息
     */
    private static final String SEND_TEMPLATE_API = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";


    /**
     * 发送小程序模板消息
     *
     * @return
     */
    public static String sendTemplate(String openId, String templateId, String page, String formId, String[] str) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        String url = SEND_TEMPLATE_API.replace("ACCESS_TOKEN", StringRedisUtils.get("accessToken"));

        RestTemplate restTemplate = new RestTemplate();

        HashMap<String, Object> data = new HashMap<>();
        data.put("touser", openId);
        data.put("template_id", templateId);
        data.put("page", page);
        data.put("form_id", formId);
        data.put("data", buildKeyword(str));
//        data.add("emphasis_keyword", emphasisKeyword);
        HttpEntity<String> requestEntity = new HttpEntity<>(JSONObject.toJSONString(data), headers);
        String s = restTemplate.postForObject(url, requestEntity, String.class);
        logger.info(s);
        return s;
    }

    /**
     * 获取sessionKey
     *
     * @param appId
     * @param secret
     * @param code
     * @return
     * @throws Exception
     */
    public static JSONObject getSessionKey(String appId, String secret, String code) throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        String url = WECHAT_SESSION_KEY.replace("APPID", appId)
                .replace("SECRET", secret)
                .replace("JSCODE", code);

        ResponseEntity<String> template = restTemplate.getForEntity(url, String.class);

        if (template.getStatusCodeValue() == 200) {
            JSONObject object = JSONObject.parseObject(template.getBody());
            return object;
        }

        return null;
    }

    /**
     * 获取getAccessToken
     *
     * @param appId
     * @param secret
     * @return
     * @throws Exception
     */
    public static String getAccessToken(String appId, String secret) throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        String url = GET_ACCESS_TOKEN.replace("APPID", appId)
                .replace("APPSECRET", secret);

        ResponseEntity<String> template = restTemplate.getForEntity(url, String.class);

        if (template.getStatusCodeValue() == 200) {
            JSONObject object = JSONObject.parseObject(template.getBody());
            String accessToken = object.getString("access_token");
            Long expiresIn = object.getLong("expires_in");
            StringRedisUtils.set("accessToken", accessToken, expiresIn);

            return accessToken;
        }

        return null;
    }

    /**
     * 解密用户敏感数据获取用户信息
     *
     * @param sessionKey    数据进行加密签名的密钥
     * @param encryptedData 包括敏感数据在内的完整用户信息的加密数据
     * @param iv            加密算法的初始向量
     * @return
     */
    public static JSONObject getUserInfo(String encryptedData, String sessionKey, String iv) throws Exception {
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);

        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);
            // 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");

                return JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取用户信息
     *
     * @param encryptedData
     * @return
     * @throws Exception
     */
    public static JSONObject getUserInfo(String encryptedData) throws Exception {

        if (StringUtils.isNotBlank(encryptedData)) {
            return JSON.parseObject(encryptedData);
        }

        return null;
    }

    public static String getLocalHostIp() {
        // 获取操作系统类型
        String sysType = System.getProperties().getProperty("os.name");
        String ip;
        if (sysType.toLowerCase().startsWith("win")) {  // 如果是Windows系统，获取本地IP地址
            String localIP = null;
            try {
                localIP = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                logger.error(e.getMessage(), e);
            }
            if (localIP != null) {
                return localIP;
            }
        } else {
            ip = getIpByEthNum("eth0"); // 兼容Linux
            if (ip != null) {
                return ip;
            }
        }
        return null;
    }

    /**
     * 根据网络接口获取IP地址
     *
     * @param ethNum 网络接口名，Linux下是eth0
     * @return
     */
    public static String getIpByEthNum(String ethNum) {
        try {
            Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                if (ethNum.equals(netInterface.getName())) {
                    Enumeration addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = (InetAddress) addresses.nextElement();
                        if (ip != null && ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (SocketException e) {
            logger.error(e.getMessage(), e);
        }
        return "获取服务器IP错误";
    }


    public static JSONObject buildKeyword(String[] str) {
        JSONObject object = new JSONObject();
        for (int i = 1; i <= str.length; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("value", str[i - 1]);
            object.put("keyword" + i, jsonObject);
        }
        return object;
    }
}
