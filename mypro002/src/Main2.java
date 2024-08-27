public class Main2 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<11;i++){
            sb.append("*");
            System.out.println(sb);
        }
        System.out.println("---------我是华丽的分界线---------");
        for (int i=9;i>0;i--){
            sb.delete(i,i+1);
            System.out.println(sb);
        }
    }
}
