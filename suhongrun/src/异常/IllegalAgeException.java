package 异常;

public class IllegalAgeException extends Exception{
    public IllegalAgeException(){}
    public IllegalAgeException(String message){
        super(message);
    }
}
