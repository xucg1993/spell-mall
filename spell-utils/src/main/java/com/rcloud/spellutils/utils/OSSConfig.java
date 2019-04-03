package com.rcloud.spellutils.utils;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author xuchenguang
 * @since 2018.11.20
 */
public class OSSConfig {


    private static String endpoint;
    private static String accessKeyId;
    private static String accessKeySecret;
    private static String bucketName;
    private static String resultUrl;

    /*--------------------------SETTER---------------------------------*/
    @Value("${ossConfig.endpoint}")
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Value("${ossConfig.accessKeyId}")
    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    @Value("${ossConfig.accessKeySecret}")
    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    @Value("${ossConfig.bucketName}")
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    @Value("${ossConfig.resultUrl}")
    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }


    /*--------------------------GETTER---------------------------------*/
    public static String getEndpoint() {
        return endpoint;
    }

    public static String getAccessKeyId() {
        return accessKeyId;
    }

    public static String getAccessKeySecret() {
        return accessKeySecret;
    }

    public static String getBucketName() {
        return bucketName;
    }

    public static String getResultUrl() {
        return resultUrl;
    }
}
