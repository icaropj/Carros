package br.com.icaropinhoe.carros.activity;

import android.support.v7.widget.Toolbar;

import br.com.icaropinhoe.carros.R;

/**
 * Created by icaro on 26/12/2017.
 */

public class BaseActivity extends livroandroid.lib.activity.BaseActivity {

    protected void setUpToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

}
