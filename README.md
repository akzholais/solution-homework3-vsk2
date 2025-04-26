# Streaming-Service Binge Mode

This project demonstrates the **Iterator Pattern** applied to a streaming service, simulating a binge-watching experience across multiple seasons with different episode iteration orders.

---

## Description

This application simulates a streaming platform where users can binge-watch TV series. The user can iterate over episodes in a normal order, reverse order, or a shuffled order. Additional features include skipping intros and filtering episodes based on viewing history.

---

## Implemented

- **EpisodeIterator** interface (`hasNext()`, `next()`)
- Concrete iterators:
  - **SeasonIterator** (Normal order)
  - **ReverseSeasonIterator** (Reverse order)
  - **ShuffleSeasonIterator** (Shuffled order with fixed seed)
- Additional iterators:
  - **SkipIntroIterator** (Skips intro at a given timestamp)
  - **WatchHistoryFilterIterator** (Filters out watched episodes)
- **BingeIterator**:
  - Iterates through all seasons from start to finish
  - Supports multiple traversal modes
- **Season** class implementing `Iterable<Episode>`

---

## Bonus Features Implemented

- **Skip Intro**: Starts each episode at a specified time, skipping the intro sequence.
- **Watch History Filter**: Filters out episodes that have already been watched, enabling users to watch only unseen episodes.
- **CLI Simulation**: Allows users to interact with the application and test various iteration modes (normal, reverse, shuffle, skip intro, history filter).
- **Performance Testing**: Measures and compares the performance of different iterators when processing 10,000 episodes.

---

## Performance Testing

- **Goal**: Compare the performance of different iterators (`SeasonIterator`, `ReverseSeasonIterator`, `ShuffleSeasonIterator`) when iterating through 10,000 episodes.
- **Method**: 
    - The performance was measured by timing the execution of each iterator type over a list of 10,000 generated episodes.
    - The results are used to assess which iteration method is the most efficient.

- **Expected Results**:
    - **SeasonIterator**: Should perform the fastest as it iterates through the list in a straightforward, sequential manner.
    - **ReverseSeasonIterator**: Might take slightly longer due to the reverse traversal.
    - **ShuffleSeasonIterator**: Should be the slowest as it requires randomizing the order of episodes before iteration.

---

## Usage

1. **Normal Order**: Default iteration through episodes as they appear in the season.
2. **Reverse Order**: Iterates through episodes in reverse, from the last to the first.
3. **Shuffled Order**: Randomizes the episode order with a fixed seed to ensure repeatable results.
4. **Skip Intro**: Skips the intro sequence by starting the episode at a given timestamp.
5. **Watch History Filter**: Displays only the episodes that have not been watched.


---


# Airport Tower Simulator

## Description
This project is an airport control tower simulator that models the interaction between different types of aircraft (passenger planes, cargo planes, helicopters) using the **Mediator** pattern. All aircraft interact through a central object, the **ControlTower**, which manages landing requests, takeoff requests, and emergency situations.

## Tasks:
1. Implemented the **Mediator** pattern, managing interactions between aircraft and the control tower.
2. Created classes for different types of aircraft: **PassengerPlane**, **CargoPlane**, **Helicopter**.
3. Implemented landing and takeoff queues with priority for emergency cases (MAYDAY).
4. Added the ability to generate **UML diagrams** for visualizing the program structure.

## Project Structure:
- **Aircraft.java** — base class for all aircraft types.
- **CargoPlane.java** — class for cargo planes.
- **PassengerPlane.java** — class for passenger planes.
- **Helicopter.java** — class for helicopters.
- **ControlTower.java** — class for the airport control tower.
- **TowerMediator.java** — interface for the mediator through which aircraft interact.
- **Simulator.java** — the main class that runs the airport simulation.

## UML Diagram
The project includes a **UML diagram** that visualizes the main classes and their interactions. The diagram was generated using **PlantUML** and provides a clear overview of the program's architecture.

### UML Diagram Structure:

- **ControlTower** — the class responsible for managing all aircraft. It registers aircraft and manages their requests for landing and takeoff.
- **Aircraft** — the abstract base class for all types of aircraft. It has methods for sending and receiving messages from the tower.
- **PassengerPlane**, **CargoPlane**, **Helicopter** — concrete implementations of the **Aircraft** class, each with its own specific way of handling requests.
- **TowerMediator** — an interface through which interactions occur between objects, acting as a mediator.

The diagram helps to visualize the relationships between these classes and their roles in the airport simulation. Using the **Mediator** pattern centralizes control and avoids complex interdependencies between objects.

