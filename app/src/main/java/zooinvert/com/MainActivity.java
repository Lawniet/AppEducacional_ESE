package zooinvert.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button BotaoComecar = findViewById(R.id.button_iniciar);
        BotaoComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comecarQuiz();
            }
        });
    }
    private void comecarQuiz(){
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}
