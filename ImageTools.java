package com.tang.utils;

import sun.nio.ch.IOUtil;

import java.io.*;

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

    public String getProjectPath(){

        String projectPath = ImageTools.class.getResource("/").toString();
        projectPath = projectPath.substring(projectPath.indexOf("target"));
        return projectPath;
    }


    public String getImagePath(){
        String imagePath = null;
        String temp = getProjectPath()+"image";
        File file = new File(temp);
        if(!file.exists()){
            boolean flag = file.mkdir();
            if(flag) {
                System.out.println("目录创建成功");
                imagePath = temp;
            }else {
                throw new RuntimeException("目录创建失败");
            }
        }else{
            imagePath = temp;
            System.out.println("目录存在");
        }
        return imagePath;
    }

    public String getImageBase64Str(String imageName){
        String imagePath = getImagePath();
        String result = null;
        File file  = new File(imagePath,imageName);
        try {
            InputStream is = new FileInputStream(file);
            byte[] =IOUtil
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return;
    }

}
