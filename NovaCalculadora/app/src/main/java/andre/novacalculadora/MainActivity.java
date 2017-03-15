package andre.novacalculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtValor1;
    private EditText edtValor2;
    private Button btnSoma;
    private Button btnSub;
    private Button btnMult;
    private Button btnDiv;
    private EditText result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValor1 = (EditText) findViewById(R.id.edtValor1);
        edtValor2 = (EditText) findViewById(R.id.edtValor2);
        btnSoma = (Button) findViewById(R.id.btnSoma);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        result = (EditText) findViewById(R.id.result);


        btnSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double Valor1 = Double.valueOf(edtValor1.getText().toString());
                Double Valor2 = Double.valueOf(edtValor2.getText().toString());
                Double result = Valor1 + Valor2;

                Intent it = new Intent(getBaseContext(), Resultado.class);
                Bundle parametros = new Bundle();
                parametros.putString("result",result.toString());
                it.putExtras(parametros);
                startActivity(it);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Double Valor1 = Double.valueOf(edtValor1.getText().toString());
                Double Valor2 = Double.valueOf(edtValor2.getText().toString());
                Double result = Valor1-Valor2;

                Intent it = new Intent(getBaseContext(), Resultado.class);
                Bundle parametros = new Bundle();
                parametros.putString("result",result.toString());
                it.putExtras(parametros);
                startActivity(it);
            }
        });


        btnMult.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Double Valor1 = Double.valueOf(edtValor1.getText().toString());
                Double Valor2 = Double.valueOf(edtValor2.getText().toString());
                Double result = Valor1*Valor2;

                Intent it = new Intent(getBaseContext(), Resultado.class);
                Bundle parametros = new Bundle();
                parametros.putString("result",result.toString());
                it.putExtras(parametros);
                startActivity(it);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Double Valor1 = Double.valueOf(edtValor1.getText().toString());
                Double Valor2 = Double.valueOf(edtValor2.getText().toString());
                Double result = Valor1/Valor2;

                Intent it = new Intent(getBaseContext(), Resultado.class);
                Bundle parametros = new Bundle();
                parametros.putString("result",result.toString());
                it.putExtras(parametros);
                startActivity(it);

            }
        });

    }

}