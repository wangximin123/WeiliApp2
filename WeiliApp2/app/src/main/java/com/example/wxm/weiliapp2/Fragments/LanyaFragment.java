package com.example.wxm.weiliapp2.Fragments;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wxm.weiliapp2.R;


public class LanyaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_lanya, container, false);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    void f(){
//        BluetoothManager bluetoothManager= (BluetoothManager) getContext().getSystemService(Context.BLUETOOTH_SERVICE);
//        BluetoothAdapter bluetoothAdapter=bluetoothManager.getAdapter();
        BluetoothAdapter bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        Log.d("result",bluetoothAdapter==null?"aa":"bb");
    }

}
