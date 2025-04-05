import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    // Coleção de jogadores
    ArrayList<Jogador> jogadores;
    // Scanner para obter dados do usuário via terminal
    private Scanner entrada;

    /* 
     * Construtor da classe
     */
    public Principal() {
        entrada = new Scanner(System.in);
        // cria a lista de jogadores
        jogadores = new ArrayList<>();
    }

    /*
     * Método que trata o loop do menu
     */
    public void executar() {
        int opcao;
        do {
            exibirMenu();
            
            System.out.println("\nDigite sua opção: ");
            opcao = Integer.parseInt(entrada.nextLine());

            tratarMenu(opcao);

        } while (opcao != 5);

        // fecha o objeto Scanner para liberar os seus recursos
        entrada.close();
    }

    /*
     * Método que exibe as opções de menu
     */
    public void exibirMenu() {
        System.out.println("1 - Carregar dados dos jogadores");
        System.out.println("2 - Listar jogadores");
        System.out.println("3 - Buscar jogador por nome");
        System.out.println("4 - Buscar jogador por índice");
        System.out.println("5 - Sair");
    }

    /*
     * Método que trata uma opção de menu escolhida pelo usuário
     */
    private void tratarMenu(int opcao) {
        switch (opcao) {
            case 1:
                carregarJogadores();
                break;
            case 2:
                listarJogadores();
                break;
            case 3:
                buscarJogadorPorNome();
                break;
            case 4:
                buscarJogadorPorIndice();
                break;
            case 5:
                System.out.println("Saindo do programa...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private void aguardarEnter() {
        System.out.println("\nDigite ENTER para continuar!");
        entrada.nextLine();
    }

    private void carregarJogadores() {
        jogadores = Dados.carregarDadosJogadores();

        System.out.println("Carregados dados de " + jogadores.size() + " jogadores.");
        aguardarEnter();
    }

    private void listarJogadores() {
        if (jogadores.size() == 0) {
            System.out.println("Dados de jogadores não foram carregados!");
            aguardarEnter();
            return;
        }
        // Tamanho da página define a quantidade de nomes de jogadores que serão
        // exibidos por vez.
        int tamanhoPagina = 20;
        System.out.println("São listados os nomes dos jogadores em páginas de " + tamanhoPagina + " nomes");
        
        // Controla quando sair do while abaixo
        boolean continuar = true;
        // Posicao do jogador na lista
        int posicao = 0;
        // Enquanto não terminar toda a lista e o usuário não cancelar
        while (continuar) {
            // Guarda a posição final da próxima página
            int limitePaginaAtual = posicao + tamanhoPagina;
            // Exibe os nomes dos jogadores na página atual
            while (posicao < jogadores.size() && posicao < limitePaginaAtual) {
                System.out.println(jogadores.get(posicao).getNome());
                posicao++;
            }
            // Se já chegou ao final da lista, indica que é para sair do while.
            if (posicao >= jogadores.size()) {
                continuar = false;
            }
            else {
                // Indica para o usuário que ele pode continuar a listagem ou sair
                System.out.println("\nDigite ENTER para continuar ou s para sair!");
                String escolha = entrada.nextLine();
                // Se o usuário digitar s interrompe o while
                if (escolha.equals("s")) {
                    continuar = false;
                }
            }
        }
    }

    private void buscarJogadorPorNome() {
        if (jogadores.size() == 0) {
            System.out.println("Dados de jogadores não foram carregados!");
            aguardarEnter();
            return;
        }
        System.out.println("Digite o nome do jogador a ser buscado");
        String nome = entrada.nextLine();

        int posicao = 0;
        boolean achou = false;
        while (posicao < jogadores.size() && !achou) {
            if (jogadores.get(posicao).getNome().equals(nome)) {
                achou = true;
                System.out.println(jogadores.get(posicao).getDescricao());
            }
            posicao++;
        }

        if (!achou) {
            System.out.println("Jogador não encontrado");
        }
        
        aguardarEnter();
    }

    private void buscarJogadorPorIndice() {
        if (jogadores.size() == 0) {
            System.out.println("Dados de jogadores não foram carregados!");
            aguardarEnter();
            return;
        }
        System.out.println("Digite o índice (posição) da lista de jogadores");
        int posicao = Integer.parseInt(entrada.nextLine());

        if (posicao >= 0 && posicao < jogadores.size()) {
            System.out.println(jogadores.get(posicao).getDescricao());
        }
        else {
            System.out.println("Índice inválido!");
        }
        
        aguardarEnter();
    }

}
