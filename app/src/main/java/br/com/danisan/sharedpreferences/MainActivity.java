package br.com.danisan.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText nomeDigitado;
    private Button botaoSalvar;
    private TextView nomeResultado;
    private SharedPreferences preferences;
    private static final String ARQUIVO_PREFERENCIA="Arquivo Preferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeDigitado = findViewById(R.id.digite_nome);
        botaoSalvar = findViewById(R.id.botao_salvar);
        nomeResultado = findViewById(R.id.resultado_nome);

       botaoSalvar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {



               preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);

               SharedPreferences.Editor editor = preferences.edit();
               if(nomeDigitado.getText().toString().equals("")){
                   Toast.makeText(getApplicationContext(),"Digite um nome",Toast.LENGTH_SHORT).show();
               }else{
                   String nome = nomeDigitado.getText().toString();
                   editor.putString("nome",nome);
                   editor.commit();
                   nomeResultado.setText("Olá"+" "+nome);
               }


           }
       });

        preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if(preferences.contains("nome")){
           String nome = preferences.getString("nome","Usuario Inesistente");
           nomeResultado.setText(nome);
        }else{
            Toast.makeText(getApplicationContext(),"Usuario Inesistente",Toast.LENGTH_SHORT).show();
        }

    }
}