public class Person {
    String name;
    int age;
    public void show(){
        System.out.println(this.name);

    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "郭家旗";
        p1.age = 20;
        p1.show();

        Person p2 = new Person();
        p2.name="苏红润";
        p2.age=19;
        p2.show();


        Person p3 = p1;
        p3.age = 21;
        System.out.println(p1.age);
    }
}
