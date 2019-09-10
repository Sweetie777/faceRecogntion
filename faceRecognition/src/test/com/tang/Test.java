package com.tang;

import com.tang.model.FaceModel;
import com.tang.utils.FaceAipClient;
import com.tang.utils.ImageTools;


/**
 * Author: Sweetie77
 * Created: 2019/8/25
 */
public class Test {
    @org.junit.Test
    public void testAipFace() {
        FaceAipClient client = new FaceAipClient();
        System.out.println(client.client);
    }

    public static FaceAipClient aiClient;
    public static String img1Base64;
    public static String img2Base64;

    @org.junit.Test
    public void testDetect() {
        //需要base64编码的图片字符串
        aiClient = new FaceAipClient();
        img1Base64 = ImageTools.getImageBase64Str("1.JPG");
        img2Base64 = ImageTools.getImageBase64Str("2.JPG");

        FaceModel faceModel =aiClient.detect(img1Base64);
        System.out.println(faceModel);

    }
}
