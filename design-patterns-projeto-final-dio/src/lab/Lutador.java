package designpatterns.lab;

public class Lutador {
    private MetodoLuta metodo;

    public Lutador() {
    }

    public void mudarMetodo(MetodoLuta metodo) {
        this.metodo = metodo;
    }

    public void finalizar() {
        metodo.finalizar();
    }

    public void mudarMetodo(MetodoForcaBruta metodoForcaBruta) {
    }
}
