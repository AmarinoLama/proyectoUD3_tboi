package edu.badpals.proyectoud3_tboi.Model.Entity;

public enum TipoHabitacion {
    NORMAL("Normal"),
    TESORO("Tesoro"),
    JEFE("Jefe"),
    SECRETA("Secreta"),
    SUPER_SECRETA("Super Secreta"),
    ULTRA_SECRETA("Ultra Secreta"),
    TIENDA("Tienda"),
    ANGELICAL("Angelical"),
    DEMONIACA("Demoniaca"),
    SACRIFICIO("Sacrificio"),
    PLANETARIO("Planetario"),
    BIBLIOTECA("Biblioteca");

    private final String nombre;

    TipoHabitacion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public static TipoHabitacion fromNombre(String nombre) {
        for (TipoHabitacion tipo : TipoHabitacion.values()) {
            if (tipo.getNombre().equalsIgnoreCase(nombre)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de habitación no válido: " + nombre);
    }
}
