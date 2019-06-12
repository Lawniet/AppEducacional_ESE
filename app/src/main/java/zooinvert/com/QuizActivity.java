package zooinvert.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView textMostraQuestao;
    private TextView textMostraPontos;
    private TextView textMostraContQuestao;
    private TextView textMostraTimer;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button buttonConfirma;

    private List<Questoes> questoesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textMostraQuestao = findViewById(R.id.text_questoes);
        textMostraPontos = findViewById(R.id.text_mostra_pontuacao);
        textMostraContQuestao = findViewById(R.id.text_mostra_qtd_questoes);
        textMostraTimer = findViewById(R.id.text_timer);
        rbGroup = findViewById(R.id.radio_group_alternativas);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        buttonConfirma = findViewById(R.id.button_confirma);
        QuizDbHelper dbHelper = new QuizDbHelper(this);
        questoesList = dbHelper.getTodasQuestoes();
    }
}
