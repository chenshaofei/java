package soft.fei;

import java.util.Random;

public class test{

       static void ran(){
            Random random=new Random();
            int x=(int)random.nextInt(1000)+1000;
            try{
                Thread.sleep(x);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    public static void main(String[] args) {
        final ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
        Runnable task1=()-> {
            for (int i = 0; i < 5; i++) {
                ran();
                threadLocal.set(i);
                int x = (int) threadLocal.get();
                System.out.println("task1:"+x);
            }
        };

            Runnable task2=()->{
                for (int i = 0; i <5 ; i++) {
                    ran();
                    threadLocal.set(i);
                    int x=(int)threadLocal.get();
                    System.out.println("task2:"+x);
                }

        };

        new Thread(task1).start();
        new Thread(task2).start();

    }


}