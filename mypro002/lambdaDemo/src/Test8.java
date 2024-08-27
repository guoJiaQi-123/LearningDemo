import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test8 {
    public static void main(String[] args) {

        /**
         * 1.创建Stream流对象
         * 2.操作Stream流对象
         * 3.结束Stream流对象
         */
        List<String> list =new ArrayList<>();
        list.add("oldLu");
        list.add("oldLin");
        list.add("Kevin");
        list.add("Peter");

        List<String> newList = list.stream().filter(ele -> ele.startsWith("o")).
                filter(ele -> ele.endsWith("n")).collect(Collectors.toList());
        newList.forEach(System.out::println);
//        list.stream().filter(ele->ele.startsWith("o")).filter(ele->ele.endsWith("n"))
//                .collect(Collectors.toList()).forEach(System.out::println);

        Predicate<String> predicate1=ele->ele.startsWith("o");
        Predicate<String> predicate2=ele->ele.endsWith("n");
        list.stream().filter(predicate1.or(predicate2)).collect(Collectors.toList()).forEach(System.out::println);

        list.stream().limit(3).forEach(System.out::println);

    }
}
