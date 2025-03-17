package edu.eci.cvds.labReserves.model;

/**
 * Representa un recurso físico disponible en un laboratorio, como proyectores, televisores y computadoras.
 */
public class Physical extends Resource {

    private boolean projector;
    private boolean TV;
    private int totalComputer;

    /**
     * Constructor por defecto de la clase Physical.
     */
    public Physical() {
        super();
    }

    /**
     * Constructor que inicializa los atributos de la clase Physical.
     *
     * @param name Nombre del recurso físico.
     * @param projector Indica si el recurso tiene proyector.
     * @param TV Indica si el recurso tiene televisor.
     * @param totalComputer Número total de computadoras disponibles.
     */
    public Physical(String name, boolean projector, boolean TV, int totalComputer) {
        super(name);
        this.projector = projector;
        this.TV = TV;
        this.totalComputer = totalComputer;
    }
    
    // Getters y setters
    /**
     * Obtiene si el recurso tiene un proyector disponible.
     *
     * @return true si tiene proyector, false en caso contrario.
     */
    public boolean isProjector() {
        return projector;
    }

    /**
     * Establece si el recurso tiene un proyector disponible.
     *
     * @param projector true si tiene proyector, false en caso contrario.
     */
    public void setProjector(boolean projector) {
        this.projector = projector;
    }

    /**
     * Obtiene si el recurso tiene un televisor disponible.
     *
     * @return true si tiene televisor, false en caso contrario.
     */
    public boolean isTV() {
        return TV;
    }

    /**
     * Establece si el recurso tiene un televisor disponible.
     *
     * @param TV true si tiene televisor, false en caso contrario.
     */
    public void setTV(boolean TV) {
        this.TV = TV;
    }

    /**
     * Obtiene el número total de computadoras disponibles en el recurso.
     *
     * @return Número total de computadoras.
     */
    public int getTotalComputer() {
        return totalComputer;
    }

    /**
     * Establece el número total de computadoras disponibles en el recurso.
     *
     * @param totalComputer Número total de computadoras.
     */
    public void setTotalComputer(int totalComputer) {
        this.totalComputer = totalComputer;
    }
}
