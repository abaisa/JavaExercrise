package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

// 多线程练习

public class MutipleThread {
    public static void main(String[] args) {
        // <1> Thread模式
        for (int i = 0; i < 5; i++) {
            Thread th = new Thread1();
            th.start();
        }
        // <2> Runnable模式
        for (int i = 0; i < 5; i++) {
            Thread2 thread2 = new Thread2();
            Thread th = new Thread(thread2);
            th.start();
        }
        // <3> callable模式
        Thread3 thread3 = new Thread3();
        for (int i = 0; i < 5; i++) {
            FutureTask<Long> futureTask = new FutureTask<Long>(thread3);
            Thread th = new Thread(futureTask);
            th.start();
            try {
                Long res = futureTask.get();
                System.out.println("Result is > " + res);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

// <1>
class Thread1 extends Thread {
    @Override
    public void run(){
        System.out.println("version 1 thread, Name > " + this.getName());
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// <2>
class Thread2 implements Runnable{

    public void run() {
        System.out.println("version 2 thread, Name > " + Thread.currentThread().getName());

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// <3>
class Thread3 implements Callable<Long>{

    public Long call() throws Exception{
        System.out.println("version 3 thread, Name > " + Thread.currentThread().getName());

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();
        threadLocal.set(Thread.currentThread().getId());
        return threadLocal.get();
    }
}