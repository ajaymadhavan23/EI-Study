# Vehicle Booking App (Using Factory Pattern)

----

## Overview :

* This project demonstrates the **Factory Design Pattern** using a **Vehicle Booking App**.

* A user can book different types of vehicles like Car, Bike, or Auto without worrying about how the objects are created.

* The Factory Pattern `TransportFactory` handles the object creation and provides the right type of Transport object based on user input.

* This makes the system flexible and easy to extend for adding new types of transport in the future.

---

## Features :

* Centralized object creation through `TransportFactory`.

* Encapsulates the logic for creating transport objects.

* Easy to add new types of transport without changing existing code.

* User only selects the vehicle type (Car/Bike/Auto), the Factory does the rest.

* Added an extra feature called Fair calculating by simply just multiply Fair/km.

---

## Implementation :

* Defined a common interface `Transport` with a method `ride()`

* Created concrete classes like `Car`,`Bike`,and`Auto` that implement `Transport`.

* Implemented a factory class `TransportFactory` which returns the appropriate Transport object based on the user’s choice.

* The main program interacts only with the factory and doesn’t directly instantiate objects.

* This ensures that object creation logic is hidden and centralized in one place.

---

## Example Flow :

* User opens the app and selects a vehicle type (Car/Bike/Auto).

* TransportFactory checks the input and creates the corresponding Transport object.

* The app calls the ride() method on the created object.

* **Output**: "Car Booked, Distance: 10 km, Fair: 200" / "Bike Booked, Distance: 10 km, Fair: 100" / "Car Booked, Distance: 10 km, Fair: 150".

---

## Output

Welcome to vehicle Booking App.

Choose your ride (Car / Bike / Auto) : Car

Enter distance in km: 10

Car Booked, Distance: 10 km, Fair: 200
