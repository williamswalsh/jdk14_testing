package ie.williamswalsh;

import org.junit.jupiter.api.Test;

public class InstanceOfPatternMatchingTest {

    @Test
    void instanceOfOldPatternTest() {
        Object obj = returnObject();

        if (obj instanceof Car) {
            Car car = (Car) obj;
            System.out.println("Number of car doors: " + car.doors());
        }
    }

    @Test
    void instanceOfNewPatternTest() {
        Object obj = returnObject();

        if (obj instanceof Car car) {
            System.out.println("Number of car doors: " + car.doors());
        }
    }

    Object returnObject() {
        return new Car(2);
    }
}

record Car(int doors) {}
