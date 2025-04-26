package src;

public class Helicopter extends Aircraft {
    public Helicopter(String id) {
        super(id);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[" + id + "] Sending: \"" + msg + "\"");
        if (msg.contains("Cleared for takeoff")) {
            System.out.println("[" + id + "] Starting rotors.");
        }
    }
}
