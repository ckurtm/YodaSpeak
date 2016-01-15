package com.peirr.yodaspeak.viewmodel;

import com.peirr.yodaspeak.model.YodaModel;
import com.peirr.yodaspeak.view.YodaContract;
import com.peirr.yodaspeak.view.YodaView;

/**
 * Created by kurt on 2016/01/14.
 */
public class YodaViewModel implements YodaContract.ActionsListener {

    final YodaView view;
    final YodaModel model;

    public YodaViewModel(YodaView view, YodaModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void requestText(String text) {
        view.showTextLoading(true);
        model.requestText(text, new YodaModel.RequestCallback() {
            @Override
            public void onRequestCompleted(String text, Throwable t) {
                view.showTextLoading(false);
                if (t == null) {
                    view.showText(text);
                }else{
                    view.showLoadingError();
                }
            }
        });
    }


}
