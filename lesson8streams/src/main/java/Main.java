import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*
        Создайте массив объектов типа Сотрудник (с полями Имя, Возраст, Зарплата)
        и вычислите среднюю зарплату сотрудника;
         */
        Employee[] employees = { new Employee("A", 20, 10000),
                new Employee("B", 27, 15000), new Employee("C", 17, 8000) };

/*        Stream<Employee> employeeStream = Arrays.stream(employees);

        Optional <Double> salary = employeeStream.map(
                (a, b) -> {
            double sum = a.getSalary() + b.getSalary();
                    return sum;
                })*/

        String[] words1 = { "dog", "cat", "parrot", "IPSUM", "cat", "dog" };

        Map <String, Integer> map = new HashMap<>();
        int count = 0;
//        String mostFreqWord =
//                Arrays.stream(words1).collect(Function.identity(),
//                        Collectors.counting()).entrySet();

    }
}
