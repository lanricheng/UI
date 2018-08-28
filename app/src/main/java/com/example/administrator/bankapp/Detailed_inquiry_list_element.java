package com.example.administrator.bankapp;

public class Detailed_inquiry_list_element {

    private String pay_time;
    private String pay_style;
    private double pay_value;

    public double getPayValue() {
        return pay_value;
    }

    public String getPayTime() {
        return pay_time;
    }

    public String getPayStyle() {
        return pay_style;
    }

    public Detailed_inquiry_list_element(String time, String paystyle,double value){
        this.pay_time  = time;
        this.pay_style = paystyle;
        this.pay_value = value;
    }


}
