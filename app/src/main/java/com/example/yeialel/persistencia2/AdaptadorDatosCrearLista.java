package com.example.yeialel.persistencia2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdaptadorDatosCrearLista extends BaseAdapter{

    //Este codigo es para poder cargar los datos del listView

    Context contexto;
    List<DatosCrearLista> ListaDatosMastotas;  // DatosCrearLista viene a ser una clase creada.

    //CONSTRUCTOR
    public AdaptadorDatosCrearLista(Context contexto, List<DatosCrearLista> listaDatosMastotas) {
        this.contexto = contexto;
        ListaDatosMastotas = listaDatosMastotas;
    }

    @Override
    public int getCount() {
        return ListaDatosMastotas.size(); //Esto retorna la cantidad de elementos de la lista
    }

    @Override
    public Object getItem(int posicion) {
        return ListaDatosMastotas.get(posicion); //Esto permite retornar el objeto de la posicion indicada
    }


    @Override
    public long getItemId(int posicion) {
        return 0;//ListaDatosMastotas.get(posicion).getId(); //Con esto se retorna el id de la posicion que se esta indicando
    }

    @Override
    public View getView(int posicion, View view, ViewGroup viewGroup) {
        View vista = view;

        LayoutInflater inflater = LayoutInflater.from(contexto);
        vista = inflater.inflate(R.layout.crear_lista, null);

        //Referencias a los datos.
        TextView nombrePropietario = (TextView) vista.findViewById(R.id.textViewPropietario);  //Referencia hacia el nombre del propietario
        TextView nombreMascota = (TextView) vista.findViewById(R.id.textViewMascota);  //Referencia hacia al nombre de la mascota
        TextView razaMascota = (TextView) vista.findViewById(R.id.textViewRaza);  // Referencia a la raza de la mascota

        //Los tres siguentes sirven para cargar los datos.
        nombrePropietario.setText(ListaDatosMastotas.get(posicion).getNombrePropietario().toString());
        nombreMascota.setText(ListaDatosMastotas.get(posicion).getNombreMascota().toString());
        razaMascota.setText(ListaDatosMastotas.get(posicion).getRazaMascota().toString());



        return vista;
    }
}
