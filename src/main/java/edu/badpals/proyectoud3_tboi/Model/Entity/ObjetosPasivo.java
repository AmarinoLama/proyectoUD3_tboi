package edu.badpals.proyectoud3_tboi.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ObjetosPasivos")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("3")
public class ObjetosPasivo extends Objeto {

    @Column(name = "mejora_dano")
    private int mejoraDano;

    @Column(name = "mejora_velocidad")
    private int mejoraVelocidad;

    @Column(name = "mejora_lagrimas")
    private int mejoraLagrimas;

    @Column(name = "mejora_rango")
    private int mejoraRango;

    @Column(name = "mejora_suerte")
    private int mejoraSuerte;

    @Column(name = "mejora_salud")
    private int mejoraSalud;

    @Column(name = "mejora_velocidad_proyectil")
    private int mejoraVelocidadProyectil;

    public int getMejoraDano() {
        return mejoraDano;
    }

    public void setMejoraDano(int mejoraDano) {
        this.mejoraDano = mejoraDano;
    }

    public int getMejoraVelocidad() {
        return mejoraVelocidad;
    }

    public void setMejoraVelocidad(int mejoraVelocidad) {
        this.mejoraVelocidad = mejoraVelocidad;
    }

    public int getMejoraLagrimas() {
        return mejoraLagrimas;
    }

    public void setMejoraLagrimas(int mejoraLagrimas) {
        this.mejoraLagrimas = mejoraLagrimas;
    }

    public int getMejoraVelocidadProyectil() {
        return mejoraVelocidadProyectil;
    }

    public void setMejoraVelocidadProyectil(int mejoraVelocidadProyectil) {
        this.mejoraVelocidadProyectil = mejoraVelocidadProyectil;
    }

    public int getMejoraSalud() {
        return mejoraSalud;
    }

    public void setMejoraSalud(int mejoraSalud) {
        this.mejoraSalud = mejoraSalud;
    }

    public int getMejoraSuerte() {
        return mejoraSuerte;
    }

    public void setMejoraSuerte(int mejoraSuerte) {
        this.mejoraSuerte = mejoraSuerte;
    }

    public int getMejoraRango() {
        return mejoraRango;
    }

    public void setMejoraRango(int mejoraRango) {
        this.mejoraRango = mejoraRango;
    }
}