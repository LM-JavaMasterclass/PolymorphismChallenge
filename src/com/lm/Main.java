package com.lm;

// Created by Laura Macia: April 2018
// Udemy Complete Java Masterclass with Tim Buchalka
// Answer to Challenge: Polymorphism

// Create a base class called Car
// It should have a few fields that would be appropriate for a generice car calss.
// engine, cylinders, wheels, etc.
// Constructor should initialize cylinders (number of) and name, and set wheels to 4
// and engine to true. Cylinders and names would be passed parameters.
//
// Create appropriate getters
//
// Create some methods like startEngine, accelerate, and brake
//
// show a message for each in the base class
// Now create 3 sub classes for your favorite vehicles.
// Override the appropriate methods to demonstrate polymorphism in use.
// put all classes in the one java file (this one).

class Car {
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    private boolean engineCurrentlyOn;
    private int currentSpeed;


    public Car(String name, int cylinders) {
        this.name = name;
        this.cylinders = cylinders;
        this.engine = true;
        this.wheels = 4;
        this.engineCurrentlyOn = false;
        this.currentSpeed = 0;
    }

    public void startEngine(){
        this.engineCurrentlyOn = true;
        System.out.println("Base: Engine is on");
    }

    public void stop () {
        this.currentSpeed = 0;
        System.out.println("Base: Car stopped. Speed now 0");
    }

    public int accelerate (int addSpeed) {
        if (addSpeed>=0) {
            this.currentSpeed += addSpeed;
            System.out.println("Base: car accelerated, now at " + this.currentSpeed);
            return this.currentSpeed;

        } else{
            return -1;
        }
    }

    public int brake (int reduceSpeed) {
        if (reduceSpeed>=0){
            if (this.currentSpeed-reduceSpeed>=0){
                this.currentSpeed -= reduceSpeed;
            } else{
                this.stop();
            }
            System.out.println("Base: car braked, now at " + this.currentSpeed);

            return this.currentSpeed;
        } else {
            return -1;
        }
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
}

class HondaFit extends Car {
    public HondaFit() {
        super("Honda Fit", 4);
    }

    public void stop () {
        this.setCurrentSpeed(0);
        System.out.println("Honda Fit has stopped. Speed now 0");
    }
}

class KiaSedona extends Car {
    public KiaSedona() {
        super("Kia Sedona", 4);
    }

    public void stop () {
        this.setCurrentSpeed(0);
        System.out.println("Kia Sedona has stopped. Speed now 0");
    }
}

class Unknown extends Car {
    public Unknown() {
        super("Unknown", -1);
    }


}

public class Main {

    public static void main(String[] args) {

        Car randomCar = randomCar();

        randomCar.accelerate(50);
        randomCar.stop();


    }

    public static Car randomCar() {
        int randomNumber = (int) (Math.random() * 3) + 1;
        switch (randomNumber) {
            case 1:
                return new HondaFit();
            case 2:
                return new KiaSedona();
            case 3:
                return new Unknown();
        }

        return null;
    }
}
