package mThread.study1;

import java.util.concurrent.TimeUnit;

public class test extends Thread{

    static void testJoin() throws InterruptedException{
        Thread t1 = new Thread(()->{
            System.out.println("T1");
            for (int i=0;i<10;i++){
                System.out.println("111");
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            System.out.println("T2");
            for (int i=0;i<10;i++) {
                System.out.println("222");
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        t2.join();
        t1.start();
    }

    public static void main (String args[]) throws InterruptedException{
        testJoin();
    }
}
