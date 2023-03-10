package dev.t1dmlgus.univaPay.paypay;

import com.univapay.sdk.UnivapaySDK;
import com.univapay.sdk.builders.Request;
import com.univapay.sdk.builders.charge.ChargesBuilders;
import com.univapay.sdk.models.common.*;
import com.univapay.sdk.models.common.auth.AppJWTStrategy;
import com.univapay.sdk.models.errors.UnivapayException;
import com.univapay.sdk.models.response.IssuerToken;
import com.univapay.sdk.models.response.charge.Charge;
import com.univapay.sdk.models.response.transactiontoken.TransactionTokenWithData;
import com.univapay.sdk.settings.UnivapaySettings;
import com.univapay.sdk.types.TransactionTokenType;
import com.univapay.sdk.types.brand.OnlineBrand;
import dev.t1dmlgus.univaPay.util.TokenUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigInteger;

@Service
public class PaypayServiceImpl implements PaypayService{

    String appJWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhcHBfdG9rZW4iLCJpYXQiOjE2NzM4NjIxNjAsIm1lcmNoYW50X2lkIjoiMTFlYzg5NDMtYWQ5OC02MGIyLWFmODQtYzc1NjUxYzI5MjM3Iiwic3RvcmVfaWQiOiIxMWVjODk0NC02ZmE3LWEwYzgtYWZhMi03NzgzYjI2YjZlNTkiLCJkb21haW5zIjpbXSwibW9kZSI6InRlc3QiLCJjcmVhdG9yX2lkIjoiMTFlYzg5NDMtYWQ5OC02MGIyLWFmODQtYzc1NjUxYzI5MjM3IiwidmVyc2lvbiI6MSwianRpIjoiMTFlZDk1ODItMWUyNC04M2IwLWExYmItZTFlOGZhNWI2NzVkIn0.lfKMfq1LhGlLMuCrcD_jtUEt_8DTFvH3imuUmmEKZdU";
    String appJWTSecret = "EEKqcUzzZUKTNFPw7jb9";

    public final String endpoint = "https://api.univapay.com";
    public final Long timeSeconds = 900L;
    public final String origin = "https://secureapi.test.eximbay.com";
    public TokenUtil tokenUtil;


    String CLIENT_ID = "11ec8944-6fa7-a0c8-afa2-7783b26b6e59";
    String EMAIL = "steve@eximbay.com";

    public String REQUESTCURRENCY = "JPY";


    public MoneyLike moneyLike = new MoneyLike(BigInteger.valueOf(1000), "USD");


    public UnivapaySDK UnivapaySDK(){

        UnivapaySettings univapaySettings = new UnivapaySettings()
                .withEndpoint(endpoint)
                .withTimeoutSeconds(timeSeconds)
                .attachOrigin(origin);

        AppJWTStrategy authStrategy = new AppJWTStrategy(appJWT, appJWTSecret);
        return UnivapaySDK.create(authStrategy, univapaySettings);
    }


    /**
     * @steve
     * description: request QR(wiget) to UnivaPay
     *
     */
    @Override
    public void requestQRtoUnivaPay() throws UnivapayException, IOException {


        // UnivapaySDK ??????(??????)
        UnivapaySDK univapay = generateUnivaSDK();


        /**
         *
         * 1. TransactToken ??????
         *
         * 2. charge ??????(create)
         *
         * 3. charge ??????(get)
         *
         * 4. issuer token
         *    - ?????? ?????? ???, ???????????? ????????????(Paypay) ?????? ?????? -> url ??????(get ??????)
         *
         *
         */


        // createTransactToken

        OnlineBrand paypay = OnlineBrand.PAYPAY;
        OnlineBrand test = OnlineBrand.TEST;


        OnlinePayment onlinePaymentData =
                new OnlinePayment(paypay)
                        .withCallMethod(CallMethod.HTTP_POST);



        TransactionTokenWithData transactionToken =
                univapay.createTransactionToken(onlinePaymentData, TransactionTokenType.ONE_TIME)
                        .build()
                        .dispatch();


//        univapay.createCharge(transactionToken.getId(), 20000, "USD");
        ChargesBuilders.CreateChargeRequestBuilder charge1 = univapay.createCharge(transactionToken.getId(), moneyLike);





        TransactionTokenId transactionTokenId = new TransactionTokenId("");


        // ????????????: online
        String paymentMethod = "online";


        String fakeTransactToken = "abc";

        BigInteger amount = BigInteger.valueOf(2000);
        String currency = "usd";

        MoneyLike moneyLike2 = new MoneyLike(amount, currency);


        // builder ??? ?????? ????????? ??????


        //


        // ????????? ??????(??????)
        String storeToken = "";

        // createJWT
        String transactToken = tokenUtil.createJWT(storeToken);

        // request QR to paypay


    }

    private UnivapaySDK generateUnivaSDK() {

        // createSDK
        AppJWTStrategy authStrategy = new AppJWTStrategy(appJWT, appJWTSecret);

        UnivapaySettings univapaySettings = new UnivapaySettings()
                .withEndpoint(endpoint)
                .withTimeoutSeconds(timeSeconds);



        return UnivapaySDK.create(authStrategy, univapaySettings);
    }

    @Override
    public void refund() {

    }

    @Override
    public TransactionTokenWithData createTransactToken() throws UnivapayException, IOException {
        return null;
    }

//    @Override
//    public TransactionTokenWithData createTransactToken() throws UnivapayException, IOException {
//
//
//        transactToken transactToken = new transactToken();
//
//        OnlineBrand onlineBrand = OnlineBrand.PAYPAY;
//
//        // paypay ?????? -> ????????? ?????? ??????
//        UnivapaySDK univapaySDK = generateUnivaSDK();
//
//        OnlinePayment onlinePayment = new OnlinePayment(onlineBrand);
//
//        return univapaySDK.createTransactionToken("steve@eximbay.com", onlinePayment, TransactionTokenType.ONE_TIME)
//                .build()
//                .dispatch();
//
//    }

    @Override
    public void createCharges() {

    }

    @Override
    public void getCharges() {

    }

    @Override
    public void getIssuerToken() {

    }

    @Override
    public void createPayment() throws UnivapayException, IOException {


        // 1. createTransactToken
        OnlineBrand onlineBrand = OnlineBrand.PAYPAY;
        OnlinePayment onlinePayment = new OnlinePayment(onlineBrand);
        onlinePayment.withCallMethod(CallMethod.HTTP_POST);



        // 2. UnivaSDK
        UnivapaySDK univapaySDK = generateUnivaSDK();
        TransactionTokenWithData transactToken = univapaySDK.createTransactionToken(EMAIL, onlinePayment, TransactionTokenType.ONE_TIME)
                .build()
                .dispatch();

        // 3. moneyLike
        MoneyLike requestCharge = new MoneyLike(new BigInteger(String.valueOf(1000)), REQUESTCURRENCY);

        // 4. charge :: ?????? ????????? ?????? ??????.
        Charge charge = univapaySDK.createCharge(transactToken.getId(), requestCharge)
                .build()
                .dispatch();

        System.out.println("charge.getStatus() = " + charge.getStatus());


        // 5. IssureToken
        ChargeId chargeId = charge.getId();
        IssuerToken issuerToken = univapaySDK.getIssuerToken(new StoreId(CLIENT_ID), chargeId)
                .build()
                .dispatch();


        System.out.println("issuerToken = " + issuerToken);
        System.out.println("callInssureToken after > charge.getStatus() = " + charge.getStatus());

    }
}



