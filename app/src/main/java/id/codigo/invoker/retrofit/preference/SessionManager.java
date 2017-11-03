package id.codigo.invoker.retrofit.preference;

import id.codigo.invoker.retrofit.MainModel;
import id.codigo.seedroid_retrofit.service.SeedroidSessionManager;

/**
 * Created by papahnakal on 26/10/17.
 */

public interface SessionManager extends SeedroidSessionManager{
    MainModel getLoggedUser();

    String getIdUser();

    boolean isLoggedIn();

    void storeIdUser(String IdUser);

    void storeLoggedUser(MainModel user);

    void clear();
}
