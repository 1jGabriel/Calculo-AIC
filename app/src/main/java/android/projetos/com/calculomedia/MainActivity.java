package android.projetos.com.calculomedia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private EditText notaProfessor;
    private EditText notaAic;
    private TextView resultado;
    private Button calcular;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notaProfessor = (EditText) findViewById(R.id.NotaProfessorId);
        notaAic = (EditText) findViewById(R.id.notaAICId);
        resultado = (TextView) findViewById(R.id.resultadoNotaId);
        calcular = (Button) findViewById(R.id.CalcularNotaButton);


        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String notaProfessorString = notaProfessor.getText().toString();
                String notaAicString = notaAic.getText().toString();

                if (notaProfessorString.isEmpty() || notaAicString.isEmpty()){
                    resultado.setText("Todos Campos são necessários");
                }else if(Integer.parseInt(notaProfessorString)>10 || Integer.parseInt(notaProfessorString)<0 || Integer.parseInt(notaAicString)>10 || Integer.parseInt(notaAicString)<0){
                    resultado.setText("Digitar nota entre 0 e 10");
                }


                else{

                    calcularNotaAv2(notaProfessorString, notaAicString);


                }
            }
        });
    }

    private void calcularNotaAv2(String notaProfessorString, String notaAicString) {
        Double resultado2;

        resultado2 =

        Double.valueOf(String.format(Locale.UK, "%.2f", (((Double.parseDouble(notaProfessorString)* 3.2) + (Double.parseDouble(notaAicString) * 0.8))/4)));

        resultado.setText(""+resultado2);
    }
}
