package ie.williamswalsh;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwitchAndYieldTest {

    @Test
    public void myTest() {
        System.out.println("hi");
    }


    @Test
    void newSwitchExpressionsTest() {

        String day = "K";

        String result = switch (day) {
            case "M", "W", "F" -> "MWF";
            case "T", "TH", "S" -> "TTS";
            default -> {
                if(day.isEmpty())
                    yield "Please insert a valid day.";
                else
                    yield "Looks like a Sunday.";
            }

        };
        System.out.println(result);
    }

    @Test
    void newSwitchAndYieldExpression() {
        String greeting = "hii";

        int value = switch (greeting) {
            case "hi" -> {
                System.out.println("I am not just yielding!");
                yield 1;
            }
            case "hello" -> {
                System.out.println("Me too.");
                yield 2;
            }
            default -> {
                System.out.println("OK");
                yield -1;
            }
        };
        System.out.println(value);
    }

    @Test
    void myNewReturningSwitch() {
        String dayKey = "We";
        String day = switch (dayKey) {
            case "Mo" -> "Monday";
            case "Tu" -> "Tuesday";
            case "We" -> "Wednesday";
            case "Th" -> "Thursday";
            case "Fr" -> "Friday";
            case "Sa" -> "Saturday";
            case "Su" -> "Sunday";
            default -> "UNKNOWN";
        };

        assertEquals("Wednesday", day);
    }

    @Test
    void myNewReturningSwitchWithYield() {
        String dayKey = "Mo";
        String day = switch (dayKey) {
            case "Mo" -> {
                System.out.println("Dummy operation to have another statement in lambda expression");
                yield "Monday";
            }
            case "Tu" -> "Tuesday";
            case "We" -> "Wednesday";
            case "Th" -> "Thursday";
            case "Fr" -> "Friday";
            case "Sa" -> "Saturday";
            case "Su" -> "Sunday";
            default -> "UNKNOWN";
        };

        assertEquals("Monday", day);
    }

    @Test
    void yieldWithoutYieldTarget() {
//        yield 7;  // Compilation error - java: yield outside of switch expression
    }
}
