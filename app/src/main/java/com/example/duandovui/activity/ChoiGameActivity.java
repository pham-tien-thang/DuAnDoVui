package com.example.duandovui.activity;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duandovui.R;
import com.example.duandovui.database.MyDatabase;
import com.example.duandovui.model.CauHoi;
import com.example.duandovui.model.NguoiDung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import  static com.example.duandovui.sharehelper.Share.USER;
public class ChoiGameActivity extends AppCompatActivity implements ChoiGameInterface{
     TextView tvDiem;
    TextView tvCuuTro;
     TextView tv50;
    TextView tvDoiCauHoi;
     TextView tvSoCauHoi;
  LinearLayout linearLayout;
    TextView tvCauHoi;
     TextView tvA;
    TextView tvB;
    TextView tvC;
    TextView tvD;
    public static int trogiup3;
    public static int trogiup1;
    int socauhoi=0;
    int number;
    public static  int somang;
    public static int trogiup2;
    Boolean chonnv;
    MyDatabase myDatabase2;
    ChoiGamePrecenter pre;
    List<String> dapan;
    public  List<CauHoi> Listcauhoi = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choi_game);
        MyDatabase myDatabase = new MyDatabase(ChoiGameActivity.this);
        myDatabase.openDataBase();
         somang=2;
        trogiup1=1;
        trogiup2 = 1;
        trogiup3=1;
        chonnv = false;
        pre  = new ChoiGamePrecenter(this);
        Listcauhoi=myDatabase.laycauhoi();
        myDatabase = new MyDatabase(this);
        tvDiem = (TextView) findViewById(R.id.tvDiem);
        tvCuuTro = (TextView) findViewById(R.id.tvCuuTro);
        tv50 = (TextView) findViewById(R.id.tv50);
        tvDoiCauHoi = (TextView) findViewById(R.id.tvDoiCauHoi);
        tvSoCauHoi = (TextView) findViewById(R.id.tvSoCauHoi);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        tvCauHoi = (TextView) findViewById(R.id.tvCauHoi);
        tvA = (TextView) findViewById(R.id.tvA);
        tvB = (TextView) findViewById(R.id.tvB);
        tvC = (TextView) findViewById(R.id.tvC);
        tvD = (TextView) findViewById(R.id.tvD);
  pre.hienthi();
   tvCuuTro.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           tvCuuTro.setText("XXX");
          pre.cuutro1();

       }
   });
   tvDoiCauHoi.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
          pre.doicauhoi();
       }
   });
   tv50.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           tv50.setText("XXX");
          pre.trogiup2(tvA.getText().toString(),tvB.getText().toString()
                  ,tvC.getText().toString(),tvD.getText().toString(),Listcauhoi.get(number).getDapandung());
       }
   });

   tvA.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           pre.viewclick("a",tvA.getText().toString(),Listcauhoi.get(number).getDapandung());
       }
   });
        tvB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pre.viewclick("b",tvB.getText().toString(),Listcauhoi.get(number).getDapandung());

            }
        });
        tvC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pre.viewclick("c",tvC.getText().toString(),Listcauhoi.get(number).getDapandung());
            }
        });
        tvD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pre.viewclick("d",tvD.getText().toString(),Listcauhoi.get(number).getDapandung());
            }
        });
    }
    @Override
    public  void  hienthi(){
        socauhoi++;
        Random rd = new Random();   // khai báo 1 đối tượng Random
         number = rd.nextInt(50);
         dapan = new ArrayList<>();
         dapan.add(Listcauhoi.get(number).getDapandung());
        dapan.add(Listcauhoi.get(number).getDapan2());
        dapan.add(Listcauhoi.get(number).getDapan3());
        dapan.add(Listcauhoi.get(number).getDapan4());
        tvSoCauHoi.setText("Câu số :"+socauhoi);
        tvDiem.setText(socauhoi+"");
        tvCauHoi.setText(Listcauhoi.get(number).getNoidung());
        tvB.setBackgroundColor(getResources().getColor(R.color.trang));
        tvA.setBackgroundColor(getResources().getColor(R.color.trang));
        tvD.setBackgroundColor(getResources().getColor(R.color.trang));
        tvC.setBackgroundColor(getResources().getColor(R.color.trang));
        Collections.shuffle(dapan);
            tvA.setText(dapan.get(0));
            tvB.setText(dapan.get(1));
            tvC.setText(dapan.get(2));
            tvD.setText(dapan.get(3));

    }

    @Override
    public void trogiup1() {
        if (trogiup1>0){
            Boolean chonnv = false;
            trogiup1--;
            tvCuuTro.setText("XXX");
            pre.showcuutro();
        }
        else {
            Toast.makeText(getApplicationContext(),"bạn đã dùng Cứu trợ",Toast.LENGTH_LONG).show();
        }
    }



    @Override
    public void trogiup3() {
        tvDoiCauHoi.setText("XXX");
        socauhoi--;

    }


    @Override
    public void showfalse() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_tlsai);
        TextView tvSoMang;
        Button btnThoatDialogTLSai;

        tvSoMang = (TextView) dialog.findViewById(R.id.tvSoMang);
        btnThoatDialogTLSai = (Button) dialog.findViewById(R.id.btnThoatDialogTLSai);
        tvSoMang.setText("bạn còn "+somang+" lần ngu");
        btnThoatDialogTLSai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }



    @Override
    public void showtrogiup3() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_ho_tro);
        ImageView imgNv1;
        ImageView imgNv2;
        ImageView imgNv3;
        ImageView imgNv4;
        final TextView tvTrangthai;
        Button btnThoatDialogCuuTro;
        imgNv1 = (ImageView) dialog.findViewById(R.id.imgNv1);
        imgNv2 = (ImageView) dialog.findViewById(R.id.imgNv2);
        imgNv3 = (ImageView) dialog.findViewById(R.id.imgNv3);
        imgNv4 = (ImageView) dialog.findViewById(R.id.imgNv4);
        tvTrangthai = (TextView) dialog.findViewById(R.id.tvTrangthai);
        btnThoatDialogCuuTro = (Button) dialog.findViewById(R.id.btnThoatDialogCuuTro);
        tvTrangthai.setText("___");
        imgNv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chonnv==false)
                {chonnv = true;
                    tvTrangthai.setText("đang suy nghĩ...\uD83E\uDD14"+"("+"90% trả lời được"+")");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Random rdcuutro = new Random();   // khai báo 1 đối tượng Random
                            int cutro = rdcuutro.nextInt(100)+1;
                            if(cutro<11){
                                tvTrangthai.setText("YASUO không biết câu này");
                            }
                            else {
                                tvTrangthai.setText("YASUO chọn "+"'"+ Listcauhoi.get(number).getDapandung()+"'");}
                        }
                    }, 2000);}
                else {
                    Toast.makeText(getApplicationContext(),"Bạn đã chọn 1 đứa rồi",Toast.LENGTH_LONG).show();
                }
            }
        });
        imgNv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chonnv==false)
                {chonnv = true;
                    tvTrangthai.setText("đang suy nghĩ...\uD83E\uDD14 "+"("+"25% trả lời được"+")");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Random rdcuutro = new Random();   // khai báo 1 đối tượng Random
                            int cutro = rdcuutro.nextInt(100)+1;
                            if(cutro>26){
                                tvTrangthai.setText("Chaien không biết " +"\uD83D\uDE36");
                            }
                            else {
                                tvTrangthai.setText("Chaien chọn "+"'"+ Listcauhoi.get(number).getDapandung()+"'");}
                        }
                    }, 3700);}
                else {
                    Toast.makeText(getApplicationContext(),"Bạn đã chọn 1 đứa rồi",Toast.LENGTH_LONG).show();
                }
            }
        });
        imgNv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chonnv==false)
                {chonnv = true;
                    tvTrangthai.setText("đang suy nghĩ...\uD83D\uDE3E "+"("+"100% \uD83D\uDC4C "+")");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            tvTrangthai.setText("Thắng chọn đáp án "+"'"+ Listcauhoi.get(number).getDapandung()+"'"+" nhé \uD83D\uDE06");
                        }
                    }, 2000);}
                else {
                    Toast.makeText(getApplicationContext(),"Bạn đã chọn 1 đứa rồi",Toast.LENGTH_LONG).show();
                }
            }
        });
        imgNv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chonnv==false)
                {chonnv = true;
                    tvTrangthai.setText("đang suy nghĩ...\uD83E\uDD14 "+"("+"60% trả lời được"+")");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Random rdcuutro = new Random();   // khai báo 1 đối tượng Random
                            int cutro = rdcuutro.nextInt(100)+1;
                            if(cutro<41){
                                tvTrangthai.setText("IQ vô cực không đoán được " +"\uD83D\uDE36");
                            }
                            else {
                                tvTrangthai.setText("IQ vô cực chọn "+"'"+ Listcauhoi.get(number).getDapandung()+"'");}
                        }
                    }, 3000);}
                else {
                    Toast.makeText(getApplicationContext(),"Bạn đã chọn 1 đứa rồi",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnThoatDialogCuuTro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvTrangthai.getText().equals("___")){
                    Toast.makeText(getApplicationContext(),"Hãy chọn nhân vật",Toast.LENGTH_LONG).show();
                }
                else{
                    dialog.dismiss();}
            }
        });
        dialog.show();

    }

    @Override
    public void showgameover() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_game_over);
        Button btnThoatDialogGameOver;
        btnThoatDialogGameOver = (Button) dialog.findViewById(R.id.btnThoatDialogGameOver);
        btnThoatDialogGameOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabase2  = new MyDatabase(ChoiGameActivity.this);
                myDatabase2.openDataBase();
        int diemvanchoi = Integer.parseInt(tvDiem.getText().toString().trim()) ;
        String us = USER;
        int diemcao = myDatabase2.getdiem(us);
        if (diemcao<diemvanchoi){
            myDatabase2.updatenguoidung(us,diemvanchoi);
            Toast.makeText(getApplicationContext(),"Bạn đạt kỷ lục cá nhân",Toast.LENGTH_SHORT).show();
        }
                dialog.dismiss();
                finish();
            }
        });
        dialog.show();
        dialog.setCancelable(false);
    }

    @Override
    public void setbackgroundA() {
        tvA.setBackgroundColor(getResources().getColor(R.color.xam));
        tvB.setBackgroundColor(getResources().getColor(R.color.trang));
        tvD.setBackgroundColor(getResources().getColor(R.color.trang));
        tvC.setBackgroundColor(getResources().getColor(R.color.trang));
    }

    @Override
    public void setbackgroundb() {
        tvB.setBackgroundColor(getResources().getColor(R.color.xam));
        tvA.setBackgroundColor(getResources().getColor(R.color.trang));
        tvD.setBackgroundColor(getResources().getColor(R.color.trang));
        tvC.setBackgroundColor(getResources().getColor(R.color.trang));
    }

    @Override
    public void setbackgroundc() {
        tvB.setBackgroundColor(getResources().getColor(R.color.trang));
        tvA.setBackgroundColor(getResources().getColor(R.color.trang));
        tvD.setBackgroundColor(getResources().getColor(R.color.trang));
        tvC.setBackgroundColor(getResources().getColor(R.color.xam));
    }

    @Override
    public void setbackgroundd() {
        tvB.setBackgroundColor(getResources().getColor(R.color.trang));
        tvA.setBackgroundColor(getResources().getColor(R.color.trang));
        tvC.setBackgroundColor(getResources().getColor(R.color.trang));
        tvD.setBackgroundColor(getResources().getColor(R.color.xam));
    }

    @Override
    public void hettrogiup1() {
        Toast.makeText(getApplicationContext(),"bạn đã dùng cứu trợ",Toast.LENGTH_LONG).show();
    }

    @Override
    public void hettrogiup2() {
        Toast.makeText(getApplicationContext(),"bạn đã dùng 50:50",Toast.LENGTH_LONG).show();
    }

    @Override
    public void hettrogiup3() {
        Toast.makeText(getApplicationContext(),"bạn đã dùng đổi câu hỏi",Toast.LENGTH_LONG).show();
    }

    @Override
    public void xoaAB() {
            tvB.setText("");
            tvA.setText("");
    }

    @Override
    public void XoaAC() {
                tvC.setText("");
                tvA.setText("");
        }



    @Override
    public void XoaAD() {
        tvD.setText("");
        tvA.setText("");
    }

    @Override
    public void XoaBC() {
        tvB.setText("");
        tvC.setText("");
    }
    @Override
    public void XoaBD() {
        tvB.setText("");
        tvD.setText("");
    }
    @Override
    public void XoaDC() {
        tvC.setText("");
        tvD.setText("");
    }


}