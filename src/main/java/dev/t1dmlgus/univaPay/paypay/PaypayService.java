package dev.t1dmlgus.univaPay.paypay;

import com.univapay.sdk.models.errors.UnivapayException;

import java.io.IOException;

public interface PaypayService {

    public void requestQRtoUnivaPay() throws UnivapayException, IOException;

    public void refund();

}
