package com.lidan.keylor.zhangyingproject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {


    private TextView ligte ; //亮度
    private TextView color;  //色彩度
    private TextView saturation;//饱和度
    private SeekBar adjust;//调节相应项目的滚动条
    private Button setLight;//调节亮度的按钮
    private Button setColor;//调节色彩度的按钮
    private Button setSaturation;//调节饱和度的按钮

    AjustSubject mAjustSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAjustSubject = new AjustSubject();
        //找到相关控件
        findViews();

        //添加一个默认的监听器
        mAjustSubject.attach(new LightObserver(ligte));

        //添加相应的监听器
        addListeners();



    }

    private void addListeners() {
        //滚动条
        adjust.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mAjustSubject.notify(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        setLight.setOnClickListener(this);
        setColor.setOnClickListener(this);
        setSaturation.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_main_setlight:
                //
                mAjustSubject.detachAll();
                mAjustSubject.attach(new LightObserver(ligte));
                break;
            case R.id.btn_main_setcolor:
                //注册色彩度监听器
                mAjustSubject.detachAll();
                mAjustSubject.attach(new ColorObserver(color));
                break;
            case R.id.btn_main_setsaturation:
                //注册饱和度监听器
                mAjustSubject.detachAll();
                mAjustSubject.attach(new SaturationObserver(saturation));
                break;
            default:
                break;
        }

    }

    private void findViews() {
        ligte = (TextView) findViewById(R.id.tv_main_light);
        color = (TextView) findViewById(R.id.tv_main_color);
        saturation = (TextView) findViewById(R.id.tv_main_saturation);
        adjust = (SeekBar) findViewById(R.id.sb_main_adjust);
        setLight = (Button) findViewById(R.id.btn_main_setlight);
        setColor = (Button) findViewById(R.id.btn_main_setcolor);
        setSaturation = (Button) findViewById(R.id.btn_main_setsaturation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
