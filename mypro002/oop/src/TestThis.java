public class TestThis {
    int a,b,c;

    TestThis(){
        System.out.println("正要初始化的对象"+this);
    }
    TestThis(int a,int b){
        this();
        this.a=a;
        this.b=b;
    }

    TestThis(int a,int b,int c){
        this(a, b);
        this.c=c;

    }
    public void sing(){

    }
    public void eat(){
        System.out.println("当前对象"+this);
        this.sing();
        System.out.println("你妈叫你吃饭啦！！");

    }

    public static void main(String[] args) {
        TestThis h1 = new TestThis(2,8);
        h1.eat();

    }

}
