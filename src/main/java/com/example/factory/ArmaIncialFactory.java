package com.example.factory;

import com.example.model.entity.armas.ArcoCurto;
import com.example.model.entity.armas.CetroDeMadeira;
import com.example.model.entity.armas.EspadaCurta;
import com.example.model.entity.armas.Varinha;
import com.example.model.enums.ETipoArma;
import com.example.view.IArma;
import com.example.view.IArmaFactory;

public class ArmaIncialFactory implements IArmaFactory{
    // singleton na factory
    private static ArmaIncialFactory armaFactory;
    private ArmaIncialFactory(){}

    public static ArmaIncialFactory getInstance(){
        if( armaFactory == null){
            armaFactory = new ArmaIncialFactory();
        }
        return armaFactory;
    }

    @Override
    public IArma criaArma(ETipoArma tipoArma) {
        IArma arma;
        arma = switch(tipoArma){
            case ARCOCURTO -> new ArcoCurto();
            case VARINHA -> new Varinha();
            case ESPADACURTA ->  new EspadaCurta();
            case CETRODEMADEIRA -> new CetroDeMadeira();
            default -> arma = null;
        };
        return arma;
    }
    
}

