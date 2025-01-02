package edu.badpals.proyectoud3_tboi.Model.Dao;

import edu.badpals.proyectoud3_tboi.Model.Entity.Personaje;

public interface InterfazDAO<T> {

    Personaje crearPersonaje(String Nombre);

    void eliminarPersonaje(int id);

    void addObjetoPasivoToPersonaje(int idPersonaje, int idObjeto);

    void addObjetoActivoToPersonaje(int idPersonaje, int idObjeto);

    void addConsumibleToPersonaje(int idPersonaje, int idObjeto);
}
