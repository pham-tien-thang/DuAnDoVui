package com.example.duandovui.activity;

public class Chaoprecenter {
   private Chaointerface itf;
        public Chaoprecenter(Chaointerface itf){
            this.itf = itf;
        }

        void chuyenmh(){

           itf.dataBase();
           itf.toMhchinh();

            }
        }


