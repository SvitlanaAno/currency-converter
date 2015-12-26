package com.sanoshchenko.converter;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sanoshchenko on 12/23/15.
 */
public class Converter_rate {
    private Map<String,Float> uah_conv;
    private Map <String,Float> uah = new HashMap<>();

    public Converter_rate() {
        this.uah_conv = new HashMap<>();
    }

   public Map<String,Float> getUah_conv(){
   //    Map<String,Float>
       return uah_conv;
   }

    public void importFrom(String filename, Context context) {
        try (
               // FileInputStream fileIn=openFileInput("/Users/sanoshchenko/AndroidStudioProjects/Converter/app/src/main/assets/uah_rate");
               // InputStreamReader readerr= new InputStreamReader(fileIn);


               // InputStream is = getActivity().getAssets().open("yourfilename.json");
                //AssetManager manager = context.getAssets();
               // InputStream file = manager.open(filename);

               FileInputStream fis = new FileInputStream(filename);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));)
        {
            String line;
            while((line = reader.readLine())!= null){
                String[] args = line.split("\\|");
                uah_conv.put(args[0], Float.valueOf(args[1]));
            }
        }catch (IOException ioe){
            System.out.printf("Problem loading from %s", filename);
            ioe.printStackTrace();
        }
    }


    public List<String> currList(){
        List <String> listCurr = new ArrayList<>();
        listCurr.addAll(uah_conv.keySet());
        return listCurr;
    }

}
