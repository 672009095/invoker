package id.codigo.invoker.retrofit;

import id.codigo.seedroid_core.view.BaseView;

/**
 * Created by papahnakal on 25/10/17.
 */

public interface MainView extends BaseView {
    void setPresenter();

    void setModel(MainModel obj);

    void showMessage(String message);
}
