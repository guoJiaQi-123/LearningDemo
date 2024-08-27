/*
    *测试Static
 */
public class TestStatic {
    int ID;
    String name;
    static String company="北京尚学堂";
    TestStatic(int ID,String name){
        this.ID=ID;
        this.name=name;
    }
    void login(){
        System.out.println(name);
    }
    static void printCompany(){
        //login();   //静态方法里面调用非静态成员编译就会报错
        System.out.println(company);
    }

    public static void main(String[] args) {
        TestStatic t1 = new TestStatic(5946,"郭家旗");
        TestStatic.printCompany();
        TestStatic.company = "苏红润";
        TestStatic.printCompany();
        System.out.println(t1.ID);
    }
}
