package MediatorPattern.simulationDriver;

import MediatorPattern.aircraft.Aircraft;
import MediatorPattern.aircraft.CargoPlane;
import MediatorPattern.aircraft.Helicopter;
import MediatorPattern.aircraft.PassengerPlane;
import MediatorPattern.mediator.ControlTower;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class SimulationDriver {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        List<Aircraft> aircraftList = new ArrayList<>();
        Random random = new Random();

        // generate 10 random aircracts
        for (int i = 1; i <= 10; i++) {
            int type = random.nextInt(3);
            Aircraft aircraft;
            int fuel = random.nextInt(81) + 20;  // level of fuel in area 20 to 100%
            switch (type) {
                case 0 -> aircraft = new PassengerPlane("P" + i, fuel);
                case 1 -> aircraft = new CargoPlane("C" + i, fuel);
                default -> aircraft = new Helicopter("H" + i, fuel);
            }
            tower.registerAircraft(aircraft);  // regestr airctaft to controltower
            aircraftList.add(aircraft);
        }

        // taskmanager for imitation of action
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        // emultaion request for load of
        executor.scheduleAtFixedRate(() -> {
            Aircraft aircraft = aircraftList.get(random.nextInt(aircraftList.size()));  // Выбор случайного самолета

            // if fuel low send MAYDAY
            if (aircraft.getFuelLevel() < 10) {
                aircraft.send("MAYDAY", tower);
            } else {
                // or random we wanna know it's request to load of or not
                if (random.nextBoolean()) {
                    if (tower.requestRunway(aircraft)) {
                        aircraft.receive("Landing now...");
                        tower.releaseRunway();
                    }
                } else {
                    tower.requestTakeoff(aircraft);
                    tower.releaseRunway();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);


        Executors.newSingleThreadScheduledExecutor().schedule(() -> {
            executor.shutdown();
            System.out.println("\n[Simulation finished]");
        }, 15, TimeUnit.SECONDS);
    }
}
