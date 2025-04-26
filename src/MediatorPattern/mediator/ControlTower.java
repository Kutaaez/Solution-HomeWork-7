package MediatorPattern.mediator;
import MediatorPattern.aircraft.Aircraft;

import java.util.*;
public class ControlTower implements TowerMediator {
    private List<Aircraft> aircrafts = new ArrayList<>();
    private Queue<Aircraft> landingQueue = new LinkedList<>();
    private Queue<Aircraft> takeoffQueue = new LinkedList<>();
    private boolean runwayAvailable = true;

    @Override
    public void broadcast(String message, Aircraft sender) {
        System.out.println("[Tower] Message from " + sender.getId() + ": " + message);

        if (message.equalsIgnoreCase("MAYDAY")) {
            handleEmergency(sender);
        } else {
            for (Aircraft a : aircrafts) {
                if (a != sender) {
                    a.receive(message);
                }
            }
        }
    }

    @Override
    public boolean requestRunway(Aircraft aircraft) {
        if (!runwayAvailable) {
            // write to queue for situation
            if (aircraft.getFuelLevel() <= 10) {
                System.out.println("[Tower] Emergency detected due to low fuel from " + aircraft.getId());
                landingQueue.add(aircraft);  // Срочная посадка
            } else {
                landingQueue.add(aircraft);
                System.out.println("[Tower] " + aircraft.getId() + " added to landing queue.");
            }
            return false;
        }

        // if free
        runwayAvailable = false;
        System.out.println("[Tower] " + aircraft.getId() + " is cleared for immediate runway access.");
        return true;
    }

    public void registerAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    public void releaseRunway() {
        runwayAvailable = true;
        System.out.println("[Tower] Runway is now available.");
        processNextAircraft();
    }

    private void handleEmergency(Aircraft emergencyAircraft) {
        System.out.println("[Tower] EMERGENCY! " + emergencyAircraft.getId() + " needs immediate landing!");
        // clear queue for emergency position
        landingQueue.clear();
        takeoffQueue.clear();
        // call for all aircaft
        for (Aircraft a : aircrafts) {
            if (a != emergencyAircraft) {
                a.receive("Hold position. Emergency in progress.");
            }
        }
        // emergency stay
        runwayAvailable = true;
        if (requestRunway(emergencyAircraft)) {
            System.out.println("[Tower] " + emergencyAircraft.getId() + " is landing immediately.");
        }
    }

    private void processNextAircraft() {
        if (!landingQueue.isEmpty()) {
            Aircraft nextLanding = landingQueue.poll();
            System.out.println("[Tower] Next to land: " + nextLanding);
            requestRunway(nextLanding);
        } else if (!takeoffQueue.isEmpty()) {
            Aircraft nextTakeoff = takeoffQueue.poll();
            System.out.println("[Tower] Next to take off: " + nextTakeoff);
            requestRunway(nextTakeoff);
        } else {
            System.out.println("[Tower] No aircrafts waiting.");
        }
    }

    public boolean requestTakeoff(Aircraft aircraft) {
        if (!runwayAvailable) {
            takeoffQueue.add(aircraft);
            System.out.println("[Tower] " + aircraft.getId() + " added to takeoff queue.");
            return false;
        }


        runwayAvailable = false;
        System.out.println("[Tower] " + aircraft.getId() + " is cleared for takeoff.");
        return true;
    }
}
