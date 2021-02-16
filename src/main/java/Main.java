import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    private static final MathOperations PLUS = MathOperations.PLUS;
    private static final MathOperations MINUS = MathOperations.MINUS;
    private static final MathOperations MULTIPLY = MathOperations.MULTIPLY;
    private static final MathOperations DIVIDE = MathOperations.DIVIDE;

    public static void task1() {
        Stream.of(1, 2, 3, 4, 5).filter(integer -> integer % 2 == 0)
                .map(integer -> integer * integer)
                .forEach(System.out::println);
    }

    public static void task2() {
        List<String> list1 = new ArrayList<>();
        list1.add("Один");
        list1.add("два");
        list1.add("тРи");
        list1.add("Четыре");
        list1.add("пять");
        List<String> list2 = new ArrayList<>();
        list2.add("один");
        list2.add("Два");
        list2.add("ТРи");
        list2.add("чЕтыре");
        list2.add("Пять");
        List<String> list3 = new ArrayList<>();
        list3.add("один");
        list3.add("Два");
        list3.add("тРи");
        list3.add("чЕтыре");
        list3.add("Пять");
        Predicate<List<String>> predicate = predicateList -> predicateList.stream()
                .filter(string -> Character.isUpperCase(string.charAt(0))).count() > 2;
        Stream.of(list1, list2, list3).filter(predicate).forEach(System.out::println);
    }

    public static void task3() {
        Map<MathOperations, BiFunction<Number, Number, Double>> map = new HashMap<>();
        BiFunction<Number, Number, Double> plus = (a, b) -> a.doubleValue() + b.doubleValue();
        BiFunction<Number, Number, Double> minus = (a, b) -> a.doubleValue() - b.doubleValue();
        BiFunction<Number, Number, Double> multiply = (a, b) -> a.doubleValue() * b.doubleValue();
        BiFunction<Number, Number, Double> divide = (a, b) -> a.doubleValue() / b.doubleValue();


        map.put(MathOperations.PLUS, plus);
        map.put(MathOperations.MINUS, minus);
        map.put(MathOperations.MULTIPLY, multiply);
        map.put(MathOperations.DIVIDE, divide);


        System.out.println(map.get(PLUS).apply(7, 5));
        System.out.println(map.get(MINUS).apply(7, 5));
        System.out.println(map.get(MULTIPLY).apply(7, 5));
        System.out.println(map.get(DIVIDE).apply(7, 5));
    }

    public static void task4() {
        TriFunction<Integer, Integer, Integer, Integer> function = (a, b, c) -> a + b * c;
        System.out.println(function.apply(2, 2, 2));
    }


    public static void main(String[] args) {

        task1();
        task2();
        task3();
        task4();

    }


}
