package id.codigo.invoker;


import android.widget.Toast;

import id.codigo.invoker.databinding.ActivityMainBinding;
import id.codigo.invoker.preference.InvokeSharedPreference;
import id.codigo.seedroid_core.activity.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainView,MainPresenter>implements MainView{
    InvokeSharedPreference shared;
    @Override
    public int attachLayout() {
        return R.layout.activity_main;
    }

    @Override
    public MainPresenter createPresenter() {
        shared = new InvokeSharedPreference(getApplicationContext());
        return new MainPresenter(
                getViewBinding().editPassword.getText().toString(),
                getViewBinding().editUsername.getText().toString(),shared);
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
