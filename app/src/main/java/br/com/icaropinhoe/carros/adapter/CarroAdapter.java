package br.com.icaropinhoe.carros.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.icaropinhoe.carros.R;
import br.com.icaropinhoe.carros.domain.Carro;

/**
 * Created by icaro on 27/12/2017.
 */

public class CarroAdapter extends RecyclerView.Adapter<CarroAdapter.CarrosViewHolder> {

    private final List<Carro> mCarros;
    private final Context mContext;
    private CarroOnClickListener mListener;

    public CarroAdapter(List<Carro> carros, Context context, CarroOnClickListener listener){
        this.mCarros = carros;
        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    public CarrosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_carro, parent, false);
        CarrosViewHolder holder = new CarrosViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final CarrosViewHolder holder, final int position) {
        Carro carro = mCarros.get(position);

        holder.tNome.setText(carro.getNome());
        holder.progress.setVisibility(View.VISIBLE);

        Picasso.with(mContext).load(carro.getUrlFoto()).fit().into(holder.img, new Callback() {
            @Override
            public void onSuccess() {
                holder.progress.setVisibility(View.GONE);
            }

            @Override
            public void onError() {
                holder.progress.setVisibility(View.GONE);
            }
        });

        if(mListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClickCarro(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mCarros != null ? mCarros.size() : 0;
    }

    public class CarrosViewHolder extends RecyclerView.ViewHolder {

        public TextView tNome;
        ImageView img;
        ProgressBar progress;
        CardView cardView;

        public CarrosViewHolder(View itemView) {
            super(itemView);

            tNome = itemView.findViewById(R.id.text);
            img = itemView.findViewById(R.id.img);
            progress = itemView.findViewById(R.id.progressImg);
            cardView = itemView.findViewById(R.id.card_view);
        }

    }

    public interface CarroOnClickListener{
        public void onClickCarro(View view, int idx);
    }

}
