public class Test3 {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()+"开始");
        new Thread(()->{
            for(int i =0;i<20;i++){
                try {
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName()+" " +i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"lambda Thread").start();
        System.out.println(Thread.currentThread().getName()+"结束");

    }
}
