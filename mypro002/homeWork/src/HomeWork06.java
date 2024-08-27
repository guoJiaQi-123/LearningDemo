//测试Object[][]存储表格数据
public class HomeWork06 {
    public static void main(String[] args) {
        Object[] a1={1001,"高 淇",18,"程序员",30000,5000};
        Object[] a2={1001,"高小二",19,"讲 师",35000,2000};
        Object[] a3={1001,"高小松",20,"教 授",20000,3000};
        Object[][] objects=new Object[3][];
        objects[0]=a1;
        objects[1]=a2;
        objects[2]=a3;
        for(int i=0;i<objects.length;i++){
            for(int j=0;j<objects[i].length;j++){
                System.out.print(objects[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
