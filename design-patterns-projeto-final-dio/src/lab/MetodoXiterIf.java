package designpatterns.lab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodoXiterIf {

    static final Logger LOGGER = LoggerFactory.getLogger(MetodoXiterIf.class);

    public String desafiarOponente() {
        return null;
    }

    public void soltarMagiaEmCima() {
        LOGGER.info("Hadouken na cara de {}", desafiarOponente());
    }

    public void soltarMagiaEmbaixo() {
        LOGGER.info("Hadouken nas pernas de {}", desafiarOponente());
    }

    public void soltarMagiaNoAr() {
        LOGGER.info("Hadouken na cabeça de {}", desafiarOponente());
    }

    public void finalizar() {
        LOGGER.info("Lutador desafiado: {}.", desafiarOponente());
        soltarMagiaEmCima();
        soltarMagiaEmbaixo();
        soltarMagiaNoAr();
    }

}

