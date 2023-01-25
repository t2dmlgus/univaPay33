package dev.t1dmlgus.univaPay.paypay;

import com.univapay.sdk.UnivapaySDK;
import com.univapay.sdk.builders.charge.ChargesBuilders;
import com.univapay.sdk.models.common.auth.AppJWTStrategy;
import com.univapay.sdk.settings.UnivapaySettings;
import dev.t1dmlgus.univaPay.util.TokenUtil;
import org.jetbrains.annotations.NotNull;

public class PaypayServiceImpl implements PaypayService{

    public final String endpoint = "https://api.univapay.com";
    public final Long timeSeconds = 900L;
    public final String origin = "";
    public TokenUtil tokenUtil;


    public static void UnivapaySDK(){

//        AppJWTStrategy authStrategy = getAppJWTStrategy();
//
//        UnivapaySettings univapaySettings = new UnivapaySettings()
//                .withEndpoint(endpoint)
//                .withTimeoutSeconds(timeSeconds)
//                .attachOrigin(origin);
//
//        UnivapaySDK univapay = UnivapaySDK.create(authStrategy, univapaySettings);
    }

    @NotNull
    private static AppJWTStrategy getAppJWTStrategy() {
        AppJWTStrategy authStrategy = new AppJWTStrategy();
        return authStrategy;
    }

    /**
     * @steve
     * description: request QR(wiget) to UnivaPay
     *
     */
    @Override
    public void requestQRtoUnivaPay() {

        // createToken


        // builder 를 만들고



        // builder 를 통해 요청을 보냄


        //


        // 가맹점 조회(토큰)
        String storeToken = "";

        // createJWT
        String transactToken = tokenUtil.createJWT(storeToken);

        // request QR to paypay


    }

    @Override
    public void refund() {

    }
}
