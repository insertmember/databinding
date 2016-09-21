package com.tongna.databindingtext;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by hxf on 2016/9/21.
 * DataBinding 的在RecyclerView的使用
 */
public class ListActivity extends Activity {

    private RecyclerView mRecyclerView;
    private ArrayList<Student> mData = new ArrayList<Student>() {
        {
            for (int i = 0; i < 10; i++) add(new Student("loader" + i, 18 + i));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new MyAdapter(mData));
    }


    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        private ArrayList<Student> mData = new ArrayList<>();

        private MyAdapter(ArrayList<Student> data) {
            mData.addAll(data);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater
                    .from(viewGroup.getContext()), R.layout.list_item, viewGroup, false);
            ViewHolder holder = new ViewHolder(binding.getRoot());
            holder.setBinding(binding);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {

            viewHolder.getBinding().setVariable(com.tongna.databindingtext.BR.stu, mData.get(i));
            viewHolder.getBinding().executePendingBindings();
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private ViewDataBinding binding;

            public ViewHolder(View itemView) {
                super(itemView);
            }

            public void setBinding(ViewDataBinding binding) {
                this.binding = binding;
            }

            public ViewDataBinding getBinding() {
                return this.binding;
            }
        }
    }
}
