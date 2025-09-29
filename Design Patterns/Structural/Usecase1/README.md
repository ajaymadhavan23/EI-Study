# Remote Control System (Bridge Pattern)


## Overview :

* This project demonstrates the **Bridge Design Pattern** using a **Remote Control System**.

* The pattern separates the abstraction (`Remote`) from the implementation (`Device`).

* This allows new devices (TV, Radio, etc.) and new remotes (BasicRemote, AdvancedRemote) to be added independently, without modifying existing code.

---

## Features :

* Control different devices (TV, Radio, etc.) with the same `Remote` interface.

* Avoids class explosion (no need for RemoteForTV, RemoteForRadio, etc.).

* Easily extendable for adding new devices or new remote types.

* Demonstrates clean separation of abstraction and implementation.

---

## Implementation :

* `Device` → **Interface** for all devices (powerOn(), powerOff(), setVolume()) these are the methods common to them.

* `TV` / `Radio` → Concrete implementations of Device.

* `Remote` → **Abstract** class that holds a reference to a Device.

* `BasicRemote` → Provides basic functionality (toggle power, set volume).

* `AdvancedRemote` → Extends Remote with extra features (mute).

* `Main` → Demonstrates different remotes controlling different devices.

---

## Example Flow :

A BasicRemote controls a TV → toggle power, adjust volume.

An AdvancedRemote controls a Radio → toggle power, adjust volume, mute option.

Both remotes can be swapped with any device without changing existing logic.