Part 2 – Mediator Pattern
“Airport Tower Simulator”


Problem setting
Several aircraft (passenger planes, cargo planes, helicopters) need to land, take off, or 
taxi on a single runway. Letting aircraft talk to each other directly would be chaos, so a 
ControlTower mediates all communication and scheduling.

Learning Goals
Decouple many‑to‑many interactions into a single hub.
Centralize complex coordination rules (e.g., emergencies, runway queues).
Contrast Mediator with Observer.

Core interfaces (sketch)
    interface TowerMediator {
    void broadcast(String msg, Aircraft sender);
    boolean requestRunway(Aircraft a); // true when cleared
    }
    abstract class Aircraft {
    protected String id;
    public abstract void receive(String msg);
    public void send(String msg, TowerMediator m) { m.broadcast(msg, this); }
    }

Tasks
1. Implement ControlTower (concrete mediator). Maintain two queues: landing and take‑off. 
   Grant runway access in FIFO order but jump an emergency plane (low‑fuel or MAYDAY) to 
   the front.
2. Create concrete colleagues PassengerPlane, CargoPlane, Helicopter, each with its own 
   console reaction to received messages.

3. Add an emergency protocol: when any aircraft sends "MAYDAY", the tower clears the runway, 
   notifies all other planes to hold, and grants immediate landing.

4. Build a simulation driver that spawns ten random aircraft with random fuel levels, 
   uses ScheduledExecutorService to send requests every second, and shows tower decisions 
   in real time.

Engagement extras (optional)

 * Build a simple Swing or JavaFX dashboard showing runway status, queue lengths, and a 
   scrolling log.

 * Add a plugin mechanism so new aircraft types can register with the tower without changing 
   ControlTower code (Java ServiceLoader).

Deliverables
 * All Java classes (mediator, aircraft, simulation driver).
 * A console transcript (or screenshot of GUI) demonstrating normal landings and an emergency 
   case.
 * PlantUML or IntelliJ‑generated UML diagram (PNG).

 * One‑page reflection: Why is Mediator better than aircraft talking directly? Include at 
   least one disadvantage.

Stretch goal for honors credit
Extract the runway‑allocation logic into a RunwayScheduler strategy (fuelPriority, 
vipPriority, etc.) that the tower can swap at runtime, showing how Strategy combines with 
Mediator.

Suggested flow
 * Mediator interface and tower logic
 * Aircraft communicate only via tower
 * Emergency handling behaves as specified
 * Code style, comments, and naming
 * UML and reflection quality

 