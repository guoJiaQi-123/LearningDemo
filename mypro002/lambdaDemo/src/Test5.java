import java.awt.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/*
class ConsumerImpl implements Consumer{
    @Override
    public void accept(Object o) {
        System.out.println(o);
    }
}
*/

public class Test5 {
    public static void main(String[] args) {
//        Consumer consumer =System.out::println;
//        ConsumerImpl consumer =new ConsumerImpl();
        List<String> list =new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        list.forEach(System.out::println);
    }
}
