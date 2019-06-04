public class SynchronizedDemo implements Runnable {
    private static int count=0;
    public static void main(String args[]){

        new SynchronizedDemo().add();
        System.out.println("result="+count);
    }
    public void add(){

        for(int i=0;i<10;i++){
            Thread thread=new Thread(new SynchronizedDemo());
            thread.start();
        }
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
        synchronized(SynchronizedDemo.class) {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
        }
    }
}
