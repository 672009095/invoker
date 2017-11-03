package id.codigo.invoker.retrofit;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import id.codigo.invoker.R;
import id.codigo.invoker.databinding.ActivityMainBinding;
import id.codigo.invoker.retrofit.preference.InvokeSharedPreference;
import id.codigo.seedroid_core.activity.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainView,MainPresenter>implements MainView {
    InvokeSharedPreference shared;
    @Override
    public int attachLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewBinding().buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shared.setAuthorization("Basic a2xhc2lvYXBpOmtlbmFwYWJpc2E=");
                getMvpPresenter().doLogin(getViewBinding().editUsername.getText().toString(),getViewBinding().editPassword.getText().toString());
            }
        });
    }

    @Override
    public MainPresenter createPresenter() {
        shared = new InvokeSharedPreference(getApplicationContext());
        shared.setAuthorization("Basic a2xhc2lvYXBpOmtlbmFwYWJpc2E=");
        return new MainPresenter(shared);
    }

    @Override
    public void setPresenter() {
        getViewBinding().setPresenter(getMvpPresenter());
    }

    @Override
    public void setModel(MainModel obj) {
        getViewBinding().setModel(obj);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        getViewBinding().textResult.setText(message);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
