import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class ComparatorImpl implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}


public class Test7 {

    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("c");
        list.add("b");
        list.add("d");
        list.add("a");

//        ComparatorImpl comparator =new ComparatorImpl();
//        list.sort(comparator);


        list.sort((s1,s2)->s1.compareTo(s2));

        list.forEach(System.out::println);

    }
}
