package com.jin.learn.springbootaccessdemo.qrcode.utils;

/**
 * @author Karl Jin
 * @create 2019-05-27 15:09
 */

public class TestQRCodeUtil {

    //不包含图片的二维码生成路径
    private static String qr1 = "qr_001.jpg";

    //包含图片的二维码生成路径
    private static String qr2 = "qr_002.jpg";

    /**
     * 二维码携带内容
     */
    private static String qrContent = "http://www.baidu.com";


    //测试生成不包含图片的二维码
    public static void createQRWithOutLogo() throws Exception {
        QRCodeUtil.createQRCode(qrContent, 200, qr1);
        System.out.println("不包含图片的二维码已经生成...\n**************************\n");
    }

    //测试包含图片的二维码
    public static void createQRIncludeLogo() throws Exception {
        QRCodeUtil.createQRCode(qrContent, 200, "logo.png", 50, qr2);
        System.out.println("包含图片的二维码已经生成...\n**************************\n");
    }

    // 解析不带图片的二维码
    public static void parseQRWithOutLogo() throws Exception {
        String result = QRCodeUtil.parseQRCode(qr1);
        System.out.println("不包含图片的二维码解析结果:" + result + "\n**************************\n");
    }

    // 解析带图片的二维码
    public static void parseQRIncludeLogo() throws Exception {
        String result = QRCodeUtil.parseQRCode(qr1);
        System.out.println("包含图片的二维码解析结果:" + result + "\n**************************\n");
    }


    public static void main(String[] args) {
        try {
            createQRWithOutLogo();
            parseQRWithOutLogo();
            createQRIncludeLogo();
        } catch (Exception ex) {

        }
    }




}
