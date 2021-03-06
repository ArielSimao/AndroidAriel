package andre.reebvfatecfinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import andre.reebvfatecfinal.banco.DAOReceita;
import andre.reebvfatecfinal.pojo.BeanReceita;

public class RecebeData extends Activity {


    public Button btnVoltar;
    public ListView lvDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recebedata);


        DAOReceita dr = new DAOReceita(getBaseContext());
        dr.open();
        lvDatas = (ListView)findViewById(R.id.lstData);

        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(getBaseContext(),
                android.R.layout.simple_list_item_1, dr.selectTodasDatas());

        new ArrayAdapter<BeanReceita>(getBaseContext(), android.R.layout.simple_list_item_2){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return super.getView(position, convertView, parent);
            }


        };

        dr.close();
        lvDatas.setAdapter(adapter);

        btnVoltar=(Button)findViewById(R.id.act_recebedata_btn_voltar);

        lvDatas.setOnItemClickListener(new ListView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String data = (String)parent.getItemAtPosition(position);

                Bundle parr = new Bundle();

                parr.putString("tipo","data");
                parr.putString("valor",data);//pega onde eu coloca a seleção do spinner

                Intent it = new Intent(getBaseContext(),Dados.class);
                it.putExtras(parr);

                startActivity(it);
                finish();
            }
        });


        btnVoltar.setOnClickListener(new View.OnClickListener() {// depois do new clicamos ctrl space e ele mostra as opções
            @Override
            public void onClick(View view) {

                finish();
            }
        });


    }

}
