/*
LSP Violation Example
Step 1: Parent Class
class Bird {

    public void fly() {
        System.out.println("Flying...");
    }
}

Bird class implicitly tells that all Birds can fly,
but in reality, not all Birds can fly.

Step 2: Child Class
class Penguin extends Bird {

    @Override
    public void fly() {
        throw new UnsupportedOperationException(
            "Penguins cannot fly"
        );
    }
}

Step 3: Client Code
public class Main {

    public static void makeBirdFly(Bird bird) {
        bird.fly();
    }

    public static void main(String[] args) {

        Bird sparrow = new Bird();
        Bird penguin = new Penguin();

        makeBirdFly(sparrow);

        makeBirdFly(penguin);
    }
}

Output
Flying...
Exception in thread "main"
java.lang.UnsupportedOperationException:
Penguins cannot fly


Why LSP is violated?
Because Penguin cannot safely replace Bird in the makeBirdFly function.

Function:

makeBirdFly(Bird bird)

It expects Penguin can fly
But when we pass Penguin object to it, it throws an exception.

Bird penguin = new Penguin();

crush the program.
That means, Penguin cannot safely replace Bird.
LSP Violation
*/

// LSP Solution
// Step 1: Parent Class
class Bird {
    // common properties and methods for all birds
}

// FlyingBird
class Flyingbird extends Bird {

    public void fly() {
        System.out.println("Flying...");
    }
}

// Sparrow
class Sparrow extends Flyingbird {
    // Sparrow can fly, so it inherits fly() method
}

// Penguin
class Penguin extends Bird {
    // Penguin cannot fly, so it does not have fly() method
}

// client code
public class LSP {

    public static void makeBirdFly(Flyingbird bird) {
        bird.fly();
    }

    public static void main(String[] args) {

        Flyingbird sparrow = new Sparrow();

        makeBirdFly(sparrow);

        Penguin penguin = new Penguin();

        System.out.println("Penguin cannot fly");
    }
}
