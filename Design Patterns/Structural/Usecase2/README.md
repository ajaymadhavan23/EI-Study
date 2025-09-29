# Coffee Shop Customizer (Decorator Pattern)

"I have made a **Simple Coffee Customizer system**, where we have base Coffees under the Coffee Interface, and have Decorators like (Sugar, Chocolate, etc.) under Decorator class, so now user can easily add any add-on's after creating a simpleCoffee"

---

## Overview :

* This project demonstrates the **Decorator Design Pattern** using a **Coffee Shop Customizer**.

* Base coffee(`SimpleCoffee`) can be dynamically decorated with additional features like `Milk`, `Sugar`, `Chocolate`, etc.

* The pattern allows adding new behavior (add-ons) without modifying the base class.

* Flexible and extendable: new add-ons can be added easily as decorators, without creating a huge combination classes.

---

## Features :

* Base coffee can be enhanced with multiple add-ons.

* Add-ons are implemented as decorators which wrap the base coffee.

* Cost and description are dynamically calculated as add-ons are applied.

* Promotes modularity and avoids creating a huge class for every combination.

---

## Implementation :

* `Coffee` → Interface for all coffee types (getDescription(), getCost()) these are methods available in it.

* `SimpleCoffee` → Concrete base coffee which implements `Coffee`.

* `CoffeeDecorator` → Abstract decorator class that wraps a Coffee object.

* Concrete Decorators → `Milk`, `Sugar`, `Chocolate`, etc.

* Main → Demonstrates chaining decorators to customize coffee dynamically.

---

## Example Flow :

Start with a SimpleCoffee.

Add Milk → description and cost updated.

Add Sugar → chained decorator wraps previous coffee.

Add Chocolate → final deluxe coffee with total description and cost.

---

## Sample Output :

Coffee: Simple Coffee, Cost: 10


Coffee: Simple Coffee with sugar, Cost: 15


Coffee: Simple Coffee with chocolate, Cost: 20