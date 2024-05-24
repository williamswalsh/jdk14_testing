package ie.williamswalsh;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoidTypeTest {

    @Test
    void givenCalculator_whenGettingVoidMethodsByReflection_thenOnlyClearAndPrint() {
        Method[] calculatorMethods = Calculator.class.getDeclaredMethods();
        List<Method> calculatorVoidMethods = Arrays.stream(calculatorMethods)
                .filter(method -> method.getReturnType().equals(Void.TYPE))
                .toList();

        assertEquals("clear", calculatorVoidMethods.get(0).getName());
        assertEquals("print", calculatorVoidMethods.get(1).getName());
    }
}
