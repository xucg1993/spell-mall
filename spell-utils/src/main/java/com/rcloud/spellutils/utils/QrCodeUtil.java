package com.rcloud.spellutils.utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.util.Hashtable;

/**
 * 二维码
 *
 * @author Xucg
 * @since 2017/12/21 0021
 */
public class QrCodeUtil {

    /**
     * png格式
     */
    private static final String FILE_FORMAT_PNG = "png";
    private static final String FILE_FORMAT_DOT_PNG = ".png";

    /**
     * jpg格式
     */
    private static final String FILE_FORMAT_JPG = "jpg";
    private static final String FILE_FORMAT_DOT_JPG = ".jpg";

    /**
     * 编码
     */
    private static final String FILE_ENCODE_UTF8 = "utf-8";

    /**
     * 图片宽高
     */
    private static final Integer IMAGE_WIDTH = 215;
    private static final Integer IMAGE_HEIGHT = 215;


    /**
     * 生成png格式的二维码
     * 默认:300px * 300px
     *
     * @param content  内容
     * @param filePath 图片输出路径
     * @param fileName 图片名称
     * @return
     */
    public static void createQrCodePng(String content,
                                       String filePath,
                                       String fileName) {

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, IMAGE_WIDTH, IMAGE_HEIGHT, buildHashTable());

            Path file = new File(filePath + fileName + FILE_FORMAT_DOT_PNG).toPath();

            MatrixToImageWriter.writeToPath(bitMatrix, FILE_FORMAT_PNG, file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成自定义像素 png格式的二维码
     * 默认:300px * 300px
     *
     * @param content  内容
     * @param filePath 图片输出路径
     * @param fileName 图片名称
     * @param width    宽
     * @param height   高
     * @return
     */
    public static void createQrCodePng(String content,
                                       String filePath,
                                       String fileName,
                                       int width,
                                       int height) {

        try {
            BitMatrix bitMatrix = new MultiFormatWriter()
                    .encode(content, BarcodeFormat.QR_CODE, width, height, buildHashTable());

            Path files = new File(filePath + fileName + FILE_FORMAT_DOT_PNG).toPath();

            MatrixToImageWriter.writeToPath(bitMatrix, FILE_FORMAT_PNG, files);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出图片流
     * @param content
     * @param response
     * @return
     */
    public static void createQrCodePngStream(String content, HttpServletResponse response) {

        try {
            BitMatrix bitMatrix = new MultiFormatWriter()
                    .encode(content, BarcodeFormat.QR_CODE, 215, 215, buildHashTable());

            MatrixToImageWriter.writeToStream(bitMatrix, "png", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Hashtable buildHashTable() {
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, FILE_ENCODE_UTF8);
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);
        return hints;
    }

    /**
     * 解析二维码内容
     *
     * @param filePath
     * @return
     */
    public static String analysisQrCode(String filePath) {

        MultiFormatReader formatReader = new MultiFormatReader();

        File file = new File(filePath);
        Result result = null;

        try {

            BufferedImage image = ImageIO.read(file);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            Hashtable hints = new Hashtable();
            hints.put(EncodeHintType.CHARACTER_SET, FILE_ENCODE_UTF8);
            result = formatReader.decode(binaryBitmap, hints);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
