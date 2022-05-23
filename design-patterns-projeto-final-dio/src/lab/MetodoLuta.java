package designpatterns.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodoLuta {
    private static final Logger LOGGER = LoggerFactory.getLogger(MetodoLuta.class);

    public MetodoLuta() {
    }

    protected String desafiarOponente() {
        return null;
    }

    protected void socarOponente(String oponente) {

    }

    protected void chutarOponente(String oponente) {

    }

    protected void atirarMagiaOponente(String oponente) {

    }

    public final void finalizar() {

        String oponente = desafiarOponente();
        LOGGER.info("Lutador desafiado: {}.", oponente);
        socarOponente(oponente);
        chutarOponente(oponente);
        atirarMagiaOponente(oponente);

    }
}
