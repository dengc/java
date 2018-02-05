# Java

@(IT Studies)


- Pass by value
- final - cannot be changed
- overloading: multiple methods of same name, but different parameters
- overriding: 子method 不同于 父method

## 4 Fundamental
-------------------------------------
### Inheritance
- one class based on another
```java
public class Car extends Vehicle
super(owner, speed);
```
### Polymorphism
- single object -> multiple forms
```java
Vehicle car = new Car("Bob");
Vehicle bike = new Bike("Bob");
---
private static void testV(Vehicle v)
```
### Abstraction
- provide generalization
> Interface
### Encapsulation
- hide implementation details
> Getters & Setters

## ArrayList
-------------------------------------
```java
ArrayList<Integer> list = new ArrayList<>();
list.add(11) -- O(1);
list.remove(3) -- O(n);
list.get(2);
list.size();
```