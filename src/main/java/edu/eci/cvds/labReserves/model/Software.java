package edu.eci.cvds.labReserves.model;

/**
 * Representa un recurso de software en el sistema de reservas de laboratorios.
 * Extiende la clase Resource e incluye información adicional sobre el sistema operativo y partición.
 */
public class Software extends Resource {

    private String operativeSystem;
    private boolean partition;

    /**
     * Constructor por defecto.
     * Inicializa una instancia de Software sin valores específicos.
     */
    public Software() {
        super();
    }

    /**
     * Constructor con parámetros.
     *
     * @param name Nombre del software.
     * @param operativeSystem Sistema operativo en el que se ejecuta el software.
     * @param partition Indica si el software requiere una partición especial.
     */
    public Software(String name, String operativeSystem, boolean partition) {
        super(name);
        this.operativeSystem = operativeSystem;
        this.partition = partition;
    }
    
    // Getters y setters
    /**
     * Obtiene el sistema operativo en el que se ejecuta el software.
     *
     * @return El sistema operativo del software.
     */
    public String getOperativeSystem() {
        return operativeSystem;
    }

    /**
     * Establece el sistema operativo en el que se ejecuta el software.
     *
     * @param operativeSystem El sistema operativo a asignar.
     */
    public void setOperativeSystem(String operativeSystem) {
        this.operativeSystem = operativeSystem;
    }

    /**
     * Indica si el software requiere una partición especial.
     *
     * @return true si requiere partición, false en caso contrario.
     */
    public boolean isPartition() {
        return partition;
    }

    /**
     * Establece si el software requiere una partición especial.
     *
     * @param partition true si requiere partición, false en caso contrario.
     */
    public void setPartition(boolean partition) {
        this.partition = partition;
    }
}
