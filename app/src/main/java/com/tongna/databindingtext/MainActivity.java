package com.tongna.databindingtext;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.tongna.databindingtext.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hxf on 2016/9/20.
 * DataBinding 的基础使用
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.
                setContentView(this, R.layout.activity_main);
        binding.setStu(new Student("loader", "山东莱芜"));
        binding.setNum(3333);
        binding.setStr("这是设置string");
        binding.setError(false);
        binding.setHandlers(new EventHandlers());
        ArrayList<String> list = new ArrayList<String>() {
            {
                add("arraylist");
            }
        };
        binding.setList(list);
        binding.setListKey(0);

        HashMap<String, String> map = new HashMap<String, String>() {
            {
                put("name", "hashmap");
            }
        };
        binding.setMap(map);
//        binding.setMapKey("name");

        String[] array = new String[1];
        array[0] = "array";
        binding.setArray(array);
        binding.setArrayKey(0);
    }



    public class EventHandlers {
        public void handleClick(View view) {
            Toast.makeText(view.getContext(), "you clicked the view", Toast.LENGTH_LONG).show();
        }
        public void fragmentClick(View view) {
            startActivity(new Intent().setClass(MainActivity.this,DataBingFragmentActivity.class));

        }
        public void recyclerViewClick(View view) {
            startActivity(new Intent().setClass(MainActivity.this,ListActivity.class));

        }
    }
}
