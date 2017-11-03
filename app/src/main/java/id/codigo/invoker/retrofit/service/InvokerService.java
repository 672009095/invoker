package id.codigo.invoker.retrofit.service;

import id.codigo.invoker.BuildConfig;
import id.codigo.invoker.retrofit.preference.SessionManager;
import id.codigo.seedroid_retrofit.service.SeedroidServiceGenerator;

/**
 * Created by papahnakal on 26/10/17.
 */

public class InvokerService {
    public static clientAPI create() {
        return SeedroidServiceGenerator.createService(BuildConfig.HOST,clientAPI.class);
    }

    public static clientAPI createWithAuth(SessionManager sessionManager) {
        return SeedroidServiceGenerator.createService(BuildConfig.HOST,clientAPI.class, sessionManager);
    }

    public static clientAPI createWithAuthAndArray(SessionManager sessionManager) {
        return SeedroidServiceGenerator.createService(BuildConfig.HOST,clientAPI.class, sessionManager);
    }
}
