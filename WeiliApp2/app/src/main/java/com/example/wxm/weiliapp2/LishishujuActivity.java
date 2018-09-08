package com.example.wxm.weiliapp2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LishishujuActivity extends AppCompatActivity implements View.OnClickListener{
    LineChart lishishuju_lineChart;
    final List<Entry> list_lineChart_wendu=new ArrayList<>();
    final List<Entry> list_lineChart_shidu=new ArrayList<>();
    List<String> list_lineChart_x=new ArrayList<>();
    List<Entry> list_lineChart_wendu1=new ArrayList<>();
    List<Entry> list_lineChart_shidu1=new ArrayList<>();
    final String[] linChart_data={"2016-11-08\n12:15","2016-11-09\n12:15","2016-11-10\n12:15","2016-11-11\n12:15","2016-11-12\n12:15","2016-11-13\n12:15","2016-11-14\n12:15"};
    String[] linChart_data1=null;
    EditText et_again,et_end;
    TextView tv_commit,tv_goBcak;
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    int INT_MIN=0,INT_MAX=0;
    boolean isFirst=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lishishuju);
        init();
        INT_MAX=linChart_data.length-1;
        findViews();
        initList();
//        DateFormat dateFormat=DateFormat.getDateInstance();
//        Log.d("result111","111");
//        try {
//            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//            Date date=simpleDateFormat.parse("2017-08-21");
//            Date date1=simpleDateFormat.parse("2017-09-21");
//            Log.d("result111","aa");
//            Log.d("result111",date1.compareTo(date)+"");
//        } catch (ParseException e) {
//            Log.d("result111",e.getMessage());
//        }

    }
    void init(){
        Window window = getWindow();
        //设置Window为全透明
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
    void initList(){
        list_lineChart_wendu.add(new Entry(0,2));
        list_lineChart_wendu.add(new Entry(1,4));
        list_lineChart_wendu.add(new Entry(2,3.5f));
        list_lineChart_wendu.add(new Entry(3,3));
        list_lineChart_wendu.add(new Entry(4,5));
        list_lineChart_wendu.add(new Entry(5,4));
        list_lineChart_wendu.add(new Entry(6,4));

        list_lineChart_shidu.add(new Entry(0,3));
        list_lineChart_shidu.add(new Entry(1,8));
        list_lineChart_shidu.add(new Entry(2,10));
        list_lineChart_shidu.add(new Entry(3,7));
        list_lineChart_shidu.add(new Entry(4,7.5f));
        list_lineChart_shidu.add(new Entry(5,8));
        list_lineChart_shidu.add(new Entry(6,9));

        linChart_data1=linChart_data;
        initLineChart(list_lineChart_wendu,list_lineChart_shidu);


    }
    void initLineChart(List<Entry> list_lineChart_wendu, List<Entry> list_lineChart_shidu){
        LineDataSet lineDataSet_wendu=new LineDataSet(list_lineChart_wendu,"温度");
        LineDataSet lineDataSet_shidu=new LineDataSet(list_lineChart_shidu,"湿度");
        lineDataSet_wendu.setDrawValues(false);
        lineDataSet_wendu.setColor(Color.parseColor("#70d6ca"));
        lineDataSet_wendu.setDrawFilled(true);
        lineDataSet_wendu.setFillColor(Color.parseColor("#70d6ca"));
        lineDataSet_shidu.setDrawValues(false);
        lineDataSet_shidu.setColor(Color.parseColor("#e29992"));
        lineDataSet_shidu.setDrawFilled(true);
        lineDataSet_shidu.setFillColor(Color.parseColor("#e29992"));


        LineData lineData=new LineData();
        lineData.addDataSet(lineDataSet_wendu);
        lineData.addDataSet(lineDataSet_shidu);

        lishishuju_lineChart.setData(lineData);
//        Matrix matrix=new Matrix();
//        matrix.setScale(2f,1f);
//        lishishuju_lineChart.getViewPortHandler().refresh(matrix,lishishuju_lineChart,false);
        lishishuju_lineChart.setScaleEnabled(false);
        XAxis xAxis=lishishuju_lineChart.getXAxis();

        Log.d("result_int",INT_MIN+"  "+INT_MAX+"  "+linChart_data.length);
        xAxis.setAxisMinValue(INT_MIN);
        xAxis.setAxisMaxValue(INT_MAX);
        Log.d("result_length",linChart_data1.length+"");
        xAxis.setLabelCount(linChart_data1.length-2);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        final int[] show=new int[INT_MAX-INT_MIN+1];
        Log.d("result_value",linChart_data.length+"------------");
        final String[] finalLiData = linChart_data1;
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                if (value>=INT_MIN&&value<=INT_MAX){

                    if (value==(int)value){
                        Log.d("result_value",value+"  "+INT_MIN+"  "+linChart_data[(int)value+INT_MIN]);
                        return linChart_data[(int)value];
                    }
                    return "";
                }
//                for (int i=0;i<linChart_data.length;i++){
//                    if (value==(float)i){
//                        return linChart_data[i];
//                    }
//                }
                return "";
            }
        });
        lishishuju_lineChart.invalidate();
    }

    void findViews(){
        lishishuju_lineChart=findViewById(R.id.Lishishuju_lineChart);
        et_again=findViewById(R.id.ET_again);
        et_end=findViewById(R.id.ET_end);
        tv_commit=findViewById(R.id.TV_commit);
        tv_goBcak=findViewById(R.id.TV_goBcak);

        tv_commit.setOnClickListener(this);
        tv_goBcak.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==tv_commit){
            list_lineChart_x.clear();
            list_lineChart_wendu1.clear();
            list_lineChart_shidu1.clear();
            String sAgain=et_again.getText().toString();
            String sEnd=et_end.getText().toString();
            Date dAgain=null,dEnd=null;
            if (sAgain==null){
                //INT_MIN=0;
                sAgain=linChart_data[0];
            }
            if (sEnd==null){
                //INT_MAX=linChart_data.length-1;
                sEnd=linChart_data[linChart_data.length-1];
            }
            try {
                dAgain=simpleDateFormat.parse(sAgain);
                dEnd=simpleDateFormat.parse(sEnd);
                for (int i=0;i<linChart_data.length;i++){
                    String s=linChart_data[i];
                    Date date=simpleDateFormat.parse(s.substring(0,10));
                    Log.d("result111",s.substring(0,10)+".."+sAgain+":"+date.compareTo(dAgain)+"==="+date.compareTo(dEnd)+",,"+sEnd);
                    if (date.compareTo(dAgain)>=0&&date.compareTo(dEnd)<=0){
                        list_lineChart_x.add(s);
                        list_lineChart_wendu1.add(list_lineChart_wendu.get(i));
                        list_lineChart_shidu1.add(list_lineChart_shidu.get(i));
                        if (isFirst){
                            INT_MIN=i;
                            isFirst=false;
                        }
                        INT_MAX=i;
                    }

//{"2016-11-08\n12:15","2016-11-09\n12:15","2016-11-10\n12:15","2016-11-11\n12:15","2016-11-12\n12:15","2016-11-13\n12:15","2016-11-14\n12:15"};
//    0                     1                   2                   3                   4                   5                   6
                    Log.d("result222",s.substring(0,10)+"  "+date.compareTo(simpleDateFormat.parse(sAgain))+"  "+sAgain);
                }
                for (String s1:list_lineChart_x){
                    Log.d("result_haha",s1);
                }
                Log.d("result_haha","--------------"+list_lineChart_x.size());
                linChart_data1=new String[list_lineChart_x.size()];
                for (int i=0;i<linChart_data1.length;i++){
                    linChart_data1[i]=list_lineChart_x.get(i);
                }
                Log.d("linChart_data12","::"+linChart_data1.length);
                initLineChart(list_lineChart_wendu1,list_lineChart_shidu1);
                isFirst=true;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if (view==tv_goBcak){
            finish();
        }
    }
}
