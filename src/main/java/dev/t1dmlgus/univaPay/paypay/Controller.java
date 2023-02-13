package dev.t1dmlgus.univaPay.paypay;

import com.google.gson.Gson;
import com.univapay.sdk.models.errors.UnivapayException;
import com.univapay.sdk.types.Gateway;
import com.univapay.sdk.utils.RetrofitBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Controller {

    PaypayService paypayService;

    public Controller(PaypayService paypayService) {
        this.paypayService = paypayService;
    }

    public void echo(){

        Class<Gateway> gatewayClass = Gateway.class;
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Gson gson = retrofitBuilder.getGson();
    }


    @PostMapping("/v1/api/payment")
    public void createPayment() throws UnivapayException, IOException {

        paypayService.createPayment();

    }

}
