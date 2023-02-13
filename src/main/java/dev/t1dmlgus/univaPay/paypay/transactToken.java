package dev.t1dmlgus.univaPay.paypay;

public class transactToken {

    private String payment_type;
    private String type;
    private String data;
    private String brand;
    private String call_method;


    public transactToken() {
        this.payment_type = "online";
        this.type = "one_time";
        this.data = "";
        this.brand = "pay_pay_online";
        this.call_method = "http_post";
    }
}
