package com.example.wxm.weiliapp2.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.wxm.weiliapp2.LishishujuActivity;
import com.example.wxm.weiliapp2.R;
import com.example.wxm.weiliapp2.ShishijiankongActivity;


public class ShouyeFragment extends Fragment implements View.OnClickListener{
    LinearLayout lin_shishijiankong,lin_GPSdingwei,lin_lishishuju;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_shouye,container,false);
        findViews(view);

        return view;
    }
    void findViews(View view){
        lin_shishijiankong=view.findViewById(R.id.Lin_shishijiankong);
        lin_shishijiankong.setOnClickListener(this);

        lin_GPSdingwei=view.findViewById(R.id.Lin_GPSdingwei);
        lin_GPSdingwei.setOnClickListener(this);

        lin_lishishuju=view.findViewById(R.id.Lin_lishishuju);
        lin_lishishuju.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==lin_shishijiankong){
            Intent intent=new Intent(getContext(), ShishijiankongActivity.class);
            startActivity(intent);
        }else if (view==lin_lishishuju){
            Intent intent=new Intent(getContext(), LishishujuActivity.class);
            startActivity(intent);
        }
    }
}
