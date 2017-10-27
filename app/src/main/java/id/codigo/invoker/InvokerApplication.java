package id.codigo.invoker;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

/**
 * Created by papahnakal on 26/10/17.
 */

public class InvokerApplication extends MultiDexApplication {
    private static InvokerApplication instance;

    public static synchronized InvokerApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
