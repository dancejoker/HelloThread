package com.waitAndNotify;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ddp on 2017/8/27.
 */
public class test {

    public static void transform(Object object,Class clazz){
        if(clazz == Integer.class){
            int i = Integer.parseInt(object.toString());
            System.out.println(i );
        }else if (clazz == Long.class){
            long l = Long.parseLong(object.toString());
            System.out.println(l);
        }
    }
    public static void main(String[] args) throws ParseException {
        List<String> arry = new ArrayList<String>();
        arry.add("eeee");
        arry.add("wdaaf");
        arry.add("dadadadq");
        JSONArray object = JSONArray.fromObject(arry);
        System.out.println(object.toString());
        String s = object.toString();
        JSONArray jsonArray = JSONArray.fromObject(arry);
        List<String> list = jsonArray.toList(jsonArray, String.class, new JsonConfig());
        for(String word : list)
            System.out.println(word);


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat year = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat hour = new SimpleDateFormat("HH");
        Date date = new Date();
        String year_time = year.format(date);
        String hour_time = hour.format(date);
        String time = year_time + " " + hour_time + ":00:00";
        Date s1 = format.parse(time);

        System.out.println(s1.getTime());

        int i = 2;
        long l= 2;
        transform(i,Integer.class);
        transform(2,Long.class);
    }
}
