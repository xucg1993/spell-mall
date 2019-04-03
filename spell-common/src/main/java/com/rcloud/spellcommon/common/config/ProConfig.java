//package com.rcloud.spellcommon.common.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
///**
// * @author xuchenguang
// * @since 2018.11.20
// */
//@Component
//public class OSSConfig {
//
//    /*阿里云oss*/
//    private static String ossEndpoint;
//    private static String ossAccessKeyId;
//    private static String ossAccessKeySecret;
//    private static String ossBucketName;
//    private static String ossResultUrl;
//
//
//    /*微信配置*/
//    private static String miniProgramAppId;
//    private static String miniProgramSecret;
//    private static String wxPayCallBack;
//
//
//    /*--------------------------SETTER---------------------------------*/
//    @Value("${ossConfig.endpoint}")
//    public void setOssEndpoint(String ossEndpoint) {
//        OSSConfig.ossEndpoint = ossEndpoint;
//    }
//
//    @Value("${ossConfig.accessKeyId}")
//    public void setOssAccessKeyId(String ossAccessKeyId) {
//        OSSConfig.ossAccessKeyId = ossAccessKeyId;
//    }
//
//    @Value("${ossConfig.accessKeySecret}")
//    public void setOssAccessKeySecret(String ossAccessKeySecret) {
//        OSSConfig.ossAccessKeySecret = ossAccessKeySecret;
//    }
//
//    @Value("${ossConfig.bucketName}")
//    public void setOssBucketName(String ossBucketName) {
//        OSSConfig.ossBucketName = ossBucketName;
//    }
//
//    @Value("${ossConfig.resultUrl}")
//    public void setOssResultUrl(String ossResultUrl) {
//        OSSConfig.ossResultUrl = ossResultUrl;
//    }
//
//    @Value("${wxConfig.appId}")
//    public static void setMiniProgramAppId(String miniProgramAppId) {
//        OSSConfig.miniProgramAppId = miniProgramAppId;
//    }
//
//    @Value("${wxConfig.secret}")
//    public static void setMiniProgramSecret(String miniProgramSecret) {
//        OSSConfig.miniProgramSecret = miniProgramSecret;
//    }
//
//    @Value("${wxConfig.callBack}")
//    public static void setWxPayCallBack(String wxPayCallBack) {
//        OSSConfig.wxPayCallBack = wxPayCallBack;
//    }
//
//    /*--------------------------GETTER---------------------------------*/
//
//    public static String getOssEndpoint() {
//        return ossEndpoint;
//    }
//
//    public static String getOssAccessKeyId() {
//        return ossAccessKeyId;
//    }
//
//    public static String getOssAccessKeySecret() {
//        return ossAccessKeySecret;
//    }
//
//    public static String getOssBucketName() {
//        return ossBucketName;
//    }
//
//    public static String getOssResultUrl() {
//        return ossResultUrl;
//    }
//
//    public static String getMiniProgramAppId() {
//        return miniProgramAppId;
//    }
//
//    public static String getMiniProgramSecret() {
//        return miniProgramSecret;
//    }
//
//    public static String getWxPayCallBack() {
//        return wxPayCallBack;
//    }
//}
