package zooinvert.com;

import android.provider.BaseColumns;

public final class ContratoQuiz {
    private ContratoQuiz (){}

    public static class TabelaQuestao implements BaseColumns
    {
        public static final String NOME_TABELA = "quetoes_quiz";
        public static final String COLUNA_QUESTAO = "questao";
        public static final String COLUNA_OPCAO1 = "opcao1";
        public static final String COLUNA_OPCAO2 = "opcao2";
        public static final String COLUNA_OPCAO3 = "opcao3";
        public static final String COLUNA_OPCAO4 = "opcao4";
        public static final String COLUNA_NR_RESPOSTA = "nr_resposta";
    }
}
