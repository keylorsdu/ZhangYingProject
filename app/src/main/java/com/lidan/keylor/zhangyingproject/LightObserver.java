package com.lidan.keylor.zhangyingproject;

import android.content.res.Resources;
import android.widget.TextView;

/**
 * Created by keylor on 15-7-8.
 */
public class LightObserver implements Observer {
    TextView light;

    LightObserver(TextView light) {
        this.light = light;
    }
    @Override
    public void update(int progress) {
        //显示更新亮度
        light.setText("亮度："+progress);//显示亮度
        setCameraLight(progress);

    }//天界摄像头的接口
    private void setCameraLight(int progress) {

    }

}
