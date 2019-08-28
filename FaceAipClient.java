package com.tang.utils;

import com.baidu.aip.face.AipFace;
import com.tang.model.FaceModel;
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

    public FaceModel detect(String image) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field", "age");

        // 人脸检测
        JSONObject res = client.detect(image, imageType, options);
        System.out.println(res.toString(2));

        //根据返回值中的error_msg,判断是否进行属性的封装
        FaceModel faceModel = null;
        String errorMsg = res.getString("error_msg");
        options.put("face_field", "age,beauty,expression,face_shape,gender,glasses,race");
        if ("SUCCESS".equalsIgnoreCase(errorMsg)) {
            JSONObject result = res.getJSONObject("result");
            JSONObject object = (JSONObject) result.getJSONArray("face_list").get(0);
            System.out.println("里层的Json对象");
            System.out.println(object.toString());

            parseAttribute(object);

        } else {
            System.out.println("调用失败");
        }
        return faceModel;
    }

    private void parseAttribute(JSONObject faceObject) {
        //对里层的Json进行处理,将对应的值赋值到FaceModel对象上
        FaceModel faceModel = new FaceModel();
        Integer age = faceObject.getInt("age");//年龄
        if (null != age) {
            faceModel.setAge(age);
        }

        Integer beauty = faceObject.getInt("beauty");//颜值
        faceModel.setBeauty(beauty);


        //表情
        String expression = faceObject.getJSONObject("expression").getString("type");
        switch (expression) {
            case "smile":
                faceModel.setExpression("微笑");
                break;
            case "laugh":
                faceModel.setExpression("大笑");
                break;
            case "none":
            default:
                faceModel.setExpression("无");
        }

        //脸型
        String faceShape = faceObject.getJSONObject("face_shape").getString("type");
        switch (faceShape) {
            case "square":
                faceModel.setFaceShape("正方形");
                break;
            case "triangle":
                faceModel.setFaceShape("三角形");
                break;
            case "oval":
                faceModel.setFaceShape("椭圆");
                break;
            case "heart":
                faceModel.setFaceShape("心形");
                break;
            case "round":
                faceModel.setFaceShape("圆形");
                break;
            default:
                faceModel.setFaceShape("未知");

        }

        //性别
        String gender = faceObject.getJSONObject("gender").getString("type");
        switch (gender) {
            case "male":
                faceModel.setGender("帅哥");
                break;
            case "female":
                faceModel.setGender("美女");
                break;
            default:
                faceModel.setGender("未知");
        }

        //人种
        String race = faceObject.getJSONObject("race").getString("type");
        switch (race) {
            case "yellow":
                faceModel.setRace("黄种人");
                break;
            case "white":
                faceModel.setRace("白种人");
                break;
            case "black":
                faceModel.setRace("黑种人");
                break;
            case "arabs":
                faceModel.setRace("阿拉伯人");
                break;
            default:
                faceModel.setRace("未知");
        }

        //眼镜
        String glasses = faceObject.getJSONObject("glasses").getString("type");
        switch (glasses) {
            case "common":
                faceModel.setGlasses("普通眼镜");
                break;
            case "sun":
                faceModel.setGlasses("墨镜");
                break;
            case "none":
                faceModel.setGlasses("无眼镜");
                break;
            default:
                faceModel.setGlasses("未知");
        }

    }
}
