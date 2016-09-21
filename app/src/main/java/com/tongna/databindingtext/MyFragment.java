package com.tongna.databindingtext;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Created by hxf on 2016/9/20.
 */
public class MyFragment extends Fragment {

    private Student mStu;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        com.tongna.databindingtext.Custom binding = DataBindingUtil.inflate(inflater, R.layout.frag_layout, container, false);
        mStu = new Student(20, "loader");
        binding.setStu(mStu);
        binding.setFrag(this);
        return binding.getRoot();
    }
    public void click(View view) {
        mStu.setName("qibin");
        mStu.setAge(18);
    }
}
