# Stock Price Alerts (Observer Pattern)


I have created a simple Stock Prise Alert System, we create Subject classes like (Stocks of Apple, Tesla...etc.) and multiple Observers like (Messenger, Email). 
We then subscribe the Observers to get notify everytime there is a update in stocks that we subscribed.

## Overview :

* This project demonstrates the **Observer Design Pattern** using a **Stock Price Alert system**.

* A stock (like Apple, Tesla, etc.) acts as the `Subject`, and various displays (Messenger, Mail...etc.) act as `Observers`.

* Whenever the stock price changes, all subscribed observers get notified automatically.

---

## Features :

* Add(Subscribe) and remove(Unsubscribe) observers dynamically.

* Notify all **subscribed** observers instantly when stock price updates.

* Clean decoupling → Stock doesn’t need to know the internal logic of observers.

* Simulates real-world price alert systems like stock trading apps.

---

## Implementation :

* `Observer` (Interface): Declares the update method for receiving stock updates.

* `Subject` (Interface): Declares methods for registerObserver, removeObserver, and notifyObservers.

* `Stock` (Concrete Subject):

  * Maintains a `list` of observers.

  * Updates stock price and notifies all observers.

* `StockDisplay` (Concrete Observer):

  * Implements update method.

  * Displays stock changes on Messenger/Emai App.

* `Main Class:`

  * Creates stock objects and observers.

  * Subscribe/unsubscribe observers and triggers price updates.

---

# Sample Flow / Output

Subscribed Messenger

Subscribed Email

Price set to: 70.0

Notification:  received update: Apple is now: 70.0

Email:  received update: Apple is now: 70.0

Unsubscribed Messenger

Price set to: 80.0

Email:  received update: Apple is now: 80.0