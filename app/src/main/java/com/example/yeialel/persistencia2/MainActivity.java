package com.example.yeialel.persistencia2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button botonAgregar, botonBorrar, botonListar;
    EditText textoNombreMascota, textoNombrePropietario, textoRazaMascota;

    ConexionBaseDatos conexion;  // conexion con la base de datos
    SQLiteDatabase db;  // Conecta con BD  para obtener metodos para modificar tabla.


    ListView listaMascotas; //Here declared the variable of ListView  ---> A
    ArrayList<DatosCrearLista> listaDatosMascotas;  // seran los datos almacenados
    ArrayAdapter adaptador;  // esto servira para llenar el listView


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Caja de texto en donde se ingresaran los datos
        textoNombreMascota = (EditText) findViewById(R.id.editTextNombreMascota);
        textoNombrePropietario = (EditText) findViewById(R.id.editTextNombrePropietario);
        textoRazaMascota = (EditText) findViewById(R.id.editTextRazaPerro);

        //botones de aciones a realizar
        botonAgregar = (Button) findViewById(R.id.buttonAgregar);
        botonBorrar = (Button) findViewById(R.id.buttonBorrar);
        botonListar = (Button) findViewById(R.id.buttonListar);

        //Esto es para poder acceder a las BD, crea una instancia de la subclase de 'SQLiteOpenHelper'
        conexion = new ConexionBaseDatos(this);

        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregar();  // Agrega datos a las base de datos.
            }
        });

        botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                borrar();
            }
        });

        botonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });



        listaMascotas = (ListView) findViewById(R.id.listaDatosPropietarioMascota);

        listaDatosMascotas = new ArrayList<DatosCrearLista>();
        listaDatosMascotas.add(new DatosCrearLista("tomas", "che", "labrador"));
        listaDatosMascotas.add(new DatosCrearLista("jorge", "pirulo", "doberman"));

        AdaptadorDatosCrearLista miAdaptador = new AdaptadorDatosCrearLista(getApplicationContext(),listaDatosMascotas);
        listaMascotas.setAdapter(miAdaptador);

    }

    //Funcion para agregar datos a la base de datos
    public void agregar(){
        //Esto realiza la conexion con la base de datos creada
        db = conexion.getWritableDatabase();
        ContentValues values = new ContentValues();
        //Esto parametros hacen referencia a las columnas de la tabla que se ingresaran datos
        values.put(BaseDatos.NOMBRE_COLUMNA2, textoNombreMascota.getText().toString());
        values.put(BaseDatos.NOMBRE_COLUMNA3, textoNombrePropietario.getText().toString());
        values.put(BaseDatos.NOMBRE_COLUMNA4, textoRazaMascota.getText().toString());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(BaseDatos.NOMBRE_TABLA,null, values);
        //Este mensaje saldra cada vez que se inserta bien un dato en la tabla
        Toast.makeText(getApplicationContext(), "Se guardo el registro con clave " + newRowId, Toast.LENGTH_LONG).show();
    }

    public void borrar(){
        //Esto realiza la conexion con la base de datos creada
        db = conexion.getWritableDatabase();
        // Aqui se especifica los campos que usaremos como criterio para borrar
        String selection = BaseDatos.NOMBRE_COLUMNA2 + " LIKE ? and " +
                           BaseDatos.NOMBRE_COLUMNA3 + " LIKE ?";  //nombre del perro y propietario
        // Aqui se captura el valor de la columnas seleccionadas como criterio
        String[] selectionArgumentos = {textoNombreMascota.getText().toString(),
                                        textoNombrePropietario.getText().toString()};
        // Aqui se pasan los parametros de los datos que queremos borrar
        db.delete(BaseDatos.NOMBRE_TABLA, selection, selectionArgumentos);
        //Mensaje para confirmar el borrado del dato
        Toast.makeText(getApplicationContext(), "Se ha borrado el registro de la mascota: " + textoNombreMascota.getText().toString(), Toast.LENGTH_LONG).show();
        //Esto es para limpiar los campos
        textoNombreMascota.setText("");
        textoNombrePropietario.setText("");
        textoRazaMascota.setText("");
    }


    public void Listar() {
        //Esto realiza la conexion con la base de datos creada
        db = conexion.getReadableDatabase();
        // Especificando las columnas que debe de devolver --> A
        String[] columnDevueltas = {
                BaseDatos.NOMBRE_COLUMNA2,
                BaseDatos.NOMBRE_COLUMNA3,
                BaseDatos.NOMBRE_COLUMNA3
        };


    }


    /*
    listaMascotas = (ListView) findViewById(R.id.listaDatosPropietarioMascota);

        listaDatosMascotas = new ArrayList<DatosCrearLista>();
        listaDatosMascotas.add(new DatosCrearLista("tomas", "che", "labrador"));
        listaDatosMascotas.add(new DatosCrearLista("jorge", "pirulo", "doberman"));

        AdaptadorDatosCrearLista miAdaptador = new AdaptadorDatosCrearLista(getApplicationContext(),listaDatosMascotas);
        listaMascotas.setAdapter(miAdaptador);
     */






    }
