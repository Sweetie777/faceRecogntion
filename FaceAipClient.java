package com.tang.utils;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Author: Sweetie77
 * Created: 2019/8/25
 */
public class FaceAipClient {
    //设置APPID/AK/SK
    public static final String APP_ID = "17080102";
    public static final String API_KEY = "PRXY8sE83o80cnwkLzsf8v22";
    public static final String SECRET_KEY = "\n" + "yl0MbZDwuse6yepqK2PDCKS34qWD8YG6";

    public static final String imageType = "BASE64";

    public AipFace client;

    public FaceAipClient() {
        //初始化AipFace
        client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        //设置网络连接
        client.setConnectionTimeoutInMillis(1000);
        client.setSocketTimeoutInMillis(6000);
    }

    public JSONObject detect(String image){
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field", "age");

        // 人脸检测
        JSONObject res = client.detect(image, imageType, options);
        System.out.println(res.toString(2));

    }
}
