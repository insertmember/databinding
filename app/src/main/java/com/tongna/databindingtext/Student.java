package com.tongna.databindingtext;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by hxf on 2016/9/20.
 */
public class Student extends BaseObservable {
    private String name;
    private String addr;
    private int age;

    public Student() {
    }

    public Student(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }
    public Student(int age, String name) {
        this.name = name;
        this.age = age;
    }
    public Student(String name,int age ) {
        this.name = name;
        this.age = age;
    }
    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(com.tongna.databindingtext.BR.age);
    }
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(com.tongna.databindingtext.BR.name);
    }
    @Bindable
    public String getAddr() {
        return this.addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
        notifyPropertyChanged(com.tongna.databindingtext.BR.addr);
    }
}
