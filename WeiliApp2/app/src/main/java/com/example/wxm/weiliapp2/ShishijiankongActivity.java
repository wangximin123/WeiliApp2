package com.example.wxm.weiliapp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShishijiankongActivity extends AppCompatActivity implements View.OnClickListener{
    List<Shebei> list_shebei=new ArrayList<>();
    RecyclerView recyclerView;
    TextView tv_showAll,tv_showNoNormal,tv_showOutLine,lastTvShow,tv_goBcak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shishijiankong);
        init();
        findViews();
        initComponent();
        tv_showAll.setBackgroundColor(getResources().getColor(R.color.shishijiankongcheck));
        lastTvShow=tv_showAll;
    }
    void showList(List<Shebei> list){
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        ShishijiankongAdapter shishijiankongAdapter=new ShishijiankongAdapter(list);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(shishijiankongAdapter);
    }
    void initComponent(){


        showList(list_shebei);
    }
    void findViews(){
        recyclerView=findViewById(R.id.recyclerView);
        tv_showAll=findViewById(R.id.TV_showAll);
        tv_showNoNormal=findViewById(R.id.TV_showNoNormal);
        tv_showOutLine=findViewById(R.id.TV_showOutLine);
        tv_goBcak=findViewById(R.id.TV_goBcak);

        tv_showAll.setOnClickListener(this);
        tv_showNoNormal.setOnClickListener(this);
        tv_showOutLine.setOnClickListener(this);
        tv_goBcak.setOnClickListener(this);
    }
    void init(){
        Window window = getWindow();
        //设置Window为全透明
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        list_shebei.add(new Shebei("仓库","ID:5689A",08.5f,0,"2016-04-21 19:23:06",R.drawable.shouye,true,true));
        list_shebei.add(new Shebei("运输车","ID:5689A",08.5f,75.3f,"2016-04-21 19:23:06",R.drawable.yunshuche,true,true));
        list_shebei.add(new Shebei("冷藏箱","ID:5689A",08.5f,0,"2016-04-21 19:23:06",R.drawable.gongwenbao,false,true));
        list_shebei.add(new Shebei("冷藏室","ID:5689A",08.5f,0,"2016-04-21 19:23:06",R.drawable.cangkumen,true,false));
        list_shebei.add(new Shebei("仓库","ID:5689A",08.5f,0,"2016-04-21 19:23:06",R.drawable.gongwenbao,true,true));
        list_shebei.add(new Shebei("仓库","ID:5689A",08.5f,0,"2016-04-21 19:23:06",R.drawable.cangkumen,true,true));
    }

    @Override
    public void onClick(View view) {
        if (view==tv_showAll){
            if (lastTvShow!=tv_showAll){
                tv_showAll.setBackgroundColor(getResources().getColor(R.color.shishijiankongcheck));
                lastTvShow.setBackgroundColor(getResources().getColor(R.color.shishijiankongnormal));
                lastTvShow=tv_showAll;

                showList(list_shebei);
            }
        }else if (view==tv_showNoNormal){
            if (lastTvShow!=tv_showNoNormal){
                tv_showNoNormal.setBackgroundColor(getResources().getColor(R.color.shishijiankongcheck));
                lastTvShow.setBackgroundColor(getResources().getColor(R.color.shishijiankongnormal));
                lastTvShow=tv_showNoNormal;
                List<Shebei> list=new ArrayList<>();
                for (Shebei shebei:list_shebei){
                    if (!shebei.isNormal()){
                        list.add(shebei);
                    }
                }
                showList(list);
            }
        }else if (view==tv_showOutLine){
            if (lastTvShow!=tv_showOutLine){
                tv_showOutLine.setBackgroundColor(getResources().getColor(R.color.shishijiankongcheck));
                lastTvShow.setBackgroundColor(getResources().getColor(R.color.shishijiankongnormal));
                lastTvShow=tv_showOutLine;
                List<Shebei> list=new ArrayList<>();
                for (Shebei shebei:list_shebei){
                    if (!shebei.isInline()){
                        list.add(shebei);
                    }
                }
                showList(list);
            }
        }else if (view==tv_goBcak){
            finish();
        }
    }
}
