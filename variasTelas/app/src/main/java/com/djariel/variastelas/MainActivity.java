package com.djariel.variastelas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.djariel.variastelas.R.id.Tela1;

public class MainActivity extends Activity {

    private Button btTela1;
    private Button btTela2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Menu);

        btTela1 = (Button) findViewById(R.id.btTela1);
        btTela1 = (Button) findViewById(R.id.btTela2);

        btTela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getBaseContext(), Tela1.class);
                startActivity(it);

            }
        });
        btTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getBaseContext(), Tela2.class);
                startActivity(it);

            }
        });


    }
}
