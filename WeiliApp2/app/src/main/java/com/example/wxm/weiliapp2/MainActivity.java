package com.example.wxm.weiliapp2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.wxm.weiliapp2.Fragments.LanyaFragment;
import com.example.wxm.weiliapp2.Fragments.ShebeiFragment;
import com.example.wxm.weiliapp2.Fragments.ShouyeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    LinearLayout lin_Bottom_shouye,lin_Bottom_shebei,lin_Bottom_lanya,lin_Bottom_yonghu;
    LinearLayout lastLin=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        findViews();
        replaceShow(R.id.Lin_show,new ShouyeFragment());
//        f();
    }
//    void f(){
////        BluetoothManager bluetoothManager= (BluetoothManager) getContext().getSystemService(Context.BLUETOOTH_SERVICE);
////        BluetoothAdapter bluetoothAdapter=bluetoothManager.getAdapter();
//        //<uses-permission android:name="android.permission.BLUETOOTH" />
//        //    <uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
//        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.BLUETOOTH,Manifest.permission.BLUETOOTH_ADMIN},1);
//        BluetoothAdapter bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
//        Log.d("result",bluetoothAdapter==null?"aa":"bb");
//        if (!bluetoothAdapter.isEnabled()){
//            Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            startActivity(intent);
//        }
//        Set<BluetoothDevice> set = bluetoothAdapter.getBondedDevices();
//        Log.d("result",set.size()+"");
//        for (BluetoothDevice bluetoothDevice:set){
//            Log.d("result",bluetoothDevice.getName()+"  "+bluetoothDevice.getAddress());
//        }
//    }
    void findViews(){
        lin_Bottom_shouye=findViewById(R.id.Lin_Bottom_shouye);
        lin_Bottom_shouye.setOnClickListener(this);

        lin_Bottom_shebei=findViewById(R.id.Lin_Bottom_shebei);
        lin_Bottom_shebei.setOnClickListener(this);

        lin_Bottom_lanya=findViewById(R.id.Lin_Botton_lanya);
        lin_Bottom_lanya.setOnClickListener(this);

        lin_Bottom_yonghu=findViewById(R.id.Lin_Bottom_yonghu);
        lin_Bottom_yonghu.setOnClickListener(this);

        lastLin=lin_Bottom_shouye;
    }
    void replaceShow(int id, Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(id,fragment);
        fragmentTransaction.commit();
    }

    void init(){
        Window window = getWindow();
        //设置Window为全透明
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    @Override
    public void onClick(View view) {
        if (view==lin_Bottom_shouye){
            replaceShow(R.id.Lin_show,new ShouyeFragment());
            if (lastLin!=lin_Bottom_shouye){
                lastLin.setBackgroundColor(getResources().getColor(R.color.nomarl));
                lin_Bottom_shouye.setBackgroundColor(getResources().getColor(R.color.check));
                lastLin=lin_Bottom_shouye;
            }
        }else if (view==lin_Bottom_shebei){
            replaceShow(R.id.Lin_show,new ShebeiFragment());
            if (lastLin!=lin_Bottom_shebei){
                lastLin.setBackgroundColor(getResources().getColor(R.color.nomarl));
                lin_Bottom_shebei.setBackgroundColor(getResources().getColor(R.color.check));
                lastLin=lin_Bottom_shebei;
            }
        }else if (view==lin_Bottom_lanya){
            replaceShow(R.id.Lin_show,new LanyaFragment());
            if (lastLin!=lin_Bottom_lanya){
                lastLin.setBackgroundColor(getResources().getColor(R.color.nomarl));
                lin_Bottom_lanya.setBackgroundColor(getResources().getColor(R.color.check));
                lastLin=lin_Bottom_lanya;
            }
        }else if (view==lin_Bottom_yonghu){
            replaceShow(R.id.Lin_show,new YonghuFragment());
            if (lastLin!=lin_Bottom_yonghu){
                lastLin.setBackgroundColor(getResources().getColor(R.color.nomarl));
                lin_Bottom_yonghu.setBackgroundColor(getResources().getColor(R.color.check));
                lastLin=lin_Bottom_yonghu;
            }
        }
    }
}
