package com.peirr.yodaspeak.model;

import android.content.Context;

/**
 * Created by kurt on 2016/01/15.
 */
public class ModelFactory {
    public static YodaModel getModel(Context context,boolean mock){
        if(mock){
            return new YodaMockModel();
        }else {
            return new YodaServiceModel(context);
        }
    }
}
