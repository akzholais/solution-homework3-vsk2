package src;

import java.util.Random;

public class Simulator {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        Aircraft[] aircrafts = new Aircraft[10];

        Random random = new Random();
        String[] types = {"PassengerPlane", "CargoPlane", "Helicopter"};

        for (int i = 0; i < 10; i++) {
            String type = types[random.nextInt(3)];
            Aircraft aircraft = null;
            if ("PassengerPlane".equals(type)) {
                aircraft = new PassengerPlane(type + "-" + (i + 1));
            } else if ("CargoPlane".equals(type)) {
                aircraft = new CargoPlane(type + "-" + (i + 1));
            } else if ("Helicopter".equals(type)) {
                aircraft = new Helicopter(type + "-" + (i + 1));
            }
            tower.register(aircraft);
            aircrafts[i] = aircraft;
        }

        new Thread(() -> {
            for (int step = 0; step < 20; step++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Aircraft ac = aircrafts[random.nextInt(10)];

                if (random.nextBoolean()) {
                    ac.send("MAYDAY");
                    System.out.println("[Emergency] Aircraft " + ac.getId() + " sending MAYDAY");
                } else {
                    ac.send(random.nextBoolean() ? "Requesting landing" : "Requesting takeoff");
                    System.out.println("[Normal] Aircraft " + ac.getId() + " requesting landing or takeoff");
                }

                tower.processNext();
                System.out.println("Step " + (step + 1) + " completed.");
            }

            System.out.println("Simulation finished after 20 steps.");
        }).start();
    }
}
