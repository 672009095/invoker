package id.codigo.invoker.retrofit.preference;

import android.content.Context;
import android.content.SharedPreferences;

import id.codigo.invoker.retrofit.MainModel;

/**
 * Created by papahnakal on 26/10/17.
 */

public class InvokeSharedPreference implements SessionManager {
    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;
    private Context mContext;

    private static int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "Invoke";
    private static final String KEY_USERID = "userId";
    private static final String KEY_IS_LOGIN = "IsLoggedIn";
    private static final String KEY_AUTHRIZATION = "auth";

    public InvokeSharedPreference(Context context){
        this.mContext = context;
        this.mPref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        this.mEditor = mPref.edit();
    }

    @Override
    public MainModel getLoggedUser() {
        MainModel user = new MainModel();
        user.getData().setId_user(mPref.getString(KEY_USERID,""));
        return user;
    }

    @Override
    public String getIdUser() {
        return mPref.getString(KEY_USERID,"");
    }

    @Override
    public boolean isLoggedIn() {
        return mPref.getBoolean(KEY_IS_LOGIN, false);
    }

    @Override
    public void storeIdUser(String IdUser) {

    }

    @Override
    public void storeLoggedUser(MainModel user) {
        mEditor.putBoolean(KEY_IS_LOGIN, true);
        mEditor.putString(KEY_USERID, user.getData().getId_user().toString());
        mEditor.commit();
    }

    @Override
    public void setAuthorization(String s) {
        mEditor.putString(KEY_AUTHRIZATION,s);
        mEditor.commit();
    }

    @Override
    public String getAutorization() {
        return mPref.getString(KEY_AUTHRIZATION,"");
    }

    @Override
    public void clear() {
        mEditor.clear();
        mEditor.commit();
    }
}
