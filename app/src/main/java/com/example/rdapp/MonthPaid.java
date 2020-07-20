package com.example.rdapp;

public class MonthPaid {

    private String AccNo, Date, Month3, Amount;


    public MonthPaid(){}


    public MonthPaid(String accNo, String date, String month3, String amount) {
        AccNo = accNo;
        Date = date;
        Month3 = month3;
        Amount = amount;
    }

    public String getAccNo() {
        return AccNo;
    }

    public void setAccNo(String accNo) {
        AccNo = accNo;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getMonth3() {
        return Month3;
    }

    public void setMonth3(String month3) {
        Month3 = month3;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}
