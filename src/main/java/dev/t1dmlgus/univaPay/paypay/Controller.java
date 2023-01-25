package dev.t1dmlgus.univaPay.paypay;

import com.google.gson.Gson;
import com.univapay.sdk.types.Gateway;
import com.univapay.sdk.utils.RetrofitBuilder;

public class Controller {

    PaypayService paypayService;


    public void echo(){



        paypayService.requestQRtoUnivaPay();

        Class<Gateway> gatewayClass = Gateway.class;
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Gson gson = retrofitBuilder.getGson();


    }

}
