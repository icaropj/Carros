package br.com.icaropinhoe.carros.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.icaropinhoe.carros.R;
import br.com.icaropinhoe.carros.fragment.CarrosFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();
        setUpNavDrawer();
        replaceFragment(CarrosFragment.newInstance(R.string.todos));
    }
}
