/*
Let's take an Interface:

interface Worker {
    void work();
    void eat();
    void sleep();
}

Human & Robot both are Worker।
>>>>Human
class HumanWorker implements Worker {

    public void work() {
        System.out.println("Working");
    }

    public void eat() {
        System.out.println("Eating");
    }

    public void sleep() {
        System.out.println("Sleeping");
    }
}
>>>>Robot
class RobotWorker implements Worker {

    public void work() {
        System.out.println("Working");
    }

    public void eat() {
        // Nothing
    }

    public void sleep() {
        // Nothing
    }
}

Problem
Robot:

Can Work?   YES
Can Eat?    NO
Can Sleep?  NO

But robot has to implement
eat()
sleep()

No matter what, it has to implement those methods,
even if it does nothing.
This ISP Violation।
*/

/*
ISP solution:
break down large interface into smaller ones.
*/

// Worker interface
interface Workable {
    void work();
}

// Eatable interface
interface Eatable {
    void eat();
}

// Sleep interface
interface Sleep {
    void sleep();
}

// Human
class HumanWorker
        implements Workable,
        Eatable,
        Sleep {

    public void work() {
        System.out.println("HumanWorking");
    }

    public void eat() {
        System.out.println("HumanEating");
    }

    public void sleep() {
        System.out.println("Human Sleeping");
    }
}

// Robot
class RobotWorker
        implements Workable {

    public void work() {
        System.out.println("Robot Working");
    }
}

// main class
public class ISP {
    public static void main(String[] args) {

        HumanWorker human = new HumanWorker();
        RobotWorker robot = new RobotWorker();

        human.work();
        human.eat();
        human.sleep();
        robot.work();
    }
}
