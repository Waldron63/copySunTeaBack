package edu.eci.cvds.labReserves.model;

public class Physical extends Resource {

    private boolean projector;
    private boolean TV;
    private int totalComputer;

    public Physical() {
        super();
    }
    
    public Physical(String name, boolean projector, boolean TV, int totalComputer) {
        super(name);
        this.projector = projector;
        this.TV = TV;
        this.totalComputer = totalComputer;
    }
    
    // Getters y setters
    public boolean isProjector() {
        return projector;
    }
    
    public void setProjector(boolean projector) {
        this.projector = projector;
    }
    
    public boolean isTV() {
        return TV;
    }
    
    public void setTV(boolean TV) {
        this.TV = TV;
    }
    
    public int getTotalComputer() {
        return totalComputer;
    }
    
    public void setTotalComputer(int totalComputer) {
        this.totalComputer = totalComputer;
    }
}
