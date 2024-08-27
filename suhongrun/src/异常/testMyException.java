package 异常;

public class testMyException {
    public static void main(String[] args) {
        Person p = new Person();
        try {
            p.setName("苏红润");
            p.setAge(-1);
        } catch (IllegalAgeException e) {
            throw new RuntimeException(e);
        }
        System.out.println(p);
    }

}
