package com.sabin.urltoimagefile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by sabin on 11/10/14.
 */
public class ImageDownloader {

    private static final int URL_HTTPS = 1;
    private static final int URL_HTTP = 2;

    public static Bitmap[] getBitMapFromUrl(String... imageUrl){

        try {
            Bitmap[] urlToBitmap = new Bitmap[imageUrl.length];
            int count = 0;
            for (String singleImageUrl : imageUrl) {

                URL url = new URL(singleImageUrl);
                InputStream inputStream;
                URLConnection urlConnection = url.openConnection();
                urlConnection.setDoInput(true);
                urlConnection.connect();
                inputStream = urlConnection.getInputStream();

                urlToBitmap[count] = BitmapFactory.decodeStream(inputStream);
                count++;
                inputStream.close();

                if(urlConnection instanceof  HttpURLConnection){
                    ((HttpURLConnection) urlConnection).disconnect();
                }else{
                    ((HttpsURLConnection) urlConnection).disconnect();
                }

            }
            return urlToBitmap;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setOutputMediaFile(Context context, Bitmap[] bitmap, String path, String fileName){
            File directory = new File(Environment.getExternalStorageDirectory() + "/Android/data/"+context.getPackageName()+"/" + path);
            FileOutputStream fileOutputStream = null;
            File file = null;
            int count = 0;
            if(!directory.exists()){
                directory.mkdirs();
            }
            for(Bitmap singleBitmap : bitmap){
                if(singleBitmap != null){
                    file = new File(directory,fileName + count + ".png");

                    if(!file.exists()){
                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        fileOutputStream = new FileOutputStream(file);

                        singleBitmap.compress(Bitmap.CompressFormat.PNG, 50, fileOutputStream);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if(fileOutputStream != null){
                            try {
                                fileOutputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    count++;
                }

            }

    }
}
