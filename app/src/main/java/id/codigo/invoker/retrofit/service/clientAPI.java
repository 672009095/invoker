package id.codigo.invoker.retrofit.service;

import id.codigo.invoker.retrofit.MainModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by papahnakal on 25/10/17.
 */

public interface clientAPI {
    @FormUrlEncoded
    @POST("login")
    Call<MainModel> loginUser(
            @Field("email") String username,
            @Field("password") String password
    );
}
