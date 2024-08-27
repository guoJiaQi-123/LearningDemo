package 异常;

public class test1 {
    public static void main(String[] args) {
        //ArithmeticException异常
        int b=0;
        if(b!=0){
            System.out.println(1/b);
        }
        //NullPointerException异常
        String str="";
        if(str!=null){
            System.out.println(str.charAt(0));
        }
        //ClassCastException异常
        Animal a=new Cat();
        if(a instanceof Dog){
            Dog d=(Dog) a;
            d.eat();
        }
        //ArrayIndexOutOfBoundsException异常
        int[] arr=new int[5];
        int index=5;
        if(index>=0&&index<5){
            System.out.println(arr[index]);
        }
    }
}
