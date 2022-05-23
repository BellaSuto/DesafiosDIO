package designpatterns.lab;

public class LutadorAtual {

    private MetodoLutaIf metodo;

    public LutadorAtual() {
    }

    public void mudarMetodo(MetodoLutaIf metodo) {
        this.metodo = metodo;
    }

    public void finalizar() {
        metodo.finalizar();
    }
}
