package com.jin.learn.springbootaccessdemo.qrcode.controller;

/**
 * @author Karl Jin
 * @create 2019-05-27 14:17
 */

import com.jin.learn.springbootaccessdemo.qrcode.utils.QRCodeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;

@RestController
public class QrCodeController {


    @GetMapping("/qr")
    // 举例扫码开锁：如果需要登录软件扫描  那就把登录信息传递过来调这个接口 校验登录信息
    public String getQRode() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
        //包含图片的二维码生成路径
        String qr2 = "qr_002.jpg";

        String qrContent = "http://www.baidu.com";// 全局唯一ID

        try {
            ImageIO.write(QRCodeUtil.createQRCodeTest(qrContent, 200, "logo.png", 50, qr2), "png", baos);//写入流中
        } catch (Exception e) {

        }
        byte[] bytes = baos.toByteArray();//转换成字节
        BASE64Encoder encoder = new BASE64Encoder();
        String png_base64 = encoder.encodeBuffer(bytes).trim();//转换成base64串
        png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n
        return png_base64;
        // 前端需要  decodeURI(data.res_data.png_url)
        // 扫一下之后获取到全局唯一ID
        // 全局唯一ID 车辆ID  用户ID传输到后台  获取开锁指令
        // 指令通过蓝牙解锁
    }


}
