package designpatterns.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodoLutaIf {

    static final Logger LOGGER = LoggerFactory.getLogger(MetodoLutaIf.class);

    public String desafiarOponente() {
        return null;
    }

    public void socarOponente(String oponente) {

    }

    public void chutarOponente(String oponente) {

    }

    public void atirarMagiaOponente(String oponente) {

    }

    public void finalizar(){

        String oponente = desafiarOponente();
        LOGGER.info("Lutador desafiado: {}.", oponente);
        socarOponente(oponente);
        chutarOponente(oponente);
        atirarMagiaOponente(oponente);

    }
}
