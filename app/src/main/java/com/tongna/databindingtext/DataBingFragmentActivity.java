package com.tongna.databindingtext;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hxf on 2016/9/20.
 *
 * DataBinding 在 fragment 的使用
 */
public class DataBingFragmentActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MyFragment()).commit();
    }
}
