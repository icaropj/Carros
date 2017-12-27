package br.com.icaropinhoe.carros.domain;

import java.io.Serializable;

/**
 * Created by icaro on 27/12/2017.
 */

public class Carro implements Serializable {

    private Long id;

    private String tipo;

    private String nome;

    private String desc;

    private String urlFoto;

    private String urlInfo;

    private String urlVideo;

    private String latitude;

    private String longitude;

    @Override
    public String toString() {
        return "Carro{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
