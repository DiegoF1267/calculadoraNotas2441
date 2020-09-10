package cl.inacap.calculadoranotas2441;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText notaTxt;
    private EditText pocentajeTxt;
    private Button agregatBtn;
    private Button limpiarBtn;
    private ListView notasLV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.notaTxt = findViewById(R.id.notaTxt);
        this.pocentajeTxt= findViewById(R.id.porcentajeTxt);
        this.agregatBtn = findViewById(R.id.agragrBtn);
        this.limpiarBtn=findViewById(R.id.limpiarBtn);
        this.notasLV =findViewById(R.id.notasLv);

        this.agregatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> errores= new ArrayList<>();
                String notaStr =notaTxt.getText().toString().trim();
                String porcentajeStr= pocentajeTxt.getText().toString().trim();
                int porcentaje;
                double nota;

                try {
                    nota = Double.parseDouble(notaStr);
                    if(nota<1.0||nota>7.0){
                        throw new NumberFormatException();
                    }
                }catch (NumberFormatException ex){
                    errores.add("-la nota debe ser un numero entre 1.0 y 7.0");
                }

                try {
                    porcentaje = Integer.parseInt(porcentajeStr);
                    if (porcentaje<1 || porcentaje>100){
                        throw new NumberFormatException();
                    }
                }catch (NumberFormatException ex){
                    errores.add("- El porcentaje debe ser un numero de entre 1 y 100");
                }
                if(errores.isEmpty()){
                    //ingresar nota
                    //TODO: ingresar nota y mostrarla en el Listview
                }else{
                    mostrarErrores(errores);
                }

            }
        });
    }
    private void mostrarErrores(List<String>errores){
        //1.generar una caena de texto con los errores
        String mensaje ="";
        for (String e: errores){
            mensaje+="-"+e+"\n";
        }
        //2.mostrar un mensaje de alerta
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
        alertBuilder.setTitle("Error de validacion").setMessage(mensaje).setPositiveButton("acceptar",null).create().show();
    }
}