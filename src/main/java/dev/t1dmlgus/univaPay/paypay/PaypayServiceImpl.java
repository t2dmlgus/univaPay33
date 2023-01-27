package dev.t1dmlgus.univaPay.paypay;

import com.univapay.sdk.UnivapaySDK;
import com.univapay.sdk.builders.charge.ChargesBuilders;
import com.univapay.sdk.models.common.MoneyLike;
import com.univapay.sdk.models.common.TransactionTokenId;
import com.univapay.sdk.models.common.auth.AppJWTStrategy;
import com.univapay.sdk.models.errors.UnivapayException;
import com.univapay.sdk.models.response.charge.Charge;
import com.univapay.sdk.settings.UnivapaySettings;
import com.univapay.sdk.types.AuthType;
import dev.t1dmlgus.univaPay.util.TokenUtil;
import sun.jvm.hotspot.debugger.bsd.aarch64.BsdAARCH64CFrame;

import java.io.IOException;
import java.math.BigInteger;

public class PaypayServiceImpl implements PaypayService{

    String appJWT = "";
    String appJWTSecret = "";

    public final String endpoint = "https://api.univapay.com";
    public final Long timeSeconds = 900L;
    public final String origin = "";
    public TokenUtil tokenUtil;

    public UnivapaySDK univapay;


    public void UnivapaySDK(){

        AppJWTStrategy authStrategy = getAppJWTStrategy();

        UnivapaySettings univapaySettings = new UnivapaySettings()
                .withEndpoint(endpoint)
                .withTimeoutSeconds(timeSeconds)
                .attachOrigin(origin);

        AppJWTStrategy authStrategy = new AppJWTStrategy(appJWT, appJWTSecret);

        UnivapaySDK univapay = UnivapaySDK.create(authStrategy, univapaySettings);
    }


    /**
     * @steve
     * description: request QR(wiget) to UnivaPay
     *
     */
    @Override
    public void requestQRtoUnivaPay() throws UnivapayException, IOException {

        UnivapaySDK univapay = generateUnivaSDK();


        // createTransactToken
        univapay.createTransactionToken();

        TransactionTokenId transactionTokenId = new TransactionTokenId("");


        // 결제수단: online
        String paymentMethod = "online";


        String fakeTransactToken = "abc";

        BigInteger amount = BigInteger.valueOf(2000);
        String currency = "usd";

        MoneyLike moneyLike2 = new MoneyLike(amount, currency);




        ChargesBuilders.CreateChargeRequestBuilder charge = univapaySDK.createCharge(transactionTokenId, moneyLike2);


        Charge dispatch = this.univapay.createCharge(transactionTokenId, moneyLike2)
                .dispatch();




        // builder 를 통해 요청을 보냄


        //


        // 가맹점 조회(토큰)
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
                .withTimeoutSeconds(timeSeconds)
                .attachOrigin(origin);


        return UnivapaySDK.create(authStrategy, univapaySettings);
    }

    @Override
    public void refund() {

    }
}



