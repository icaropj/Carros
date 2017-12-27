package br.com.icaropinhoe.carros.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.icaropinhoe.carros.R;

public class CarrosFragment extends BaseFragment {

    private static final String PARAM_TIPO = "tipo";
    private int tipo;

    public CarrosFragment() {
    }

    public static CarrosFragment newInstance(int tipo) {
        Bundle args = new Bundle();
        args.putInt(PARAM_TIPO, tipo);
        CarrosFragment carrosFragment = new CarrosFragment();
        carrosFragment.setArguments(args);
        return carrosFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            this.tipo = getArguments().getInt(PARAM_TIPO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carros, container, false);

        TextView text = view.findViewById(R.id.text);
        text.setText("Carros " + getString(tipo));

        return view;
    }

}
