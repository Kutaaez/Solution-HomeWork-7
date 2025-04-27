***Airport Tower Simulator – Mediator Mode***

This project implements the Mediator pattern for coordinating multiple aircraft (passenger planes, cargo planes, helicopters) on a single runway.  
Using the Mediator pattern, the application centralizes all communication and scheduling in a ControlTower, hiding internal coordination details and supporting both FIFO and emergency runway access.

**Project structure**

we have five module

- interface TowerMediator with methods `broadcast(String msg, Aircraft sender)` and `boolean requestRunway(Aircraft a)`
- class ControlTower implementing TowerMediator, maintains `landingQueue` and `takeoffQueue`, handles FIFO and emergency priority
- abstract class Aircraft with `String id`, `int fuelLevel`, abstract `receive(String msg)`, and method `send(String msg, TowerMediator m)`
- classes PassengerPlane, CargoPlane, Helicopter extending Aircraft and implementing `receive(...)` with console reactions
- class SimulationDriver using `ScheduledExecutorService` to spawn random aircraft, send requests, and log tower decisions

**Tasks and functionality**
1. TowerMediator defines `broadcast` and `requestRunway` methods.
2. ControlTower manages two queues and grants runway access, promoting emergency requests to the front.
3. Aircraft subclasses send landing or takeoff requests via the mediator and react to received messages.
4. Emergency protocol: any aircraft can send `"MAYDAY"`; the tower clears the runway, broadcasts hold messages, and grants immediate landing.
5. SimulationDriver spawns ten random aircraft, sends periodic requests, and outputs real-time logs.

***Why Mediator is preferable to direct communication***
- Mediator reduces coupling by having aircraft communicate only with the ControlTower, not with each other.
- Centralizes complex coordination rules in one location, making it easier to update or extend.
- Allows adding new aircraft types or scheduling behaviors without modifying existing classes.
- Provides a single point of control for prioritizing emergencies and managing runway allocation.
  
- What it solves: How to manage complex object
  interactions without them depending directly on each
  other

  
**Additional features (optional)**
- EmergencyAwareControlTower extension for extracting emergency logic.
- Swing or JavaFX dashboard for visualizing runway status and queue lengths.
- Plugin mechanism using Java ServiceLoader to support new aircraft types.
- Strategy integration for swapping runway-allocation algorithms at runtime.
