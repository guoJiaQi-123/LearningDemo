import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class PredicateImpl implements Predicate{
    @Override
    public boolean test(Object o) {
        return "b".equals(o);
    }
}

public class Test6 {
    public static void main(String[] args) {
        Predicate predicate =a->a.equals("b");
        List<String> list =new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        //Predicate predicate =new PredicateImpl();
        list.removeIf(predicate);
        list.removeIf(ele->ele.equals("b"));
        list.forEach(System.out::println);
    }
}
