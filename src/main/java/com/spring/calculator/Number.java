package com.spring.calculator;

import jakarta.validation.constraints.Min;

public class Number {
    @Min(value = 0, message = "Validacijos klaida: skaicius negali buti neigiamas")
    private int sk1;
    @Min(value = 0, message = "Validacijos klaida: skaicius negali buti neigiamas")
    private int sk2;
    private  String zenklas;
    private  int rezultatas;

    public Number(){
    }
    public Number(int sk1, int sk2, String zenklas, int rezultatas){
        this.sk1 = sk1;
        this.sk2 = sk2;
        this.zenklas = zenklas;
        this.rezultatas = rezultatas;
    }
    public int getSk1() {
        return sk1;
    }

    public void setSk1(int sk1) {
        this.sk1 = sk1;
    }

    public void setSk2(int sk2) {
        this.sk2 = sk2;
    }

    public void setZenklas(String zenklas) {
        this.zenklas = zenklas;
    }

    public void setRezultatas(int rezultatas) {
        this.rezultatas = rezultatas;
    }

    public int getSk2() {
        return sk2;
    }

    public String getZenklas() {
        return zenklas;
    }

    public int getRezultatas() {
        return rezultatas;
    }


}
