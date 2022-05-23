package designpatterns.lab;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class MetodoAgil extends MetodoLuta {
    private static final Logger LOGGER = LoggerFactory.getLogger(MetodoForcaBruta.class);

    @Override
    protected String desafiarOponente() {
        return "Lutador de Sumô";
    }

    @Override
    protected void socarOponente(String oponente) {
        LOGGER.info("Soco rápido na linha de cintura do {}", oponente);
    }

    @Override
    protected void chutarOponente(String oponente) {
        LOGGER.info("Chute médio com duas pernas na linha dos pés do {}", oponente);
    }

    @Override
    protected void atirarMagiaOponente(String oponente) {
        LOGGER.info("Chute do pássaro giratório no {}", oponente);
    }
}
