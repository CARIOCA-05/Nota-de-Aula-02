import java.util.Scanner;

public class CorridaUber {
    // Atributos da corrida
    private double distancia;
    private int tempoEspera;
    private double tarifaBase;
    private double fatorDemanda;

    // Construtor
    public CorridaUber(double distancia, int tempoEspera, double tarifaBase, double fatorDemanda) {
        this.distancia = distancia;
        this.tempoEspera = tempoEspera;
        this.tarifaBase = tarifaBase;
        this.fatorDemanda = fatorDemanda;
    }

    // Método para calcular o valor final da corrida
    public double calcularValorCorrida() {
        return (distancia * 2) + (tempoEspera * 0.5) + (tarifaBase * fatorDemanda);
    }

    // Método para exibir os detalhes da corrida
    public void exibirDetalhesCorrida() {
        double valorFinal = calcularValorCorrida();
        System.out.println("Detalhes da Corrida:");
        System.out.println("Distância: " + distancia + " km");
        System.out.println("Tempo de Espera: " + tempoEspera + " minutos");
        System.out.println("Tarifa Base: R$ " + tarifaBase);
        System.out.println("Fator de Demanda: " + fatorDemanda);
        System.out.println("Valor Final da Corrida: R$ " + valorFinal);
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita os dados da corrida
        System.out.print("Digite a distância percorrida (em km): ");
        double distancia = scanner.nextDouble();

        System.out.print("Digite o tempo de espera (em minutos): ");
        int tempoEspera = scanner.nextInt();

        System.out.print("Digite a tarifa base da corrida: R$ ");
        double tarifaBase = scanner.nextDouble();

        System.out.print("Digite o fator de demanda: ");
        double fatorDemanda = scanner.nextDouble();

        // Cria uma nova corrida com os dados fornecidos
        CorridaUber corrida = new CorridaUber(distancia, tempoEspera, tarifaBase, fatorDemanda);

        // Exibe os detalhes da corrida
        corrida.exibirDetalhesCorrida();

        scanner.close();
    }
}
