package br.com.icaropinhoe.carros.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import br.com.icaropinhoe.carros.R;
import br.com.icaropinhoe.carros.adapter.CarroAdapter;
import br.com.icaropinhoe.carros.domain.Carro;
import br.com.icaropinhoe.carros.domain.CarroService;

public class CarrosFragment extends BaseFragment {

    private static final String PARAM_TIPO = "tipo";
    private int tipo;

    private RecyclerView mRecyclerView;
    private List<Carro> mCarros;

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

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskCarros();
    }

    private void taskCarros() {
        this.mCarros = CarroService.getCarros(getContext(), tipo);

        mRecyclerView.setAdapter(new CarroAdapter(mCarros, getContext(), onClickCarro()));
    }

    private CarroAdapter.CarroOnClickListener onClickCarro(){
        return new CarroAdapter.CarroOnClickListener() {
            @Override
            public void onClickCarro(View view, int idx) {
                Carro c = mCarros.get(idx);
                Toast.makeText(getContext(), c.getNome(), Toast.LENGTH_SHORT).show();
            }
        };
    }
}
