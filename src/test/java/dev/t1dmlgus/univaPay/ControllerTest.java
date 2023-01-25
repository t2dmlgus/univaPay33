package dev.t1dmlgus.univaPay;

import com.google.gson.Gson;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;
import com.univapay.sdk.models.response.gateway.UnivapayGateway;
import com.univapay.sdk.types.Gateway;
import com.univapay.sdk.utils.RetrofitBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class ControllerTest {

    private final RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
    @Test
    public void test() throws NoSuchFieldException {

        Class<Gateway> gatewayClass = Gateway.class;
        Gson gson = retrofitBuilder.getGson();

        for (Gateway gateway : gatewayClass.getEnumConstants()) {

            SerializedName serializedName =
                    gatewayClass.getField(gateway.name()).getAnnotation(SerializedName.class);

            UnivapayGateway univapayGateway
                    = gson.fromJson(new JsonPrimitive(serializedName.value()), UnivapayGateway.class);
            Assertions.assertThat(gateway.equals(univapayGateway.getGateway()));
        }
    }
}