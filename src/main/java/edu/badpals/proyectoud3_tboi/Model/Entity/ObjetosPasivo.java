package edu.badpals.proyectoud3_tboi.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ObjetosPasivos")
@PrimaryKeyJoinColumn(name = "id_objeto")
@DiscriminatorValue("ObjetoPasivo")
public class ObjetosPasivo extends Objeto {

    @Column(name = "mejora_dano")
    private float mejoraDano;

    @Column(name = "mejora_velocidad")
    private float mejoraVelocidad;

    @Column(name = "mejora_lagrimas")
    private float mejoraLagrimas;

    @Column(name = "mejora_rango")
    private float mejoraRango;

    @Column(name = "mejora_suerte")
    private int mejoraSuerte;

    @Column(name = "mejora_salud")
    private int mejoraSalud;

    @Column(name = "mejora_velocidad_proyectil")
    private float mejoraVelocidadProyectil;

    public float getMejoraDano() {
        return mejoraDano;
    }

    public void setMejoraDano(float mejoraDano) {
        this.mejoraDano = mejoraDano;
    }

    public float getMejoraVelocidad() {
        return mejoraVelocidad;
    }

    public void setMejoraVelocidad(float mejoraVelocidad) {
        this.mejoraVelocidad = mejoraVelocidad;
    }

    public float getMejoraLagrimas() {
        return mejoraLagrimas;
    }

    public void setMejoraLagrimas(float mejoraLagrimas) {
        this.mejoraLagrimas = mejoraLagrimas;
    }

    public float getMejoraVelocidadProyectil() {
        return mejoraVelocidadProyectil;
    }

    public void setMejoraVelocidadProyectil(float mejoraVelocidadProyectil) {
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

    public float getMejoraRango() {
        return mejoraRango;
    }

    public void setMejoraRango(float mejoraRango) {
        this.mejoraRango = mejoraRango;
    }
}