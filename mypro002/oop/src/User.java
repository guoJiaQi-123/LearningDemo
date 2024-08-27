/*
   测试构造方法的重载
 */
public class User {
    int id;
    String user;
    String  name;
    String pwd;
    public User(){

    }
    public User(String name){
        this.name=name;
    }

    public User(int id, String user, String name, String pwd) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.pwd = pwd;
    }

    public User(String pwd, String user, int id){
        this.pwd=pwd;
        this.user=user;
        this.id=id;
    }
    public static void main(String[] args) {
        User user1 = new User();
        System.out.println(user1.name);
    }
}
