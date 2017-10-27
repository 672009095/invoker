package id.codigo.invoker.preference;

import id.codigo.invoker.MainModel;

/**
 * Created by papahnakal on 26/10/17.
 */

public interface SessionManager {
    MainModel getLoggedUser();

    String getIdUser();

    boolean isLoggedIn();

    void storeIdUser(String IdUser);

    void storeLoggedUser(MainModel user);

    void clear();
}
