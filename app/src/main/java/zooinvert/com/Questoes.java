package zooinvert.com;

public class Questoes {
    private String questao;
    private String opcao1;
    private String opcao2;
    private String opcao3;
    private String opcao4;
    private int nrResposta;

    public Questoes (){}

    public Questoes(String questao, String opcao1, String opcao2, String opcao3, String opcao4, int nrResposta) {
        this.questao = questao;
        this.opcao1 = opcao1;
        this.opcao2 = opcao2;
        this.opcao3 = opcao3;
        this.opcao4 = opcao4;
        this.nrResposta = nrResposta;
    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public String getOpcao1() {
        return opcao1;
    }

    public void setOpcao1(String opcao1) {
        this.opcao1 = opcao1;
    }

    public String getOpcao2() {
        return opcao2;
    }

    public void setOpcao2(String opcao2) {
        this.opcao2 = opcao2;
    }

    public String getOpcao3() {
        return opcao3;
    }

    public void setOpcao3(String opcao3) {
        this.opcao3 = opcao3;
    }

    public String getOpcao4() {
        return opcao4;
    }

    public void setOpcao4(String opcao4) {
        this.opcao4 = opcao4;
    }

    public int getNrResposta() {
        return nrResposta;
    }

    public void setNrResposta(int nrResposta) {
        this.nrResposta = nrResposta;
    }
}
