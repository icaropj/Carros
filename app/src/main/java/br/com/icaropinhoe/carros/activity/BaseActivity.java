package br.com.icaropinhoe.carros.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import br.com.icaropinhoe.carros.R;

/**
 * Created by icaro on 26/12/2017.
 */

public class BaseActivity extends livroandroid.lib.activity.BaseActivity {

    protected DrawerLayout mDrawerLayout;

    protected void setUpToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    protected void setUpNavDrawer(){
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        if(navigationView != null && mDrawerLayout != null){
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    item.setChecked(true);
                    mDrawerLayout.closeDrawers();
                    onNavDrawerItemSelected(item);
                    return true;
                }
            });
        }
    }

    private void onNavDrawerItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_item_carros_todos:
                break;
            case R.id.nav_item_carros_classicos:
                break;
            case R.id.nav_item_carros_esportivos:
                break;
            case R.id.nav_item_carros_luxo:
                break;
            case R.id.nav_item_site_livro:
                break;
            case R.id.nav_item_settings:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                openDrawer();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void openDrawer(){
        if(mDrawerLayout != null){
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

    protected void closeDrawer(){
        if(mDrawerLayout != null){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
    }
}
