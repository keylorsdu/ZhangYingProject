package com.lidan.keylor.zhangyingproject;

import android.widget.TextView;

/**
 * Created by keylor on 15-7-8.
 */
public class ColorObserver implements Observer{
    TextView color;

    ColorObserver(TextView color) {
        this.color = color;
    }
    @Override
    public void update(int progress) {
        //显示更新亮度
        color.setText("色彩度：" + progress);//显示色彩度
        setCameraColor(progress);
    }
    //天界摄像头的接口
    private void setCameraColor(int progress) {

    }


}
