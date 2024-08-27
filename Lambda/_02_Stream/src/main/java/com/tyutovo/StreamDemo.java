package com.tyutovo;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        List<Author> authors = getAuthors();
        //test01(authors);

        // 打印姓名长度大于1的所有作家的名字
        // test02(authors);


        // 打印所有作家的姓名，使用map中间操作进行转换
        // test03(authors);

        // 打印所有作家十年后的年龄
        // test04(authors);

        // 打印所有作家的姓名并且不能有重复
        // test05(authors);

        // 对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素。<使用空参sorted方法>
        // test06(authors);

        // 对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素。<使用带有函数式接口的sorted方法>
        // test07(authors);

        // 对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素,然后打印其中年龄最大的两个作家的姓名。
        // test08(authors);

        // 打印除了年龄最大的作家外的其他作家，要求不能有重复元素，并且按照年龄降序排序。
        // test09(authors);

        // 打印所有书籍的名字。要求对重复的元素进行去重。
        // test10(authors);

        // 打印现有书籍的所有分类。要求对分类进行去重。不能出现这种格式：哲学,爱情
        // test11(authors);

        // 打印这些作家的所出书籍的数目，注意删除重复元素。
        // test12(authors);

        // 分别获取这些作家的所出书籍的最高分和最低分并打印。
        // test13(authors);

        // 获取一个存放所有作者名字的List集合。
        // test14(authors);

        // 获取一个所有书名的Set集合。
        // test15(authors);

        // 获取一个Map集合，map的key为作者名，value为List<Book>
        // test16(authors);

        // 判断是否有年龄在29以上的作家
        // test17(authors);

        // 判断是否所有的作家都是成年人
        // test18(authors);

        // 判断作家是否都没有超过100岁的。
        // test19(authors);

        // 获取任意一个年龄大于18的作家，如果存在就输出他的名字
        // test20(authors);

        // 	获取一个年龄最小的作家，并输出他的姓名。
        // test21(authors);

        // 使用reduce求所有作者年龄的和
        // test22(authors);

        //	使用reduce求所有作者中年龄的最大值
        //  test23(authors);

        Optional<Author> optionalAuthor = getAuthorOptional();
//        optionalAuthor.ifPresent(author -> System.out.println(author.getName()));
//        Author author = optionalAuthor.get();
//        System.out.println(author.getName());
//
//        Author author = optionalAuthor.orElseGet(Author::new);
//        System.out.println(author.getName());
//
//        Author author = optionalAuthor.orElseThrow(() -> new RuntimeException("Optional对象为null"));
//        System.out.println(author.getName());
    }
//TODO 阿萨德阿萨德


    private static Optional<Author> getAuthorOptional() {
        Author author = new Author(1L, "guojiaqi", 20, "66666666", null);
        return Optional.ofNullable(null);
    }

    private static void test23(List<Author> authors) {
        Integer reduce = authors.stream()
                .map(Author::getAge)
                .reduce(-1, (result, element) -> Math.max(element, result));
        System.out.println(reduce);
    }

    private static void test22(List<Author> authors) {
        Integer sum = authors.stream()
                .map(Author::getAge)
                .distinct()
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    private static void test21(List<Author> authors) {
        Optional<Author> first = authors.stream()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .findFirst();
        first.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void test20(List<Author> authors) {
        Optional<Author> authorOptional = authors.stream()
                .filter(author -> author.getAge() > 18)
                .findAny();
        authorOptional.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void test19(List<Author> authors) {
        boolean flag = authors.stream()
                .noneMatch(author -> author.getAge() > 100);
        System.out.println(flag);
    }

    private static void test18(List<Author> authors) {
        boolean flag = authors.stream()
                .allMatch(author -> author.getAge() > 18);
        System.out.println(flag);
    }

    private static void test17(List<Author> authors) {
        boolean flag = authors.stream()
                .anyMatch(author -> author.getAge() > 29);
        System.out.println(flag);
    }

    private static void test16(List<Author> authors) {
        Map<String, List<Book>> map = authors.stream()
                .distinct()
                .collect(Collectors.toMap(Author::getName, Author::getBooks));
        System.out.println(map);
    }

    private static void test15(List<Author> authors) {
        Set<String> bookName = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getName)
                .distinct()
                .collect(Collectors.toSet());
        System.out.println(bookName);
    }

    private static void test14(List<Author> authors) {
        List<String> nameList = authors.stream()
                .map(Author::getName)
                .collect(Collectors.toList());
        System.out.println(nameList);
    }

    private static void test13(List<Author> authors) {
        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getScore)
                .max((score1, score2) -> score1 - score2);

        Optional<Integer> min = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .min((score1, score2) -> score1 - score2);

        System.out.println(max.get());
        System.out.println(min.get());
    }

    private static void test12(List<Author> authors) {
        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);
    }

    private static void test11(List<Author> authors) {
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(System.out::println);
    }

    private static void test10(List<Author> authors) {
        //获取流
        authors.stream()
                // 作者流转换为book流
                .flatMap(author -> author.getBooks().stream())
                //book流中获取book名称
                .map(Book::getName)
                //对重复的book名称进行去重
                .distinct()
                .forEach(System.out::println);
    }

    private static void test09(List<Author> authors) {
        authors.stream()
                .distinct()
                .sorted()
                .skip(1)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test08(List<Author> authors) {
        authors.stream()
                .distinct()
                .sorted()
                .limit(1)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test07(List<Author> authors) {
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .forEach(author -> System.out.println(author.getAge()));
    }


    /**
     * 对流中的元素按照年龄进行降序排序，并且要求不能有重复元素
     *
     * @param authors 所有作家
     */
    private static void test06(List<Author> authors) {
        authors.stream()
                .distinct()
                .sorted()
                .forEach(author -> System.out.println(author.getAge()));
    }

    /**
     * 打印所以作者的姓名且不能有重复
     *
     * @param authors 所以作者对象
     */
    private static void test05(List<Author> authors) {
        authors.stream()
                .map(Author::getName)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 打印所有作家十年后的年龄
     *
     * @param authors 作家集合
     */
    private static void test04(List<Author> authors) {
        authors.stream()
                .map(Author::getAge)
                .map(age -> age + 10)
                .forEach(System.out::println);
    }

    /**
     * 使用中间操作map方法，将流中的作家对象转换为作家的姓名并打印
     *
     * @param authors 作家对象
     */
    private static void test03(List<Author> authors) {
        authors.stream()
                .map(Author::getName)
                .forEach(System.out::println);
    }

    /**
     * 打印姓名长度大于1的所有作家的名字
     *
     * @param authors 所有作家
     */
    private static void test02(List<Author> authors) {
        authors.stream()
                .filter(author -> author.getName().length() > 1)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test01(List<Author> authors) {

        authors.stream() //将作者集合转换为流
                .distinct()  //将流中的作者进行去重
                .filter(author -> author.getAge() < 18) //将流中的作者按照年龄小于18进行过滤
                .forEach(author -> System.out.println(author.getName())); //将流中的作者遍历打印名字
    }


    private static List<Author> getAuthors() {
        //数据初始化
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚拉索", 15, "狂风也追逐不上他的思考速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));

        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(4L, "吹或不吹", "爱情,个人传记", 56, "一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorList;
    }
}
