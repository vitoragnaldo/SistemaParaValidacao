import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Candidato {
    String nome;
    double notaTeste1;
    double notaTeste2;
    boolean aprovado;

    public Candidato(String nome, double notaTeste1, double notaTeste2) {
        this.nome = nome;
        this.notaTeste1 = notaTeste1;
        this.notaTeste2 = notaTeste2;
        this.aprovado = false;
    }

    public double calcularMedia() {
        return (notaTeste1 + notaTeste2) / 2;
    }
}

class ProcessoSeletivo {
    List<Candidato> candidatos = new ArrayList<>();

    public void adicionarCandidato(Candidato candidato) {
        candidatos.add(candidato);
    }

    public void avaliarCandidatos() {
        for (Candidato candidato : candidatos) {
            double media = candidato.calcularMedia();
            if (media >= 7.0) {
                candidato.aprovado = true;
            }
        }
    }

    public void exibirResultados() {
        System.out.println("\nResultados do Processo Seletivo:");
        for (Candidato candidato : candidatos) {
            System.out.println("Nome: " + candidato.nome +
                    ", Média: " + candidato.calcularMedia() +
                    ", Aprovado: " + (candidato.aprovado ? "Sim" : "Não"));
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProcessoSeletivo processoSeletivo = new ProcessoSeletivo();

        int opcao;
        do {
            System.out.println("\n--- Sistema de Validação de Processo Seletivo ---");
            System.out.println("1. Adicionar Candidato");
            System.out.println("2. Avaliar Candidatos");
            System.out.println("3. Exibir Resultados");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do candidato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Nota do Teste 1: ");
                    double notaTeste1 = scanner.nextDouble();
                    System.out.print("Nota do Teste 2: ");
                    double notaTeste2 = scanner.nextDouble();
                    processoSeletivo.adicionarCandidato(new Candidato(nome, notaTeste1, notaTeste2));
                    break;
                case 2:
                    processoSeletivo.avaliarCandidatos();
                    System.out.println("Candidatos avaliados.");
                    break;
                case 3:
                    processoSeletivo.exibirResultados();
                    break;
                case 4:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}