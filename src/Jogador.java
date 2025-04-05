public class Jogador {
    private String nome;
    private int ultimaTemporada;
    private String paisNascimento;
    private String cidadeNascimento;
    private String dataNascimento;
    private String posicao;
    private int alturaEmCm;
    private String clubeAtual;
    private int valorDeMercadoEuros;
    private int maiorValorDeMercadoEuros;

    public Jogador(String nome, int ultimaTemporada, String paisNascimento, String cidadeNascimento,
                    String dataNascimento, String posicao, int alturaEmCm, String clubeAtual,
                    int valorDeMercadoEuros, int maiorValorDeMercadoEuros) {
        this.nome = nome;
        this.ultimaTemporada = ultimaTemporada;
        this.paisNascimento = paisNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.dataNascimento = dataNascimento;
        this.posicao = posicao;
        this.alturaEmCm = alturaEmCm;
        this.clubeAtual = clubeAtual;
        this.valorDeMercadoEuros = valorDeMercadoEuros;
        this.maiorValorDeMercadoEuros = maiorValorDeMercadoEuros;
    }

    public String getNome() {
        return nome;
    }

    public int getUltimaTemporada() {
        return ultimaTemporada;
    }

    public String getPaisNascimento() {
        return paisNascimento;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getPosicao() {
        return posicao;
    }

    public int getAlturaEmCm() {
        return alturaEmCm;
    }

    public String getClubeAtual() {
        return clubeAtual;
    }

    public int getValorDeMercadoEuros() {
        return valorDeMercadoEuros;
    }

    public int getMaiorValorDeMercadoEuros() {
        return maiorValorDeMercadoEuros;
    }

    public String getDescricao() {
        String descricao = "    << " + nome + " >>";
        descricao += "\n  jogou no " + clubeAtual + " até a temporada " + ultimaTemporada;
        descricao += "\n  na posição " + posicao;
        
        if (cidadeNascimento.length() > 0) {
            descricao += "\n  nasceu em " + cidadeNascimento;
            if (paisNascimento.length() > 0) {
                descricao += " (" + paisNascimento + ")";
            }
        }
        else if (paisNascimento.length() > 0) {
            descricao += "\n  nasceu em " + paisNascimento;
        }
        else {
            descricao += "\n  (não há informação de nascimento)";
        }

        if (valorDeMercadoEuros > 0) {
            descricao += "\n  valor mais atual: " + valorDeMercadoEuros/1000000.0 + " milhões de euros";
            descricao += "\n  já valeu: " + maiorValorDeMercadoEuros/1000000.0 + " milhões de euros";
        }
        else {
            descricao += "\n  (não há informações sobre valor de mercado)";
        }
        return descricao;
    }
}
