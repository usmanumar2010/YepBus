package com.example.usman.yepbus;

/**
 * Created by Usman on 4/14/2017.
 */

public class PaymentDetailsClassdDriverNav {
    private String account_Number ;
    private String nameofPayment;
    private String emails ;
    private int paymentsImages;

    public PaymentDetailsClassdDriverNav(String account_Number, String nameofPayment, String emails, int paymentsImages) {
        this.account_Number = account_Number;
        this.nameofPayment = nameofPayment;
        this.emails = emails;
        this.paymentsImages = paymentsImages;
    }

    public String getAccount_Number() {
        return account_Number;
    }

    public void setAccount_Number(String account_Number) {
        this.account_Number = account_Number;
    }

    public String getNameofPayment() {
        return nameofPayment;
    }

    public void setNameofPayment(String nameofPayment) {
        this.nameofPayment = nameofPayment;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public int getPaymentsImages() {
        return paymentsImages;
    }

    public void setPaymentsImages(int paymentsImages) {
        this.paymentsImages = paymentsImages;
    }
}
