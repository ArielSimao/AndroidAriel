package andre.novacalculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Resultado extends AppCompatActivity {

    private EditText result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        result = (EditText) findViewById(R.id.result);

        Intent it = getIntent();
        Bundle parametros = it.getExtras();


        if(parametros !=null) {

            String j =(String)parametros.get("result");

            result .setText(j);

        }else{

            Toast.makeText(getBaseContext(),"Resultado inválido",
                    Toast.LENGTH_LONG).show();
            }

    }
}
