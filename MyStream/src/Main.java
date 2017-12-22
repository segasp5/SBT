import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 08.12.2017.
 */
public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Alex", 20);
        Person p2 = new Person("Bob", 35);
        Person p3 = new Person("Alice", 15);
        Person p4 = new Person("Max", 32);
        Person p5 = new Person("Kimberly", 50);

        List<Person> people = new ArrayList<>();

        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);

        Map m1 = Streams.of(people)
                .toMap(p -> p.getName(), p -> p.getAge());

        System.out.println(m1);
        System.out.println();
        System.out.println("filter: age > 30");

        Map m2 = Streams.of(people)
                .filter(p -> p.getAge() > 30)
                .toMap(p30 -> p30.getName(), p30 -> p30.getAge());

        System.out.println(m2);
        System.out.println();

        System.out.println("increase all ages by 100");

        Map m3 = Streams.of(people)
                .transform(p -> new Person(p.getName(), p.getAge() + 100))
                .toMap(p -> p.getName(), p -> p.getAge());
        System.out.println(m3);
    }
}
