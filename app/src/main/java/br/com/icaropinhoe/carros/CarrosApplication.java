package br.com.icaropinhoe.carros;

import android.app.Application;

/**
 * Created by icaro on 26/12/2017.
 */

public class CarrosApplication extends Application {

    private static CarrosApplication instance = null;

    public static CarrosApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
