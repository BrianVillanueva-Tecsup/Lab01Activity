package pe.bvillanueva.lab01.app;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner opciones;
    TextView textViewT;
    TextView textViewL;
    EditText editText1T;
    EditText editText2T;
    EditText editText1L;
    EditText editText2L;
    EditText editText3L;
    EditText editText4L;
    TextView textViewTo;
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1T=(EditText) findViewById(R.id.nota1T);
        editText2T=(EditText) findViewById(R.id.nota2T);
        editText1L=(EditText) findViewById(R.id.nota1L);
        editText2L=(EditText) findViewById(R.id.nota2L);
        editText3L=(EditText) findViewById(R.id.nota3L);
        editText4L=(EditText) findViewById(R.id.nota4L);
        textViewT=(TextView) findViewById(R.id.promT);
        textViewL=(TextView) findViewById(R.id.promL);
        textViewTo=(TextView) findViewById(R.id.total);



        opciones=(Spinner)findViewById(R.id.sp01);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.opciones,android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);
    }

    public void evualuarT(View view){
        String calt1=editText1T.getText().toString();
        String calt2=editText2T.getText().toString();
        String call1=editText1L.getText().toString();
        String call2=editText2L.getText().toString();
        String call3=editText3L.getText().toString();
        String call4=editText4L.getText().toString();


        int calificaciont1=Integer.parseInt(calt1);
        int calificaciont2=Integer.parseInt(calt2);

        int calificacionl1=Integer.parseInt(call1);
        int calificacionl2=Integer.parseInt(call2);
        int calificacionl3=Integer.parseInt(call3);
        int calificacionl4=Integer.parseInt(call4);

        int myr=Math.max(calificaciont1,calificaciont2);
        double promediot=myr*0.3;

        double promediol=((calificacionl1+calificacionl2+calificacionl3+calificacionl4)/4)*0.7;

        double promediofinal=promediol+promediot;

        textViewT.setText("prom: "+promediot);
        textViewL.setText("prom: " +promediol);


        if (promediofinal>=13){
            textViewTo.setText("Aprobado con: "+promediofinal);
            textViewTo.setTextColor(Color.GREEN);
        }else if(promediofinal<=12){
            textViewTo.setText("Desaprobado , bica noma con : "+promediofinal);
            textViewTo.setTextColor(Color.RED);
        }


    }
}
