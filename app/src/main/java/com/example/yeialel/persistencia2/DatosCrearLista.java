package com.example.yeialel.persistencia2;

public class DatosCrearLista {

    /**Tanto el archivo "AdaptadorDatosCrearLista.class", como el "DatosCrearLista.class"
     * ambos han sido creados para poder cargar los datos en un ListView que esta en "crear_lista.xml"
     * que es la plantilla de diseño para colocar en "activity_busxml"
     * */


    //Estas son la variables para poder acceder a la informacion que va a ir en el listView
    //private int id;
    private String nombrePropietario, nombreMascota, razaMascota;

    //CONSTRUCTOR
    public DatosCrearLista(String nombrePropietario, String nombreMascota, String razaMascota) {
        //this.id = id;
        this.nombrePropietario = nombrePropietario;
        this.nombreMascota = nombreMascota;
        this.razaMascota = razaMascota;
    }


    //SETTER Y GETTER
    //public int getId() {return id;    }

    //public void setId(int id) { this.id = id;   }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getRazaMascota() {
        return razaMascota;
    }

    public void setRazaMascota(String razaMascota) {
        this.razaMascota = razaMascota;
    }
}
