package com.example.duandovui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.duandovui.R;
import com.example.duandovui.database.MyDatabase;
import com.example.duandovui.model.NguoiDung;

import java.util.List;

import static com.example.duandovui.sharehelper.Share.USER;

public class DiemCaoAdapter extends ArrayAdapter {
    Context context;
    int resoure;
    List<NguoiDung> dsnguoidung;
    MyDatabase myDatabase;
    public DiemCaoAdapter(Context context, int resource, List<NguoiDung> dsnguoidung) {
        super(context, resource, dsnguoidung);
        this.context = context;
        this.resoure = resource;
        this.dsnguoidung = dsnguoidung;
    }
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Hoder hoder ;
        if (convertView == null)
        {
            hoder = new Hoder();

            convertView = LayoutInflater.from(context).inflate(R.layout.item_diem_cao, parent, false);
            hoder.tentop = (TextView) convertView.findViewById(R.id.tvtentop);
            hoder.rank = (ImageView) convertView.findViewById(R.id.imgrank);
            hoder.diemtop= (TextView) convertView.findViewById(R.id.tvdiemtop);
            hoder.huychuong = (TextView) convertView.findViewById(R.id.tvhuychuong) ;
            convertView.setTag(hoder);

        }
        else {
            hoder = (Hoder) convertView.getTag();
        }
        NguoiDung nguoiDung = (NguoiDung) dsnguoidung.get(position);
        if (position==0){
            hoder.tentop.setTextColor(context.getResources().getColor(R.color.maudo));
            hoder.rank.setImageResource(R.drawable.top1);
        }
        if (position==1){
            hoder.tentop.setTextColor(context.getResources().getColor(R.color.cam));
            hoder.rank.setImageResource(R.drawable.top2);

        }
        if (position==2){
            hoder.tentop.setTextColor(context.getResources().getColor(R.color.xanhnhat));
            hoder.rank.setImageResource(R.drawable.top3);


        }
        hoder.tentop.setText(nguoiDung.getUsername()+"    "+":"+"");
        hoder.diemtop.setText(nguoiDung.getDiemcao()+"");
        return convertView;

    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    public static class Hoder{
        TextView tentop,diemtop,huychuong;
        ImageView rank;
    }
}
