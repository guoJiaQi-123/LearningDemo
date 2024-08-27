package com.itbaizhan.polymorphism;
//  测试多态
public class TestPolym {
    public static void main(String[] args) {
        //AnimalCry(new dog());
        //AnimalCry(new cat());

        // 编译类型animal   运行时类型dog
        Animal animal = new dog();
        animal.shout();
        //animal.seeDoor;
        dog d = (dog)animal; //强制类型转换
        d.seeDoor();

        //cat c = (cat)animal;     编译不会报错，运行会报异常：ClassCastException

        if (animal instanceof cat){
            cat c = (cat)animal;
            c.CatchingMice();
        }




        DiffPerson(new Chinese());
        DiffPerson(new American());

    }
    static void AnimalCry(Animal animal){
        System.out.println("TestPolym.AnimalCry");
        animal.shout();  //可以出现多态
    }
    static void DiffPerson(Person person){
        person.eat();
    }
}

