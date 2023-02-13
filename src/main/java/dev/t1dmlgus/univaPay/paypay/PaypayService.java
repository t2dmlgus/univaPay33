package dev.t1dmlgus.univaPay.paypay;

import com.univapay.sdk.models.errors.UnivapayException;
import com.univapay.sdk.models.response.transactiontoken.TransactionTokenWithData;

import java.io.IOException;

public interface PaypayService {

    public void requestQRtoUnivaPay() throws UnivapayException, IOException;

    public void refund();

    public TransactionTokenWithData createTransactToken() throws UnivapayException, IOException;

    public void createCharges();

    public void getCharges();

    public void getIssuerToken();

    void createPayment() throws UnivapayException, IOException;
}
