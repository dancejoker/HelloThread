package com.Future;

/**
 * Created by ddp on 2017/9/16.
 */
public class RealData implements Data{
    protected  String result;

    public RealData(String para) {
        //RealData的构造可能很慢，需要用户等待很久，这里使用sleep模拟
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 10;++i){
            sb.append(para);
        }
        //这里使用sleep,代替漫长的操作
        try {
            Thread.sleep(3000);
            System.out.println("真实数据处理完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
