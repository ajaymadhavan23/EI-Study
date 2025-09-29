# Satellite Control System

## Overview
This project is a **Satellite Control System** that allows users to create, manage, and operate satellites. The system provides comprehensive control over satellite operations including rotation, data collection, camera operations, and thermal sensor monitoring. The application uses several design patterns, including Command, Builder, Observer, Decorator, and Adapter patterns, to ensure a scalable and maintainable architecture.

## Design Patterns

### Command Pattern
The Command pattern encapsulates all the information needed to perform satellite operations. This pattern enables flexible operation execution and easy addition of new commands.

**Available Commands:**
- [`SatelliteRotate`](src/main/commands/SatelliteRotate.java): Rotates the satellite to a specified direction.
- [`SolarPanelManager`](src/main/commands/SolarPanelManager.java): Activates or deactivates solar panels.
- [`CameraOperation`](src/main/commands/CameraOperation.java): Turns the satellite camera on or off.
- [`DataCollector`](src/main/commands/DataCollector.java): Collects data from the satellite.
- [`CameraCapture`](src/main/commands/CameraCapture.java): Captures images in the current satellite orientation.
- [`ThermalSensorAdapter`](src/main/commands/ThermalSensorAdapter.java): Reads thermal sensor data (Simulation using Random Values).
- [`CreateSatellite`](src/main/commands/CreateSatellite.java): Creates a custom satellite based on the user given inputs.
- [`DefaultSatellite`](src/main/commands/DefaultSatellite.java): Creates a default satellite configuration, two options available (1.With Camera / 2. Without Camera).
- [`GetState`](src/main/commands/GetState.java): Retrieves the current state of a given(user input) satellite.
- [`GetList`](src/main/commands/GetList.java): Lists all available satellites.

### Builder Pattern
The Builder pattern is used to construct satellite objects with various configurations. This pattern provides a flexible way to create satellites with different features.

**Builder Class:**
- [`Builder`](src/main/builder/Builder.java): Constructs satellites with customizable properties (name, orientation, solar panels, data collection, camera).
- We can either add camera or not while creating the Satellite using `CreateSatellite`

### Observer Pattern
The Observer pattern is implemented to notify the dashboard whenever satellite states change. This ensures real-time updates of the satellite monitoring interface.

**Components:**
- [`SatelliteManager`](src/main/core/SatelliteManager.java): Acts as the Subject, managing observers and notifying them of changes.
- [`Dashboard`](src/main/core/Dashboard.java): Observes satellite changes and updates the display table automatically.

### Decorator Pattern
The Decorator pattern is used to dynamically add features (camera and thermal sensors) to existing satellites without modifying their structure.

**Decorators:**
- [`AddCameraDecorator`](src/main/decorator/AddCameraDecorator.java): Adds camera functionality to a satellite after creating object.
- [`AddSensorDecorator`](src/main/decorator/AddSensorDecorator.java): Adds thermal sensor capability to a satellite after creating object.

### Adapter Pattern
The Adapter pattern bridges the gap between the satellite system and external sensor interfaces.

**Adapter:**
- [`ThermalSensorAdapter`](src/main/commands/ThermalSensorAdapter.java): Adapts the thermal sensor interface to work with the satellite command system.
- It acts like a command to `SatelliteCommand` interface but inside it have methods from the `ThermalSensor`, which is not a child for the `SatelliteCommand` Interface

### Factory Pattern
The Factory pattern creates command objects based on string identifiers, centralizing command instantiation logic.

**Factory:**
- [`SatelliteCommandFactory`](src/main/factories/SatelliteCommandFactory.java): Creates appropriate command objects based on operation type.
- It simply returns the Object for the needed Commands based on the user input.

## Features

### Satellite Creation
Users can create satellites in two ways:
1. **Default Satellite**: Quick setup with predefined configurations (with or without camera).
2. **Custom Satellite**: Full customization of satellite parameters including name, orientation, and features.

### Satellite Operations
- **Rotation**: Orient the satellite in any direction (N, S, E, W, NE, NW, SE, SW).
- **Solar Panel Management**: Activate or deactivate solar panels for power management.
- **Camera Control**: Turn cameras on/off and capture images.
- **Data Collection**: Collect data when solar panels are active.
- **Thermal Monitoring**: Read temperature data from thermal sensors.

### Real-time Dashboard
The dashboard provides a live view of all satellites with the following information:
- Satellite ID and Name
- Solar panel status (Active/Off)
- Data collected
- Camera status (On/Off/Nil)
- Current orientation
- Thermal sensor readings

### Automated Updates
The system automatically updates the dashboard whenever any satellite state changes, ensuring users always have current information.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Java IDE (IntelliJ IDEA, Eclipse, or similar)

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/ajaymadhavan23/EI-Study
   ```

2. Navigate to the project directory:
   ```bash
   cd SatelliteApp
   ```

3. Compile the Java files:
   ```bash
   javac -d bin src/main/**/*.java
   ```

### Running the Application
To start the application, run:
```bash
java -cp bin main.app.SatelliteApp
```

## Usage Guide

### Main Menu
Upon starting the application, you'll see:
```
--- SATELLITE CONTROL MENU ---
1. Satellite Operations
2. Satellite Management
3. Exit
```

### Satellite Operations
Access various operational commands for existing satellites:

1. **Rotate**: Change satellite orientation
    - Input: Direction (N, S, E, W, NE, NW, SE, SW)
    - Example: `N` for North

2. **Solar**: Manage solar panels
    - Input: `activate` or `deactivate`

3. **Camera**: Control camera
    - Input: `on` or `off`

4. **Collect Data**: Gather data
    - Input: Amount of data (integer)
    - Note: Requires active solar panels

5. **Capture Image**: Take photos
    - Captures image in current orientation
    - Requires camera to be on

6. **Thermal Sensor**: Read temperature
    - Displays current thermal reading in °C

### Satellite Management

1. **Create Satellite**
    - **Default Satellite**: Choose with or without camera
        - Input: Name and camera choice (1 for with camera, 2 without)
    - **Custom Satellite**: Full configuration control
        - Input: Name, orientation, solar status, initial data, camera preference

2. **Get List of Satellites**
    - Displays all created satellites

3. **Get Satellite State**
    - Shows detailed information about a specific satellite
    - Input: Satellite name

4. **Add Camera**
    - Adds camera to an existing satellite
    - Input: Satellite name

5. **Add Thermal Sensor**
    - Adds thermal sensor to an existing satellite
    - Input: Satellite name

## Input Examples

### Creating a Default Satellite
```
Enter choice: 2
Choose management action: 1
Enter your choice: 1
Enter name for Default Satellite: Explorer1
Choose type:
1. With Camera
2. Without Camera
Enter choice: 1
```

### Rotating a Satellite
```
Enter choice: 1
Choose operation: 1
Enter satellite name: Explorer1
Enter direction (N, S, E, W, NE, NW, SE, SW, etc.): NE
```

### Collecting Data
```
Enter choice: 1
Choose operation: 4
Enter satellite name: Explorer1
Enter amount of data to collect: 100
```

## Output Examples

### Dashboard Display
```
--- DASHBOARD ---
ID  Name       Solar      Data  Camera Orientation  Sensor    
1   Explorer1  Active     150   On     NE           45.23°C   
2   Voyager2   Off        0     Nil    N            Nil       
```

### Operation Success Messages
```
✓ Solar panels activated.
✓ Satellite rotated to: NE
✓ Now facing: North-East Horizon
✓ Camera is On
✓ Data collected: 100. Total: 250
✓ Capturing image towards North-East Horizon direction...
✓ Thermal Sensor Reading: 45.23 °C
```

## Error Handling

The application handles various error scenarios:

- **No Satellites Available**: Prompts user to create a satellite first.
- **Invalid Satellite Name**: Requests correct satellite name.
- **Invalid Direction Input**: Displays valid direction options.
- **Camera Not Found**: Indicates satellite doesn't have a camera.
- **Camera Already On/Off**: Prevents redundant operations.
- **Solar Panels Inactive**: Prevents data collection without power.
- **Invalid Menu Choice**: Guides user to valid options.
- **Invalid Data Input**: Requires integer values for data collection.
- **Duplicate Satellite Names**: Prevents naming conflicts.
- **Feature Already Exists**: Prevents adding duplicate cameras or sensors.

## Project Structure

```
SatelliteApp/
├── main/
│   ├── app/
│   │   └── SatelliteApp.java          # Main file 
│   ├── builder/
│   │   └── Builder.java                # Satellite builder
│   ├── commands/
│   │   ├── SatelliteCommand.java      # Command interface
│   │   ├── SatelliteRotate.java
│   │   ├── SolarPanelManager.java
│   │   ├── CameraOperation.java
│   │   ├── CameraCapture.java
│   │   ├── DataCollector.java
│   │   ├── CreateSatellite.java
│   │   ├── DefaultSatellite.java
│   │   ├── GetState.java
│   │   ├── GetList.java
│   │   └── ThermalSensorAdapter.java
│   ├── core/
│   │   ├── Satellite.java              # Satellite model
│   │   ├── SatelliteManager.java       # Manager (Subject)
│   │   ├── Dashboard.java              # Observer
│   │   ├── Direction.java              # Direction enum
│   │   ├── LoggerUtil.java             # Logging utility
│   │   ├── Observer.java               # Observer interface
│   │   ├── Subject.java                # Subject interface
│   │   └── SatelliteOperationException.java
│   ├── decorator/
│   │   ├── SatelliteDecorator.java     # Base decorator
│   │   ├── AddCameraDecorator.java
│   │   └── AddSensorDecorator.java
│   ├── factories/
│   │   └── SatelliteCommandFactory.java # Command factory
│   └── sensors/
│       └── ThermalSensor.java          # Sensor implementation
```

## Direction System

The satellite uses an 8-directional system with meaningful facing descriptions:

| Direction | Facing Description      |
|-----------|------------------------|
| N         | North Star             |
| S         | South Pole             |
| E         | Sunrise                |
| W         | Sunset                 |
| NE        | North-East Horizon     |
| NW        | North-East Horizon     |
| SE        | South-West Horizon     |
| SW        | South-West Horizon     |

- We have given the direction in the enum file for future scaling 

## Edge Cases

- **Concurrent Operations**: The system handles sequential operations smoothly.
- **State Validation**: Operations check prerequisites (e.g., solar panels for data collection).
- **Duplicate Prevention**: System prevents duplicate satellite names and redundant feature additions.
- **Null Safety**: Proper handling of optional features (camera, sensors).
- **Input Validation**: Comprehensive validation of user inputs with helpful error messages.

## Logging

The application uses Java's built-in logging framework with three levels:
- **INFO**: General information and guidance messages
- **WARNING**: Warning messages for user attention
- **SEVERE**: Error messages for operation failures

## Future Enhancements

Potential improvements for the system:
- Persistence layer for saving satellite configurations
- Multi-satellite command execution
- Scheduled operations and automation
- Communication protocols between satellites
- Advanced sensor types (GPS, radiation, etc.)
- Collision detection and avoidance
- Mission planning and execution tracking

## Conclusion

This Satellite Control System demonstrates the implementation of multiple design patterns in Java to create a flexible, maintainable, and extensible satellite management application. The system provides comprehensive control over satellite operations with real-time monitoring through an observer-based dashboard. The modular architecture allows easy addition of new features and commands while maintaining clean separation of concerns.