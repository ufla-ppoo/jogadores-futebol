import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.ArrayList;

public class Dados {
    // O arquivo jogadores.csv é um subconjunto dos dados baixados de:
    // https://www.kaggle.com/datasets/davidcariboo/player-scores?resource=download&select=players.csv
    private static final String CAMINHO_ARQUIVO = "arquivos/jogadores.csv";

    /**
     * Tenta ler um campo como String, se não for possível retorna string vazia
     * @param campos Vetor com os campos de uma linha do arquivo
     * @param posicao Posicao no vetor da informação a ser lida como string
     * @return O valor do campo como string ou uma string vazia
     */
    private static String lerCampoString(String[] campos, int posicao) {
        // Se a posição existe no vetor, o valor da posição é retornado.
        // Caso contrário, retorna string vazia.
        if (posicao < campos.length) {
            // obs.: o método trim remove espaços no início e no final da string.
            String campo = campos[posicao].trim();
            // Remove acentos e retorna o texto normalizado
            return removerAcentos(campo);
        }
        return "";
    }

    /**
     * Tenta ler um campo como String, se não for possível retorna -1
     * @param campos Vetor com os campos de uma linha do arquivo
     * @param posicao Posicao no vetor da informação a ser lida como inteiro
     * @return O valor do campo como int ou -1
     */
    private static int lerCampoInteiro(String[] campos, int posicao) {
        // Se a posição existe no vetor
        if (posicao < campos.length) {
            // Se o campo não está vazio
            if (campos[posicao] != null && !campos[posicao].trim().isEmpty()) {
                // Converte o valor do campo para inteiro e o retorna
                return Integer.parseInt(campos[posicao]);
            }
        }
        // Se a posição não existe no vetor ou o campo está vazio retorna -1
        return -1;
    }

    /**
     * Remove acentos de uma string
     * @param texto Texto a ser processado
     * @return Texto sem acentos
     */
    private static String removerAcentos(String texto) {
        if (texto == null) {
            return null;
        }
        // Normaliza o texto para a forma NFD e remove marcas de acentuação
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return texto.replaceAll("\\p{M}", ""); // Remove marcas de acentuação
    }

    public static ArrayList<Jogador> carregarDadosJogadores() {
        ArrayList<Jogador> jogadores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(CAMINHO_ARQUIVO), "UTF-8"))) {
            // Ignorar a primeira linha (cabeçalho)
            String linha = br.readLine(); 
            // Trata uma linha por vez enquanto não terminar o arquivo
            while ((linha = br.readLine()) != null) {
                // Quebra a linha usando a vírgula como separador
                // Com isso, o valor de cada campo será guardado como um elemento do vetor.
                String[] campos = linha.split(",");
                // Cria um objeto jogador com os dados lidos da linha do arquivo
                Jogador jogador = new Jogador(
                    lerCampoString(campos, 0), // nome
                    lerCampoInteiro(campos, 1), // ultimaTemporada
                    lerCampoString(campos, 2), // paisNascimento
                    lerCampoString(campos, 3), // cidadeNascimento
                    lerCampoString(campos, 4), // dataNascimento
                    lerCampoString(campos, 5), // posicao
                    lerCampoInteiro(campos, 6), // alturaEmCm
                    lerCampoString(campos, 7), // clubeAtual
                    lerCampoInteiro(campos, 8), // valorDeMercadoEuros
                    lerCampoInteiro(campos, 9)  // maiorValorDeMercadoEuros
                );
                // adiciona o jogador à lista de jogadores
                jogadores.add(jogador);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + CAMINHO_ARQUIVO + ": " + e.getMessage());
        }

        return jogadores;
    }
}
