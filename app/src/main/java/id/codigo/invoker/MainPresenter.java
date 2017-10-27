package id.codigo.invoker;

import android.util.Log;

import id.codigo.invoker.preference.SessionManager;
import id.codigo.invoker.service.ServiceFactory;
import id.codigo.seedroid_core.presenter.BasePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by papahnakal on 25/10/17.
 */

public class MainPresenter extends BasePresenter<MainView> {
    private static final String TAG = "main presenter";
    private SessionManager sessionManager;
    private String password;
    private String username;
    public MainPresenter(String password,String username,SessionManager sessionManager){
        this.password = password;
        this.username = username;
        this.sessionManager = sessionManager;

    }
    @Override
    public void onStartUI() {
        getMvpView().setPresenter();
    }
    public void doLogin(){
        Log.d(TAG,"param password: "+password);
        Log.d(TAG,"param username: "+username);
        Call<MainModel> call = ServiceFactory.createWithAuth(sessionManager).loginUser(username, password);
        call.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                //if(isViewAttached()){
                    if(response.isSuccessful()){
                        MainModel user = response.body();
                        if(user.getStatus().equalsIgnoreCase("200")) {
                            String status = user.getStatus() + "_" + user.getMessage();
                            Log.d(TAG, status);
                            String id = user.getData().getId_user();
                            getMvpView().showMessage("message :"+user.getDisplay_message()+" and your id is : "+id);
                        }else{
                            Log.d(TAG, "return not 200");
                            getMvpView().showMessage("message :"+user.getDisplay_message());
                        }
                    }else{
                        Log.d(TAG,"inside onresponse but not usccessfully");
                        //getView().showMessage(user.getDisplay_message());
                    }
                //}
            }

            @Override
            public void onFailure(Call<MainModel> call, Throwable t) {
                //if(isViewAttached()){
                    Log.d(TAG,t.getMessage());
                    //APIError error = ErrorUtils.parseError(t);
                    //getView().hideProgress();
                //}
            }
        });
    }
}
