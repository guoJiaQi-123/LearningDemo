/*
  *测试if-else双分支结构
  * 条件语句与双分支结构语句
*/
public class TestIf02 {
    public static void main(String[]args){
        int r = (int)(Math.random()*4+1);
        double area = Math.PI*r*r;
        double circle = 2*Math.PI*r;
        System.out.println("半径为："+r);
        System.out.println("面积为："+area);
        System.out.println("周长为："+circle);
        if(area>=circle){
            System.out.println("面积的数值要大于等于周长");
        }else{
            System.out.println("面积的数值要小于周长");
        }
        //条件语句
        int a =(int)(Math.random()*6+1);
        int b =(int)(Math.random()*6+1);
        int c = a < b ? b : a;
        System.out.println("a等于："+a);
        System.out.println("b等于："+b);
        System.out.println("c等于："+c);
    }
}
