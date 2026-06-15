/*
DIP Violation Example
Step 1: Low-Level Module
class PetrolEngine {

    void start() {
        System.out.println(
            "Petrol Engine Started"
        );
    }
}

PetrolEngine >>>> low-level module. Because it is implementation detail.

Step 2: High-Level Module
class Car {

    private PetrolEngine engine =
            new PetrolEngine();

    void startCar() {
        engine.start();
    }
}

Car >>>> high-level module. This is business logic.

Step 3: Client Code
public class Main {

    public static void main(String[] args) {

        Car car = new Car();

        car.startCar();
    }
}

Output: Petrol Engine Started

Why Is This DIP Violation?

Dependency diagram:

Car >>>> PetrolEngine

The problem is Car depends on Petrol engine directly.

Now we wanna add ElectricEngine....

class ElectricEngine {

    void start() {
        System.out.println(
            "Electric Engine Started"
        );
    }
}

Here we need to modify Car class

private ElectricEngine engine = new ElectricEngine();

When new engine comes we need to modify it, which is DIP Violation.

*/

// DIP solution
// Step 1: Define Abstraction
interface Engine {
    void start();
}

// Petrol Engine
class PetrolEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Petrol Engine Started");
    }
}

// Electric Engine
class ElectricEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Electric Engine Started");
    }
}

// Step 2: High-Level Module
class Car {

    private Engine engine; // Dependency on abstraction

    // Constructor Injection
    public Car(Engine engine) {
        this.engine = engine;
    }

    void startCar() {
        engine.start();
    }
}

// Step 3: Client Code
public class DIP {

    public static void main(String[] args) {

        Engine petrolEngine = new PetrolEngine();
        Car petrolCar = new Car(petrolEngine);
        petrolCar.startCar();

        Engine electricEngine = new ElectricEngine();
        Car electricCar = new Car(electricEngine);
        electricCar.startCar();
    }
}
