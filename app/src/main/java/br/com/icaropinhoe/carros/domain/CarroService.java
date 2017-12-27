package br.com.icaropinhoe.carros.domain;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by icaro on 27/12/2017.
 */

public class CarroService {

    public static List<Carro> getCarros(Context context, int tipo){
        String tipoString = context.getString(tipo);
        List<Carro> carros = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            Carro carro = new Carro();
            carro.setNome("Carro " + tipoString + ": " + i);
            carro.setDesc("Desc " + i);
            carro.setUrlFoto("http://www.livroandroid.com.br/livro/carros/esportivos/Ferrari_FF.png");
            carros.add(carro);
        }
        return carros;
    }

}
