package com.rcloud.spellutils.utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xuchenguang
 * @since 2019.01.03
 */
public class BaseUtils {

    /**
     * 生成随机订单  11位
     *
     * @return
     */
    public static String generateElevenNum() {

        char[] c = generateRandomNum().toCharArray();
        List<Character> lst = new ArrayList<Character>();
        for (int i = 0; i < c.length; i++) {
            lst.add(c[i]);
        }
        Collections.shuffle(lst);
        String resultStr = "";
        for (int i = 0; i < lst.size(); i++) {
            resultStr += lst.get(i);
        }
        return resultStr.substring(0, 11);
    }

    /**
     * 随机字符
     *
     * @return
     */
    public static String generateRandomNum() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            result += random.nextInt(10) + 1;
        }
        return newDate + result;
    }

    /**
     * 生成32位 UUID
     *
     * @return
     */
    public static String generateUUId() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}