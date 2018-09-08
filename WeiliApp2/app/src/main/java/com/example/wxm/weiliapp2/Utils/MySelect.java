package com.example.wxm.weiliapp2.Utils;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.wxm.weiliapp2.R;

import java.util.ArrayList;
import java.util.List;

public class MySelect extends LinearLayout {
    List<String> list_fenzu=new ArrayList<>(),list_mingcheng=new ArrayList<>(),list_leibie=new ArrayList<>();
    Spinner spinner_fenzu,spinner_mingcheng,spinner_leibie;
    ArrayAdapter<String> arrayAdapter_fenzu,arrayAdapter_mingcheng,arrayAdapter_leibie;
    public MySelect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.my_select,this);
        list_fenzu.add("山东为立冷链科技有限公司");
        list_fenzu.add("三鹿奶粉有限公司");
        list_fenzu.add("江南皮革厂");

        list_mingcheng.add("仓库");
        list_mingcheng.add("运输车");
        list_mingcheng.add("保温箱");

        list_leibie.add("仓储设备");
        list_leibie.add("运输设备");

        spinner_fenzu=findViewById(R.id.Spinner_fenzu);
        spinner_mingcheng=findViewById(R.id.Spinner_mingcheng);
        spinner_leibie=findViewById(R.id.Spinner_leibie);

        arrayAdapter_fenzu=new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,list_fenzu);
        spinner_fenzu.setAdapter(arrayAdapter_fenzu);

        arrayAdapter_mingcheng=new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,list_mingcheng);
        spinner_mingcheng.setAdapter(arrayAdapter_mingcheng);

        arrayAdapter_leibie=new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,list_leibie);
        spinner_leibie.setAdapter(arrayAdapter_leibie);
    }
}
