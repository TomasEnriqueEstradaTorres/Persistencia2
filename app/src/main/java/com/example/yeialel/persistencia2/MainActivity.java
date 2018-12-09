package com.example.yeialel.persistencia2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button botonAgregar, botonBorrar, botonListar;
    EditText textoNombreMascota, textoNombrePropietario, textoRazaMascota;

    ConexionBaseDatos conexion;  // conexion con la base de datos
    SQLiteDatabase db;  // Conecta con BD  para obtener metodos para modificar tabla.

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

            }
        });

        botonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                //Esto realiza la conexion con la base de datos creada
                SQLiteDatabase db = helper.getReadableDatabase();
                // Especificando las columnas que debe de devolver --> A
                String[] columnDevueltas = {
                        EstructuraBBDD.NOMBRE_COLUMNA2,
                        EstructuraBBDD.NOMBRE_COLUMNA3
                };
                // esto es el codigo del filtrado del registro --> B
                String idSeleccionado = EstructuraBBDD.NOMBRE_COLUMNA1 + " = ?";  //Esto es el campo de criterio para la busqueda (consulta preparada)
                String[] seleccionArgumento = {textoId.getText().toString()}; // Aqui se dice de donde se obtiene el critero de busqueda --> C
                try{
                    //Esto es una tabla virtual que se almacene en 'c'
                    Cursor c = db.query(
                            EstructuraBBDD.TABLE_NAME,  //nombre de la tabla
                            columnDevueltas,  // corresponde al array, especificando las columnas que debe de devolver --> A
                            idSeleccionado,  // hace referencia a la columna o columnas que tienen criterio de busqueda --> B
                            seleccionArgumento,  // hace referencia al array donde se especifica de donde viene el criterio --> C
                            null,   //Esto dos hacen referencia a filtrar por grupo
                            null,
                            null  // ordenamiento
                    );
                    c.moveToFirst(); // se mueve el cursor al primer registro
                    // aqui dice donde leer la informacion del primer registro
                    textoNombre.setText(c.getString(0));
                    textoApellido.setText(c.getString(1));
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "No existe un producto con el Id: " + textoId.getText().toString(), Toast.LENGTH_LONG).show();
                }
                 */
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

    public void borrar(){
        /*
        //Esto realiza la conexion con la base de datos creada
        db = conexion.getWritableDatabase();
        // Aqui se especifica el campo que usaremos como criterio para borrar
        String selection = BaseDatos.NOMBRE_COLUMNA1 + " LIKE ?";
        // Aqui se captura el valor de la columna seleccionada como criterio
        String[] selectioArgs = {textoId.getText().toString()};
        // Aqui se pasan los parametros de los datos que queremos borrar
        db.delete(BaseDatos.NOMBRE_TABLA, selection, selectioArgs);
        //Mensaje para confirmar el borrado del dato
        Toast.makeText(getApplicationContext(), "Se ha borrado el registro: " + textoId.getText().toString(), Toast.LENGTH_LONG).show();
        //Esto es para limpiar los campos
        textoNombreMascota.setText("");
        textoNombrePropietario.setText("");
        textoRazaMascota.setText("");
        */
    }





    public void Listar() {

        /*
        ArrayAdapter<String> adaptador;
        List<String> llista = new ArrayList<String>();

        //Tu QUERY con un Cursor llamado c

        if (c.getCount() == 0)
            llista.add("No hay registros");
        else {
            while (c.moveToNext())
                llista.add(c.getString(0) + "-" + c.getString(1));
            adaptador = new ArrayAdapter<String>(getApplicationContext(), R.layout.LAYOUT2, llista);
            LISTVIEW(cal declarar-lo).setAdapter(adaptador);
            */
    }




    }
