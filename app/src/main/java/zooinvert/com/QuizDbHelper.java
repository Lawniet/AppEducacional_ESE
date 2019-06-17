package zooinvert.com;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import zooinvert.com.ContratoQuiz.*;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String NOME_BASEDADOS = "questoes.db";
    private static final int VERSAO_BASEDADOS = 1;
    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, NOME_BASEDADOS, null, VERSAO_BASEDADOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREAT_QUESTOES = "CREATE TABLE "+
                TabelaQuestao.NOME_TABELA +" ( "+
                TabelaQuestao._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TabelaQuestao.COLUNA_QUESTAO + " TEXT, " +
                TabelaQuestao.COLUNA_OPCAO1 + " TEXT, " +
                TabelaQuestao.COLUNA_OPCAO2 + " TEXT, " +
                TabelaQuestao.COLUNA_OPCAO3 + " TEXT, " +
                TabelaQuestao.COLUNA_OPCAO4 + " TEXT, " +
                TabelaQuestao.COLUNA_NR_RESPOSTA + " INTEGER" +
                ")";

        db.execSQL(SQL_CREAT_QUESTOES);
        preencheTabelaQuestoes();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TabelaQuestao.NOME_TABELA);
        onCreate(db);
    }
    private void preencheTabelaQuestoes()
    {
        Questoes q1 = new Questoes("1. Dentre os Subfilos de artrópodes abaixo relacionados, assinale a alternativa dos que possuem indivíduos com cefalotórax e abdome:",
                "a. Hexapoda e Myriapoda;", "b. Crustacea e Chelicerata;", "c. Myriapoda e Hexapoda;", "d. Chelicerata e Myriapoda.", 2);
        addQuestao(q1);
        Questoes q2 = new Questoes("2. Representam artrópodes que não possuem mandíbula e antenas:",
                " a. Arachnida;", "b. Insecta;", "c. Diplopoda;", "d. Crustáceos.", 1);
        addQuestao(q2);
        Questoes q3 = new Questoes("3. Sobre artrópodes estão corretas as alternativas:",
                "a. Possuem representantes que não apresentam exoesqueleto;", "b. Todos apresentam crescimento através de mudas ou ecdises;", "c. Todos os insetos apresentam asas;", "d. Chelicerata e Myriapoda.", 2);//4
        addQuestao(q3);
        Questoes q4 = new Questoes("4. Assinale as alternativas que representam artrópodes que apresentam somente respiração traqueal:",
                "a. Hexapoda;", "b. Myriapoda;", "c. Arachnida;", "d. Crustacea.", 1);//2
        addQuestao(q4);
        Questoes q5 = new Questoes("5. Sobre características comuns dos artrópodes assinale a alternativa correta:",
                "a. Celomados, deuterostômios e triblásticos;", "b. Pseudocelomados; protostômios e triblásticos;", "c. Celomados, protostômios, triblásticos;", "d. Simetria bilateral, protostômios e diblásticos.", 3);
        addQuestao(q5);
    }
    private void addQuestao (Questoes questao)
    {
        ContentValues cv = new ContentValues();
        cv.put(TabelaQuestao.COLUNA_QUESTAO, questao.getQuestao());
        cv.put(TabelaQuestao.COLUNA_OPCAO1, questao.getOpcao1());
        cv.put(TabelaQuestao.COLUNA_OPCAO2, questao.getOpcao2());
        cv.put(TabelaQuestao.COLUNA_OPCAO3, questao.getOpcao3());
        cv.put(TabelaQuestao.COLUNA_OPCAO4, questao.getOpcao4());
        cv.put(TabelaQuestao.COLUNA_NR_RESPOSTA, questao.getNrResposta());
        db.insert(TabelaQuestao.NOME_TABELA, null, cv);
    }
    public List<Questoes> getTodasQuestoes()
    {
        List<Questoes> questoesList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TabelaQuestao.NOME_TABELA, null);
        if(c.moveToFirst())
        {
            do
            {
                Questoes questao = new Questoes();
                questao.setQuestao(c.getString(c.getColumnIndex(TabelaQuestao.COLUNA_QUESTAO)));
                questao.setOpcao1(c.getString(c.getColumnIndex(TabelaQuestao.COLUNA_OPCAO1)));
                questao.setOpcao2(c.getString(c.getColumnIndex(TabelaQuestao.COLUNA_OPCAO2)));
                questao.setOpcao3(c.getString(c.getColumnIndex(TabelaQuestao.COLUNA_OPCAO3)));
                questao.setOpcao4(c.getString(c.getColumnIndex(TabelaQuestao.COLUNA_OPCAO4)));
                questao.setNrResposta(c.getInt(c.getColumnIndex(TabelaQuestao.COLUNA_NR_RESPOSTA)));
            }while (c.moveToNext());
        }
        c.close();
        return questoesList;
    }
}
