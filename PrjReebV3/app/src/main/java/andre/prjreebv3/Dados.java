package andre.prjreebv3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dados extends Activity {

    private Button btnDRec;
    private Button btnSair;
    private Button btnVoltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);


        btnDRec = (Button) findViewById(R.id.btnDRec);
        btnSair = (Button) findViewById(R.id.btnSair);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);  //Temos que trazer as views que fazem o movimento, no caso os botões


        btnDRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//declarando o metodo onClick
                Intent it = new Intent(getBaseContext(),BuscaReceitas.class);
                startActivity(it);
            }
        });



        btnSair.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(Dados.this);
                a_builder.setMessage("Tem certeza que deseja sair do REEB ??")
                        .setCancelable(false)
                        .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Atenção !!!");
                alert.show();
            }

            //onBackPressed();

        });


        btnVoltar.setOnClickListener(new View.OnClickListener() {// depois do new clicamos ctrl space e ele mostra as opções
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getBaseContext(), Menu.class);//volta para a tela Menu
                startActivity(it);


            }
        });


    }
}
