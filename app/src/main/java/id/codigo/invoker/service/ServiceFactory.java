package id.codigo.invoker.service;

import id.codigo.invoker.preference.SessionManager;

/**
 * Created by papahnakal on 26/10/17.
 */

public class ServiceFactory {
    public static clientAPI create() {
        return ServiceGenerator.createService(clientAPI.class);
    }

    public static clientAPI createWithAuth(SessionManager sessionManager) {
        return ServiceGenerator.createService(clientAPI.class, sessionManager);
    }

    public static clientAPI createWithAuthAndArray(SessionManager sessionManager) {
        return ServiceGenerator.createService(clientAPI.class, sessionManager);
    }
}
