package edu.eci.cvds.labReserves.model;

public class Software extends Resource {

    private String operativeSystem;
    private boolean partition;

    public Software() {
        super();
    }
    
    public Software(String name, String operativeSystem, boolean partition) {
        super(name);
        this.operativeSystem = operativeSystem;
        this.partition = partition;
    }
    
    // Getters y setters
    public String getOperativeSystem() {
        return operativeSystem;
    }
    
    public void setOperativeSystem(String operativeSystem) {
        this.operativeSystem = operativeSystem;
    }
    
    public boolean isPartition() {
        return partition;
    }
    
    public void setPartition(boolean partition) {
        this.partition = partition;
    }
}
