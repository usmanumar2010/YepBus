package com.example.usman.yepbus;

/**
 * Created by Usman on 4/12/2017.
 */

public class PaymentClass {
    private int image;
    private String accountNo;
    private  String email;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PaymentClass(int a, String b, String c)
    {
        image=a;
        accountNo=b;
        email=c;
    }
    PaymentClass()
    {

    }
}
