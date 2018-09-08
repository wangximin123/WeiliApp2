package com.example.wxm.weiliapp2;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ShishijiankongAdapter extends RecyclerView.Adapter<ShishijiankongAdapter.ViewHolder> {
    List<Shebei> list;
    public ShishijiankongAdapter(List<Shebei> list){
        this.list=list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.shishijiankong_item,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Shebei shebei=list.get(i);
        viewHolder.tv_name.setText(shebei.getName());
        viewHolder.tv_id.setText(shebei.getId());
        viewHolder.iv_logo.setImageResource(shebei.getLogo());
        viewHolder.tv_wendu.setText("温度："+shebei.getWendu()+"℃"+(shebei.getShidu()==0?"":"\n湿度："+shebei.getShidu()+""));
        viewHolder.tv_wendu.setBackgroundColor((shebei.isNormal()&&shebei.isInline())?Color.parseColor("#3eba91"):Color.parseColor("#ff0000"));
        viewHolder.tv_wendu.setBackgroundColor((shebei.isNormal()&&shebei.isInline())?Color.parseColor("#3eba91"):((shebei.isNormal())?Color.parseColor("#a99999"):Color.parseColor("#ff0000")));
        viewHolder.tv_time.setText(shebei.getTime());
        Log.d("result","温度："+shebei.getWendu()+"℃"+(shebei.getShidu()==0?"":"\n湿度："+shebei.getShidu()+""));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name,tv_id,tv_wendu,tv_time;
        ImageView iv_logo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.TV_name);
            tv_id=itemView.findViewById(R.id.TV_id);
            tv_wendu=itemView.findViewById(R.id.TV_wendu);
            tv_time=itemView.findViewById(R.id.TV_time);
            iv_logo=itemView.findViewById(R.id.IV_logo);
        }
    }
}
