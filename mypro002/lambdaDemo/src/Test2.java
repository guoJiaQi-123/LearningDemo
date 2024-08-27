public class Test2 {
    public static void main(String[] args) {
        /*ReturnOneParam returnOneParam =(a)->double2(a);
        System.out.println(returnOneParam.method(10));*/

        ReturnOneParam returnOneParam=Test::double2;
        System.out.println(returnOneParam.method(20));

        Test test =new Test();
        ReturnOneParam returnOneParam1=test::addTwo;
        System.out.println(returnOneParam1.method(10));

    }

}
