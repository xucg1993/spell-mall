package com.rcloud.spellutils.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.DeleteObjectsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * 阿里云oss工具类
 *
 * @author xuchenguang
 * @since 2018.11.20
 */

public class OSSClientUtils {

    private static final Logger logger = LoggerFactory.getLogger("阿里云oss工具类");

    /**
     * 储存空间名称
     */
    private static String BUCKET_NAME = OSSConfig.getBucketName();

    /**
     * 返回URL
     */
    private static String RESULT_URL = OSSConfig.getResultUrl();


    /**
     * 默认配置
     *
     * @return
     */
    public static OSSClient defaultOSSClient() {
        return new OSSClient(OSSConfig.getEndpoint(), OSSConfig.getAccessKeyId(),
                OSSConfig.getAccessKeySecret());
    }

    /**
     * 自定义配置
     *
     * @param endpoint
     * @param accessKeyId
     * @param accessKeySecret
     * @return
     */
    public static OSSClient defaultOSSClient(String endpoint, String accessKeyId, String accessKeySecret) {
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }


    /**
     * 上传文件
     * 自动生成新文件名
     *
     * @param file
     * @return
     */
    public static String uploadFile(MultipartFile file) {

        //获取原来的文件名
        String fileName = file.getOriginalFilename();
        String extName = fileName.substring(fileName.lastIndexOf("."));

        //新的文件名
        StringBuffer sb = new StringBuffer();
        sb.append(System.currentTimeMillis()).append(extName);
        String newFileName = sb.toString();

        try {
            //上传
            upload(file, newFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //返回url链接
        StringBuffer sb1 = new StringBuffer();
        sb1.append(RESULT_URL).append(newFileName);

        return sb1.toString();
    }

    /**
     * 上传文件
     * 自定义文件名
     *
     * @param file
     * @param fileName
     * @return
     */
    public static String uploadFile(MultipartFile file, String fileName) {

        try {
            //上传
            upload(file, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //返回url链接
        StringBuffer sb1 = new StringBuffer();
        sb1.append(RESULT_URL).append(fileName);

        return sb1.toString();
    }


    /**
     * 上传
     *
     * @param file
     * @param fileName
     */
    public static void upload(MultipartFile file, String fileName) {

        //实例化OSSClient配置
        OSSClient ossClient = defaultOSSClient();

        //输入流
        InputStream is = null;

        try {
            //输入流转成 ByteArrayOutputStream
            is = new ByteArrayInputStream(file.getBytes());
            //上传至oss
            ossClient.putObject(BUCKET_NAME, fileName, is);

        } catch (Exception e) {
            logger.error("OSS文件上传出错！", e);
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();
                ossClient.shutdown();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        logger.info("OSS上传成功！");
    }


    /**
     * 判断文件是否存在
     *
     * @param key 文件名
     * @return
     */
    public static Boolean isFileExist(String key) {

        //创建OSSClient实例
        OSSClient ossClient = defaultOSSClient();

        // 判断文件是否存在。
        boolean found = ossClient.doesObjectExist(BUCKET_NAME, key);

        // 关闭OSSClient
        ossClient.shutdown();

        return found;
    }


    /**
     * 删除文件
     *
     * @param key
     * @return
     */
    public static void deleteFile(String key) {

        //创建OSSClient实例
        OSSClient ossClient = defaultOSSClient();

        // 判断文件是否存在。
        ossClient.deleteObject(BUCKET_NAME, key);

        // 关闭OSSClient
        ossClient.shutdown();

    }

    /**
     * 批量删除文件
     *
     * @param keys
     */
    public static List<String> deleteFileResult(List<String> keys) {

        //创建OSSClient实例
        OSSClient ossClient = defaultOSSClient();

        // 判断文件是否存在。
        DeleteObjectsResult deleteObjectsResult = ossClient.deleteObjects(new DeleteObjectsRequest(BUCKET_NAME).withKeys(keys));

        //删除结果。详细模式下为删除成功的文件列表，简单模式下为删除失败的文件列表
        List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();

        // 关闭OSSClient
        ossClient.shutdown();

        return deletedObjects;

    }


}
