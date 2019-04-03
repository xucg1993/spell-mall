package com.rcloud.spellminiprogram.contorller.login;

import com.alibaba.fastjson.JSONObject;
import com.rcloud.spellentity.entity.user.UserEntity;
import com.rcloud.spellminiprogram.common.annotation.CheckLogin;
import com.rcloud.spellminiprogram.contorller.BaseController;
import com.rcloud.spellutils.utils.BaseUtils;
import com.rcloud.spellutils.utils.ResultJson;
import com.rcloud.spellutils.utils.StringRedisUtils;
import com.rcloud.spellutils.utils.WXMiniProgramUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuchenguang
 * @since 2019.01.02
 */
@RestController
public class LoginController extends BaseController {

    public static final String CONTROLLER_NAME = "login";

    /**
     * 小程序登录
     *
     * @param code
     * @return
     */
    @PostMapping(CONTROLLER_NAME)
    public String userLogin(String code) throws Exception {

        loggerInfo("用户登录");

        if (StringUtils.isBlank(code)) {
            return ResultJson.getResultJsonFail("参数缺失");
        }

        JSONObject object = WXMiniProgramUtils.getSessionKey(appId, secret, code);

        String openid = object.getString("openid");
        UserEntity entity = userService.findByAppletsOpenId(openid);

        String sessionKey = object.getString("session_key");
        String token = BaseUtils.generateElevenNum();

        //判断是否为新用户
        if (entity == null) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserId(BaseUtils.generateUUId());
            userEntity.setMiniappOpenId(openid);
            //保存用户信息
            Integer save = userService.save(userEntity);

            if (save > 0) {
                //存入redis   过期时间15天
                StringRedisUtils.set(token, userEntity.getUserId().toString(), 1296000L);
                //存入redis
                StringRedisUtils.set(userEntity.getUserId(), sessionKey, 1296000L);
            }

        } else {

            if (StringUtils.isNotBlank(userService.findToken())) {
                token = userService.findToken();
            }
            //存入redis   过期时间15天
            StringRedisUtils.set(token, entity.getUserId(), 1296000L);
            //存入redis
            StringRedisUtils.set(entity.getUserId(), sessionKey, 1296000L);
        }

        return ResultJson.getResultJsonSuccess(SAVE_SUCCESS, token);
    }

    /**
     * 更新用户信息
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    @CheckLogin
    @PutMapping(CONTROLLER_NAME)
    public String getUserInfo(String userInfo) throws Exception {

        loggerInfo("更新用户信息");

        if (StringUtils.isBlank(userInfo)) {

            return ResultJson.getResultJsonFail("参数缺失");
        }

        JSONObject object = WXMiniProgramUtils.getUserInfo(userInfo);

        UserEntity entity = new UserEntity();

        //获取userId
        String userId = userService.findUserIdByToken();
        //用户id
        entity.setUserId(userId);
        //昵称
        entity.setNickName(object.getString("nickName"));
        //用户头像
        entity.setAvatarUrl(object.getString("avatarUrl"));
        //用户性别
        entity.setGender(object.getInteger("gender"));
        //所在国家
        entity.setCountry(object.getString("country"));
        //所在省份
        entity.setProvince(object.getString("province"));
        //所在城市
        entity.setCity(object.getString("city"));

        int i = userService.update(entity);

        if (i > 0) {
            return ResultJson.getResultJsonSuccess("更新成功", entity);
        }

        return ResultJson.getResultJsonFail("更新失败");
    }
}
