package banco.digital;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

public class BancoDigital {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        TransacaoAuxiliar transacaoHelper = new TransacaoAuxiliar();

        List<Conta> contas = new ArrayList<Conta>();

        String opcao = "";

        boolean sair = false;

        Scanner teclado = new Scanner(System.in);

        System.out.println("*----------------------------------------*");
        System.out.println("|Bem vindo ao PagJava!                   |");
        System.out.println("|A seguir estão as opções disponíveis:   |");
        System.out.println("*----------------------------------------*");

        try {
            do {
                System.out.println("*----------------------------------------*");
                System.out.println("|0 - Sair                                |");
                System.out.println("|1 - Criar Conta                         |");
                System.out.println("|2 - Listar Todas as Contas              |");
                System.out.println("|3 - Exibir Dados Bancários pelo CPF     |");
                System.out.println("|4 - Visualizar Saldo Pelo CPF           |");
                System.out.println("|5 - Solicitar Cartão de Crédito         |");
                System.out.println("|6 - Sacar                               |");
                System.out.println("|7 - Depositar                           |");
                System.out.println("|8 - Transferir                          |");
                System.out.println("*----------------------------------------*");

                System.out.print("Insira a opção desejada: ");
                opcao = teclado.nextLine();

                switch (opcao) {
                    case "0":
                        System.out.println("*--------------------------------*");
                        System.out.println("|FINALIZANDO APLICAÇÃO...        |");
                        System.out.println("|OBRIGADA!                       |");
                        System.out.println("*--------------------------------*");
                        sair = true;

                        break;
                    case "1":
                        System.out.println("-> CRIAR CONTA");

                        Conta c1 = new Conta();
                        System.out.print("Informe seu nome: ");
                        c1.getCliente().setNome(teclado.nextLine());

                        System.out.print("Informe seu CPF: ");
                        c1.getCliente().setCpf(teclado.nextLine());

                        System.out.print("Informe sua data de nascimento: ");
                        String dataNascimento = teclado.nextLine();

                        if(!dataNascimento.isEmpty()) {
                            c1.getCliente().setDataNascimento(simpleDateFormat.parse(dataNascimento));
                        }

                        if(ValidamentoAuxiliar.isPossivelCadastrarConta(c1)) {
                            contas.add(c1);

                            System.out.println("Conta criada com sucesso!");
                        }
                        break;
                    case "2":
                        System.out.println("-> LISTAR CONTAS");

                        if(!contas.isEmpty()) {
                            for (Conta conta : contas) {
                                System.out.println("Número:" + conta.getNumero() + "Agência: " + conta.getCodigo());
                            }
                        }
                        break;
                    case "3":
                        System.out.println("-> DADOS BANCÁRIOS");

                        System.out.print("Informe o CPF do cliente: ");
                        String cpfDados = teclado.nextLine();

                        if(ValidamentoAuxiliar.isContaExistente(contas, cpfDados)) {
                            for (Conta conta : contas) {
                                if(conta.getCliente().getCpf().equals(cpfDados)) {
                                    transacaoHelper.exibirDadosBancarios(conta);
                                }
                            }
                        }
                        break;
                    case "4":
                        System.out.println("-> SALDO");

                        System.out.print("Informe o CPF para consulta: ");
                        String cpfSaldo = teclado.nextLine();

                        if(ValidamentoAuxiliar.isContaExistente(contas, cpfSaldo)) {
                            for (Conta conta : contas) {
                                if(conta.getCliente().getCpf().equals(cpfSaldo)) {
                                    System.out.println("O saldo é de: " + conta.getSaldo());
                                }
                            }
                        }
                        break;
                    case "5":
                        System.out.println("-> SOLICITAR CARTÃO");

                        System.out.print("Informe o CPF do solicitante: ");
                        String cpfCartao = teclado.nextLine();

                        if(ValidamentoAuxiliar.isContaExistente(contas, cpfCartao)) {
                            for (Conta conta : contas) {
                                if(conta.getCliente().getCpf().equals(cpfCartao)) {
                                    transacaoHelper.solicitarCartao(conta);
                                }
                            }
                        }
                        break;
                    case "6":
                        System.out.println("-> SAQUE");

                        System.out.print("Informe o CPF da pessoa: ");
                        String cpfSacar = teclado.nextLine();

                        if(ValidamentoAuxiliar.isContaExistente(contas, cpfSacar)) {
                            String valor;

                            System.out.print("Informe o valor do saque: ");
                            valor = teclado.nextLine();

                            for (Conta conta : contas) {
                                if(conta.getCliente().getCpf().equals(cpfSacar)) {
                                    transacaoHelper.sacar(conta, Double.parseDouble(valor));
                                }
                            }
                        }
                        break;
                    case "7":
                        System.out.println("-> DEPÓSITO");

                        System.out.print("Informe o CPF do cliente: ");
                        String cpfDeposito = teclado.nextLine();

                        if(ValidamentoAuxiliar.isContaExistente(contas, cpfDeposito)) {
                            String valor;

                            System.out.print("Informe o valor do depósito: ");
                            valor = teclado.nextLine();

                            for (Conta conta : contas) {
                                if(conta.getCliente().getCpf().equals(cpfDeposito)) {
                                    transacaoHelper.depositar(conta, Double.parseDouble(valor));
                                }
                            }
                        }
                        break;
                    case "8":
                        System.out.println("-> TRANSFERÊNCIA");

                        System.out.print("Informe o CPF do depositante: ");
                        String cpfDepositante = teclado.nextLine();

                        System.out.print("Informe o CPF do recebedor: ");
                        String cpfRecebedor = teclado.nextLine();

                        if(ValidamentoAuxiliar.isContaExistente(contas, cpfDepositante)
                                && ValidamentoAuxiliar.isContaExistente(contas, cpfRecebedor)) {
                            Conta contaDepositante = null, contaRecebedor = null;
                            String valor;

                            System.out.print("Informe o valor do depósito: ");
                            valor = teclado.nextLine();

                            for (Conta conta : contas) {
                                if(conta.getCliente().getCpf().equals(cpfDepositante)) {
                                    contaDepositante = conta;
                                }else if (conta.getCliente().getCpf().equals(cpfRecebedor)){
                                    contaRecebedor = conta;
                                }
                            }
                            transacaoHelper.transferir(contaDepositante, contaRecebedor, Double.parseDouble(valor));
                        }

                        break;
                    default:
                        break;
                }
            }while(!sair);

        } catch (ParseException e) {
            e.printStackTrace();
        }finally {
            teclado.close();
        }
    }
}
