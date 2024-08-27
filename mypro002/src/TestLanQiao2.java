/**
 * 制作门牌号
 */
public class TestLanQiao2 {
    public static void main(String[] args) {
        //定义一个计数器
        int count=0;
        for(int i=1;i<2021;i++){
            /*//将门牌号包装为对象
            Integer integer=new Integer(i);
            //通过包装类的API转整形为字符串型
            String string = integer.toString();*/

            //通过String类中的静态方法valueOf(int i)将i转换为字符串类型
            String string = String.valueOf(i);
            //遍历字符串
            for(int n=0;n<string.length();n++){
                //如果字符串中含有2，则计数器加加
                if(string.charAt(n)=='2'){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
