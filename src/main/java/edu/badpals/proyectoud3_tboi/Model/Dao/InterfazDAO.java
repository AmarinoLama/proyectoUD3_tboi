package edu.badpals.proyectoud3_tboi.Model.Dao;

public interface InterfazDAO<T> {

    void crearPersonaje(String Nombre);

    void eliminarPersonaje(int id);

    void addObjetoPasivoToPersonaje(int idPersonaje, int idObjeto);

    void addObjetoActivoToPersonaje(int idPersonaje, int idObjeto);

    void addConsumibleToPersonaje(int idPersonaje, int idObjeto);
}
