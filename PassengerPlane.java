package src;

public class PassengerPlane extends Aircraft {
    public PassengerPlane(String id) {
        super(id);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[" + id + "] Sending: \"" + msg + "\"");
        if (msg.contains("Cleared for landing")) {
            System.out.println("[" + id + "] Lowering landing gear.");
        }
    }
}
