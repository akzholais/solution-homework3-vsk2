package src;

public class CargoPlane extends Aircraft {
    public CargoPlane(String id) {
        super(id);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[" + id + "] Sending: \"" + msg + "\"");
        if (msg.contains("Cleared for landing")) {
            System.out.println("[" + id + "] Preparing cargo doors.");
        }
    }
}
