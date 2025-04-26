package src;

public abstract class Aircraft {
    protected String id;
    protected boolean emergency = false;
    protected ControlTower tower;

    public Aircraft(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    public void setTower(ControlTower tower) {
        this.tower = tower;
    }

    public abstract void receive(String msg);

    public void send(String msg) {
        System.out.println("[" + id + "] Sending: \"" + msg + "\"");
        tower.broadcast(msg, this);
    }
}
