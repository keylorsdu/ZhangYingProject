package com.lidan.keylor.zhangyingproject;

import android.widget.TextView;

/**
 * Created by keylor on 15-7-8.
 */
public class SaturationObserver implements Observer{
    TextView saturation;
    SaturationObserver(TextView saturation) {
        this.saturation = saturation;
    }
    @Override
    public void update(int progress) {
        saturation.setText("饱和度：" + progress);//显示饱和度
        setCameraSaturation(progress);
    }
    //天界摄像头的接口
    private void setCameraSaturation(int progress) {

    }
}
