package MediatorPattern.aircraft;

import MediatorPattern.mediator.TowerMediator;

public abstract class Aircraft {
    protected String id;
    protected int fuelLevel; // fuel level in area of 0 to 100 %

    public Aircraft(String id, int fuelLevel) {
        this.id = id;
        this.fuelLevel = fuelLevel;
    }
    //requirment nethod
    public abstract void receive(String msg);
    public void send(String msg, TowerMediator m) {
        m.broadcast(msg, this);
    }

    public String getId() {
        return id;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }
    public void decreaseFuel() {
        fuelLevel = Math.max(fuelLevel - 1, 0);
    }
        //getclass().getSimpleName() get class name from object.

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id + " (Fuel: " + fuelLevel + "%)";
    }
}
