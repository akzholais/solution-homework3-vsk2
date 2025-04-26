package src;

import java.util.*;

public class ControlTower implements TowerMediator {
    private Queue<Aircraft> landingQueue = new LinkedList<>();
    private Queue<Aircraft> takeoffQueue = new LinkedList<>();
    private List<Aircraft> aircrafts = new ArrayList<>();

    public void register(Aircraft aircraft) {
        aircrafts.add(aircraft);
        aircraft.setTower(this);
    }

    @Override
    public void broadcast(String msg, Aircraft sender) {
        if ("MAYDAY".equals(msg)) {
            System.out.println("[Tower] EMERGENCY from " + sender.getId() + "!");
            for (Aircraft ac : aircrafts) {
                if (ac != sender) {
                    ac.receive("Hold position!");
                }
            }
            sender.receive("Cleared for EMERGENCY landing!");
            return;
        }
        for (Aircraft ac : aircrafts) {
            if (ac != sender) {
                ac.receive(msg);
            }
        }
    }

    @Override
    public boolean requestRunway(Aircraft aircraft, String action) {
        Queue<Aircraft> queue = action.equals("landing") ? landingQueue : takeoffQueue;
        if (!queue.contains(aircraft)) {
            queue.add(aircraft);
            System.out.println("[Tower] " + aircraft.getId() + " requested " + action + ". Added to queue.");
            return true;
        }
        return false;
    }

    @Override
    public void processNext() {
        if (!landingQueue.isEmpty()) {
            for (Aircraft ac : new ArrayList<>(landingQueue)) {
                if (ac.isEmergency()) {
                    landingQueue.remove(ac);
                    grantRunway(ac, "landing");
                    return;
                }
            }
            Aircraft ac = landingQueue.poll();
            grantRunway(ac, "landing");
        } else if (!takeoffQueue.isEmpty()) {
            Aircraft ac = takeoffQueue.poll();
            grantRunway(ac, "takeoff");
        }
    }

    private void grantRunway(Aircraft aircraft, String action) {
        System.out.println("[Tower] " + aircraft.getId() + ": Cleared for " + action + " on runway.");
        aircraft.receive("Cleared for " + action);
        if ("landing".equals(action)) {
            aircraft.setEmergency(false);
        }
    }
}
