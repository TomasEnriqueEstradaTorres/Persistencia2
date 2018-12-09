package com.example.yeialel.persistencia2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button botonAgregar, botonBorrar, botonListar;
    EditText textoNombreMascota, textoNombrePropietario, textoRazaMascota;

    ConexionBaseDatos conexion;  // conexion con la base de datos
    SQLiteDatabase db;  // Conecta con BD  para obtener metodos para modificar tabla.

    ListView listaMascotas; //Esto es donde se visualizara los datos que hay en la base de datos
    ArrayList<DatosCrearLista> listaDatosMascotas;  // seran los datos almacenados

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

        //BOTONES
        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregar();  // Agrega datos a las base de datos.
            }
        });

        botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                borrar(); //Funcion para borrar un registro de la base de datos usando dos parametros.
            }
        });

        botonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Funcion para mostrar el contenido de la base de datos en una lista ListView por medio de una ArrayList
                Listar();
            }
        });

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

    //Funcion para borrar un registro de la base de datos usando dos parametros.
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

    //Funcion para mostrar el contenido de la base de datos en una lista ListView por medio de una ArrayList
    public void Listar() {
        //Esto es el listView donde se mostraran los datos
        listaMascotas = (ListView) findViewById(R.id.listaDatosPropietarioMascota);
        //Esto es una ArrayList que contendra una lista de objetos con los datos de las mascotas
        listaDatosMascotas = new ArrayList<DatosCrearLista>();
        //Esto realiza la conexion con la base de datos creada
        db = conexion.getWritableDatabase();
        // busqueda de datos por medio de una sentencia SQL en la tabla
        String busqueda = "SELECT * FROM listado_de_perros";
        //cursor con el cual realizaremos la busqueda
        Cursor c = db.rawQuery(busqueda, null);

        if (c.moveToFirst()){  // con esto, se dice que nos moveremos desde el primer registro
            do{ //Agregara a la lista los datos obtenidos
                listaDatosMascotas.add(new DatosCrearLista(c.getString(1), c.getString(2), c.getString(3)));
                //Esto servira para adaptar los datos de la lista para que se usen en el ListView
                AdaptadorDatosCrearLista miAdaptador = new AdaptadorDatosCrearLista(getApplicationContext(),listaDatosMascotas);
                listaMascotas.setAdapter(miAdaptador);  //Aqui se agrega al ListView
            }while (c.moveToNext());  // Esto dice que mientra halla un siguiente registro el bucle continua
        }
    }


    public void limpiarCampos(View view){
        textoNombreMascota.setText("");
        textoNombrePropietario.setText("");
        textoRazaMascota.setText("");
    }



    }
