import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*
        Создайте массив объектов типа Сотрудник (с полями Имя, Возраст, Зарплата)
        и вычислите среднюю зарплату сотрудника;
         */
        Employee[] employees = { new Employee("A", 17, 10000),
                new Employee("B", 27, 15000), new Employee("C", 20, 8000),
                new Employee("D", 25, 12000) };

        OptionalDouble averageSalaryOpt = Arrays.stream(employees)
                .mapToDouble(employee -> employee.getSalary()).average();

        System.out.println(averageSalaryOpt.getAsDouble());
        Arrays.stream(employees).sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(2).
                forEach(employee -> System.out.println(employee.getName()));

        System.out.println();
        Arrays.stream(employees).sorted(Comparator.comparing(s -> s.getAge()))
                .skip(employees.length - 2).
                forEach(employee -> System.out.println(employee.getName()));

        //FORMATTED LINE:
        System.out.println();
        System.out.println(Arrays.stream(employees).sorted(Comparator.comparing(s -> s.getAge()))
                .skip(employees.length - 2)
                .map(s -> s.getName())
                .collect(Collectors.joining(", ", employees.length - 2
                        + " самых старших сотрудников зовут: ", ".")));

        //        Optional <Double> salary = employeeStream.map(
        //                (a, b) -> {
        //            double sum = a.getSalary() + b.getSalary();
        //                    return sum;
        //                })

        String[] words1 = { "dog", "cat", "parrot", "IPSUM", "cat", "dog" };
        String nn = "S";
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        String mostFreqWord = Arrays.stream(words1).collect(Collectors
                .groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue)).get().getKey();

        System.out.println(mostFreqWord);

        //        Stream.of(1, 3, 4, 3, 4, 3, 2, 3, 3, 3, 3, 3)
        //                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        //                .entrySet()
        //                .stream()
        //                .max(Comparator.comparing(Map.Entry::getValue))
        //                .ifPresent(System.out::println);

        List<String> names = new ArrayList<>(Arrays.asList("liza", "anna",
                "sonya", "jack", "john", "daffny"));

        List<String> namesModified =
                names.stream()
                        .map(name ->
                                name.substring(0,1)
                                        .toUpperCase()
                                        + name.substring(1))
                        .sorted(String::compareTo).collect(Collectors.toList());

        System.out.println(namesModified);
        names.stream().map(name -> name.substring(0,1).toUpperCase()
                + name.substring(1)).sorted(String::compareTo).forEach(System.out::println);

    }
}
