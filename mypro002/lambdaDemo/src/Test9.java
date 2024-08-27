import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test9 {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("d");
        list.add("c");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("---------------");
        list.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        System.out.println("---------------");
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);


    }
}
