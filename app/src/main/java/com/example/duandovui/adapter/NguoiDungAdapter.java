package com.example.duandovui.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.duandovui.R;
import com.example.duandovui.database.MyDatabase;
import com.example.duandovui.model.NguoiDung;

import java.util.List;
import static com.example.duandovui.sharehelper.Share.USER;

public class NguoiDungAdapter extends ArrayAdapter {
    Context context;
    int resoure;
    List<NguoiDung> arrnguoidung;
    MyDatabase myDatabase;
    public NguoiDungAdapter(Context context, int resource, List<NguoiDung> arrnguoidung) {
        super(context, resource, arrnguoidung);
        this.context = context;
        this.resoure = resource;
        this.arrnguoidung = arrnguoidung;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Hoder hoder ;
        if (convertView == null)
        {
            hoder = new Hoder();

            convertView = LayoutInflater.from(context).inflate(R.layout.item_nguoi_dung, parent, false);
            hoder.ten = (TextView) convertView.findViewById(R.id.tvten);
            hoder.xoa = (ImageView) convertView.findViewById(R.id.imgDelete);
            hoder.xoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Dialog dialogxoa = new Dialog(context);
                    dialogxoa.setContentView(R.layout.dialog_xoa);
                     TextView tvXoa;
                     Button btnXoa;
                     Button btnHuyXoa;
                    tvXoa = (TextView) dialogxoa.findViewById(R.id.tvXoa);
                    btnXoa = (Button) dialogxoa.findViewById(R.id.btnXoa);
                    btnHuyXoa = (Button) dialogxoa.findViewById(R.id.btnHuyXoa);
                    tvXoa.setText("Bạn có muốn xóa "+"'"+arrnguoidung.get(position).getUsername()+"'");
                    btnXoa.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            myDatabase = new MyDatabase(context);
            myDatabase.deleteNguoiDungByID(arrnguoidung.get(position).getUsername());
            arrnguoidung.remove(position);
            notifyDataSetChanged();
                            Toast.makeText(getContext(),"đã xóa",Toast.LENGTH_SHORT).show();
                            dialogxoa.dismiss();
                        }

                    });
                    btnHuyXoa.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialogxoa.dismiss();
                        }
                    });
                    dialogxoa.show();
//                                myDatabase = new MyDatabase(context);
//            myDatabase.deleteNguoiDungByID(arrnguoidung.get(position).getUsername());
//            arrnguoidung.remove(position);
//            notifyDataSetChanged();
                }
            });

            convertView.setTag(hoder);

        }
        else {
            hoder = (Hoder) convertView.getTag();
        }
        NguoiDung nguoiDung = (NguoiDung) arrnguoidung.get(position);
        hoder.ten.setText(nguoiDung.getUsername()+"");
        if (position==0){
            hoder.xoa.setVisibility(View.INVISIBLE);
            hoder.ten.setTextColor(context.getResources().getColor(R.color.maudo));
            hoder.ten.setText(nguoiDung.getUsername()+" "+"(Admin)");
        }
        if (arrnguoidung.get(position).getUsername().equals(USER))
        {
            hoder.ten.setText(nguoiDung.getUsername()+" "+"\uD83D\uDC48");
        }
        if(!USER.equals(arrnguoidung.get(0).getUsername().toString())){
            hoder.xoa.setVisibility(View.INVISIBLE);
        }
        return convertView;

    }
    public static class Hoder{
        TextView ten;
        ImageView xoa;
    }
}
