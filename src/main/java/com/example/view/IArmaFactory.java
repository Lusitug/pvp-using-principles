package com.example.view;

import com.example.model.enums.ETipoArma;

public interface IArmaFactory {
    public IArma criaArma(ETipoArma tipoArma);

}
