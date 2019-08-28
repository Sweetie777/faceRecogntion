package com.tang.utils;

import org.apache.commons.io.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.util.Base64;

/**
 * Author: Sweetie77
 * Created: 2019/8/25
 */
public class ImageTools {
    /**
     * 获取本地图片,然后对图片进行编码
     * 1. 获取工程路径, 工程路径+image
     * 2. 获取图片文件的file对象
     * 3. 对file进行base64编码
     */

    private static String getProjectPath(){

        String projectPath = ImageTools.class.getResource("/").toString();
        projectPath = projectPath.substring(projectPath.indexOf("target"));
        return projectPath;
    }


    private static String getImagePath(){
        String imagePath = null;
        String temp = getProjectPath()+"image";
        File file = new File(temp);
        if(file.exists()){
            System.out.println("image文件已经存在, 不需要创建");
        }else{
            File director = new File(temp);
            if(director.mkdirs()){
                System.out.println("image文件创建成功");
                imagePath = temp;
            }else{
                throw new RuntimeException("文件创建失败");
            }
        }
        return imagePath;
    }

    public static String getImageBase64Str(String imageName){
        String imageBase64Str=null;
        String imagePath=getImagePath();
        // 根据文件名称和文件路径构建file对象
        File file=new File(imagePath,imageName);
        try {
            // 获取文件的输入流
            InputStream in=new FileInputStream(file);
            byte[] data=IOUtils.toByteArray(in);
            // 进行base64编码
            imageBase64Str=Base64.getEncoder().encodeToString(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageBase64Str;
    }
}
