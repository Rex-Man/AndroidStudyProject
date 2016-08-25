package com.oocl.manlimeng.androidstudyproject.Common;

/**
 * Created by manre on 8/23/16.
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.os.Environment;

public class SDCardService {
    private Context ctx;

    public SDCardService(Context ctx) {
        this.ctx = ctx;
    }

    /**
     * 写文件入skcard
     */
    public void writeToSdCard(String fileName, String cont) {
        try {
            // 判断是否有挂载sdcard
            if (Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                // 得到sdcar文件目录
                File dir = Environment.getExternalStorageDirectory();
                File file = new File(dir, "itcast.txt");
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(cont.getBytes());
                fos.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 读SdCard中的文件
     */
    public String readSdCard(String fileName) {
        try {
            // 判断是否有挂载sdcard
            if (Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                // 得到sdcar文件目录
                File dir = Environment.getExternalStorageDirectory();
                File file = new File(dir, "itcast.txt");
                FileInputStream fis = new FileInputStream(file);
                return readIs2String(fis);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将输入流数据读取到输出流当中
     */
    private OutputStream readIs2Os(InputStream is ,OutputStream os){
        try {
            byte[] bytes = new byte[1024];
            int length = 0 ;
            while((length = is.read(bytes)) != -1){
                os.write(bytes, 0, length);
            }
            is.close();
            os.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return os ;
    }

    /**
     * 将输入流数据读取到输出流当中
     */
    public byte[] readIs2Bytes(InputStream is){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        readIs2Os(is,baos);
        return baos.toByteArray() ;
    }

    public String readIs2String(InputStream is){
        try {
            return new String(readIs2Bytes(is),"utf-8");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
    }

    public String readIs2String(String fileName){
        try {
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                File dir = Environment.getExternalStorageDirectory();
                File file = new File(dir,fileName);
                FileInputStream is = new FileInputStream(file);
                return readIs2String(is);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
    }
}