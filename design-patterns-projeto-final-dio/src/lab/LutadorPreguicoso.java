package designpatterns.lab;

public class LutadorPreguicoso {

        private MetodoXiterIf metodoXiter;

        public LutadorPreguicoso() {
        }

        public void mudarMetodo(String metodo) {
            this.metodoXiter = metodo;
        }

        public void finalizar() {
            metodoXiter.finalizar();
        }
    }

