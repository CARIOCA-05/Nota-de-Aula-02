import java.util.Scanner;

abstract class Conta {
    protected String titular;
    protected double saldo;

    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public abstract void depositar(double valor);

    public abstract void sacar(double valor);

    public void exibirDados() {
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: R$ " + saldo);
    }
}

class ContaCorrente extends Conta {
    private double chequeEspecial = 1000.00;

    public ContaCorrente(String titular) {
        super(titular);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo + chequeEspecial) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente. Cheque especial disponível: R$ " + chequeEspecial);
        }
    }

    public void usarChequeEspecial(double valor) {
        if (valor <= chequeEspecial) {
            chequeEspecial -= valor;
            saldo += valor;
            System.out.println("Cheque especial usado no valor de R$ " + valor);
        } else {
            System.out.println("Cheque especial insuficiente.");
        }
    }
}

class ContaPoupanca extends Conta {
    private double selic;

    public ContaPoupanca(String titular, double selic) {
        super(titular);
        this.selic = selic;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void calcularRendimento() {
        double rendimento;
        if (selic > 8.5) {
            rendimento = 0.005 * saldo;
        } else {
            rendimento = 0.007 * selic * saldo;
        }
        saldo += rendimento;
        System.out.println("Rendimento de R$ " + rendimento + " calculado e adicionado ao saldo.");
    }
}

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bem-vindo ao Sistema Bancário");
        System.out.print("Digite o nome do titular: ");
        String titular = scanner.nextLine();

        System.out.println("Selecione o tipo de conta: ");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        int tipoConta = scanner.nextInt();

        Conta conta = null;

        if (tipoConta == 1) {
            conta = new ContaCorrente(titular);
        } else if (tipoConta == 2) {
            System.out.print("Digite a taxa Selic atual (em %): ");
            double selic = scanner.nextDouble();
            conta = new ContaPoupanca(titular, selic);
        }

        if (conta != null) {
            int opcao;
            do {
                System.out.println("\nMenu de opções:");
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                if (conta instanceof ContaCorrente) {
                    System.out.println("3. Usar Cheque Especial");
                } else if (conta instanceof ContaPoupanca) {
                    System.out.println("3. Calcular Rendimento");
                }
                System.out.println("4. Exibir Dados da Conta");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o valor do depósito: ");
                        double deposito = scanner.nextDouble();
                        conta.depositar(deposito);
                        break;
                    case 2:
                        System.out.print("Digite o valor do saque: ");
                        double saque = scanner.next
