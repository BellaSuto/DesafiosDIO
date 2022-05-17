package banco.digital;

import java.text.ParseException;

public interface Procedimentos {

    //Responsavel por sacar dinheiro de uma conta.

    public void sacar(Conta conta, double valor);

    // Responsável por inserir dinheiro em uma conta.

    public void depositar(Conta conta, double valor);

    //Responsável por transferir dinheiro entre contas bancárias.

    public void transferir(Conta suaConta, Conta contaDestino, double valor);

    //Responsável por solicitar cartões de crédito.

    public void solicitarCartao(Conta conta) throws ParseException;

    //Responsável por exibir os dados bancários de uma conta.

    public void exibirDadosBancarios(Conta conta);
}
