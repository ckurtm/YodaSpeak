package com.peirr.yodaspeak.model;

/**
 * Created by kurt on 2016/01/14.
 */
public class YodaMockModel implements YodaModel {
    private String TAG = "YodaServiceModel";
    private boolean fail;

    public void setFail(boolean fail) {
        this.fail = fail;
    }

    @Override
    public void requestText(String text, final RequestCallback callback) {
        if(!fail){
            callback.onRequestCompleted(text,null);
        }else{
            callback.onRequestCompleted(text,new Exception("FAIL"));
        }
    }
}
