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
import java.util.List;
import java.util.Random;

public class ChoiGameActivity extends AppCompatActivity {
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
    int trogiup3;
    int trogiup1;
    int socauhoi=0;
    int number;
    int somang;
    int trogiup2;
    Boolean chonnv;
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
        Listcauhoi=myDatabase.laycauhoi();
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
   hienthi();
   tvCuuTro.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           if (trogiup1>0){
               Boolean chonnv = false;
               trogiup1--;
               tvCuuTro.setText("XXX");
               showdialogCuuTro();
           }
           else {
               Toast.makeText(getApplicationContext(),"bạn đã dùng Cứu trợ",Toast.LENGTH_LONG).show();
           }
       }
   });
   tvDoiCauHoi.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           if (trogiup3>0){
               trogiup3--;
               tvDoiCauHoi.setText("XXX");
               socauhoi--;
               hienthi();
           }
           else {
               Toast.makeText(getApplicationContext(),"bạn đã dùng đổi câu hỏi",Toast.LENGTH_LONG).show();
           }
       }
   });
   tv50.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           if (trogiup2>0){
               trogiup2--;
               tv50.setText("XXX");
               String dapandung = Listcauhoi.get(number).getDapandung();
               if (tvA.getText().equals(dapandung)){
                   Random rd50 = new Random();   // khai báo 1 đối tượng Random
                   int random50 = rd50.nextInt(3)+1;
                   if(random50==1){
                       tvC.setText("");
                       tvD.setText("");
                   }
                   else if(random50==2){
                       tvB.setText("");
                       tvD.setText("");
                   }
                   else if(random50==3){
                       tvB.setText("");
                       tvC.setText("");
                   }
               }
               else if(tvB.getText().equals(dapandung)){
                   Random rd50 = new Random();   // khai báo 1 đối tượng Random
                   int random50 = rd50.nextInt(3)+1;
                   if(random50==1){
                       tvD.setText("");
                       tvC.setText("");
                   }
                   else if(random50==2){
                       tvA.setText("");
                       tvD.setText("");
                   }
                   else if(random50==3){
                       tvA.setText("");
                       tvC.setText("");
                   }
               }
               else if(tvC.getText().equals(dapandung)){
                   Random rd50 = new Random();   // khai báo 1 đối tượng Random
                   int random50 = rd50.nextInt(3)+1;
                   if(random50==1){
                       tvD.setText("");
                       tvB.setText("");
                   }
                   else if(random50==2){
                       tvA.setText("");
                       tvD.setText("");
                   }
                   else if(random50==3){
                       tvA.setText("");
                       tvB.setText("");
                   }
               }
               else if(tvD.getText().equals(dapandung)){
                   Random rd50 = new Random();   // khai báo 1 đối tượng Random
                   int random50 = rd50.nextInt(3)+1;
                   if(random50==1){
                       tvB.setText("");
                       tvC.setText("");
                   }
                   else if(random50==2){
                       tvA.setText("");
                       tvC.setText("");
                   }
                   else if(random50==3){
                       tvA.setText("");
                       tvB.setText("");
                   }
               }
           }
           else {
               Toast.makeText(getApplicationContext(),"bạn đã dùng 50:50",Toast.LENGTH_LONG).show();
           }
       }
   });

   tvA.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           tvA.setBackgroundColor(getResources().getColor(R.color.xam));
           tvB.setBackgroundColor(getResources().getColor(R.color.trang));
           tvD.setBackgroundColor(getResources().getColor(R.color.trang));
           tvC.setBackgroundColor(getResources().getColor(R.color.trang));
           if(tvA.getText().equals(Listcauhoi.get(number).getDapandung())){
               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       hienthi();
                   }
               }, 500);
           }
           else{
               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       if (somang>0){
                       somang--;
                   showdialogsai();}
                       else {showdialogGameover();}
                   }
               }, 500);
           }
       }
   });
        tvB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvB.setBackgroundColor(getResources().getColor(R.color.xam));
                tvA.setBackgroundColor(getResources().getColor(R.color.trang));
                tvD.setBackgroundColor(getResources().getColor(R.color.trang));
                tvC.setBackgroundColor(getResources().getColor(R.color.trang));
                if(tvB.getText().equals(Listcauhoi.get(number).getDapandung())){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            hienthi();
                        }
                    }, 500);
                }
                else{
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (somang>0){
                                somang--;
                                showdialogsai();}
                            else {showdialogGameover();}
                        }
                    }, 500);
                }

            }
        });
        tvC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvB.setBackgroundColor(getResources().getColor(R.color.trang));
                tvA.setBackgroundColor(getResources().getColor(R.color.trang));
                tvD.setBackgroundColor(getResources().getColor(R.color.trang));
                tvC.setBackgroundColor(getResources().getColor(R.color.xam));
                if(tvC.getText().equals(Listcauhoi.get(number).getDapandung())){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            hienthi();
                        }
                    }, 500);

                }
                else{
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (somang>0){
                                somang--;
                                showdialogsai();}
                            else {showdialogGameover();}
                        }
                    }, 500);
                }
            }
        });
        tvD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvB.setBackgroundColor(getResources().getColor(R.color.trang));
                tvA.setBackgroundColor(getResources().getColor(R.color.trang));
                tvC.setBackgroundColor(getResources().getColor(R.color.trang));
                tvD.setBackgroundColor(getResources().getColor(R.color.xam));
                if(tvD.getText().equals(Listcauhoi.get(number).getDapandung())){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            hienthi();
                        }
                    }, 500);
                }
                else{
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (somang>0){
                                somang--;
                                showdialogsai();}
                            else {showdialogGameover();}
                        }
                    }, 500);
                }
            }
        });
    }
    public  void  hienthi(){
        socauhoi++;
        Random rd = new Random();   // khai báo 1 đối tượng Random
         number = rd.nextInt(50);
        Random rd2 = new Random();   // khai báo 1 đối tượng Random
        int number2 = rd.nextInt(4)+1;
        tvSoCauHoi.setText("Câu số :"+socauhoi);
        tvDiem.setText(socauhoi+"");
        tvCauHoi.setText(Listcauhoi.get(number).getNoidung());
        tvB.setBackgroundColor(getResources().getColor(R.color.trang));
        tvA.setBackgroundColor(getResources().getColor(R.color.trang));
        tvD.setBackgroundColor(getResources().getColor(R.color.trang));
        tvC.setBackgroundColor(getResources().getColor(R.color.trang));
        if(number2==1){
            tvA.setText(Listcauhoi.get(number).getDapandung());
            tvB.setText(Listcauhoi.get(number).getDapan2());
            tvC.setText(Listcauhoi.get(number).getDapan3());
            tvD.setText(Listcauhoi.get(number).getDapan4());
        }
        else if (number2==2){
            tvA.setText(Listcauhoi.get(number).getDapan2());
            tvB.setText(Listcauhoi.get(number).getDapandung());
            tvC.setText(Listcauhoi.get(number).getDapan4());
            tvD.setText(Listcauhoi.get(number).getDapan3());
        }
        else if (number2==3){
            tvA.setText(Listcauhoi.get(number).getDapan2());
            tvB.setText(Listcauhoi.get(number).getDapan3());
            tvC.setText(Listcauhoi.get(number).getDapandung());
            tvD.setText(Listcauhoi.get(number).getDapan4());
        }
        else if (number2==4){
            tvA.setText(Listcauhoi.get(number).getDapan2());
            tvB.setText(Listcauhoi.get(number).getDapan3());
            tvC.setText(Listcauhoi.get(number).getDapan4());
            tvD.setText(Listcauhoi.get(number).getDapandung());
        }

    }
    public void showdialogsai(){
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
    public void showdialogGameover(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_game_over);
         Button btnThoatDialogGameOver;
        btnThoatDialogGameOver = (Button) dialog.findViewById(R.id.btnThoatDialogGameOver);
        btnThoatDialogGameOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                finish();
            }
        });
        dialog.show();

    }
    public  void showdialogCuuTro(){
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
                    tvTrangthai.setText("đang suy nghĩ...\uD83D\uDE3E "+"("+"100% luôn \uD83D\uDC4C "+")");
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
}
