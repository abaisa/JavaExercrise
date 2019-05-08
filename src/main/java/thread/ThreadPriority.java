package thread;

class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    public void run(){
        for (int i=0; i<5; i++) {
            if (this.getName().equals("my-thread-1")) {
                ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
                Thread[] listThreads = new Thread[threadGroup.activeCount()];
                threadGroup.enumerate(listThreads);
                for (Thread th : listThreads) {
                    if (th.getName().equals("my-thread-2"))
                        try {
                            // 在线程1里面使用线程2的wait
                            th.wait(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()
                    +"("+Thread.currentThread().getPriority()+ ")"
                    +", loop "+i);
        }
    }
};

public class ThreadPriority {
    public static void main(String[] args) {

        Thread t1=new MyThread("my-thread-1");    // 新建t1
        Thread t2=new MyThread("my-thread-2");    // 新建t2
        t1.setPriority(1);                // 设置t1的优先级为1
        t2.setPriority(9);                // 设置t2的优先级为10
        t1.start();                        // 启动t1
        t2.start();                        // 启动t2
        System.out.println(Thread.currentThread().getName()
                +"("+Thread.currentThread().getPriority()+ ")");

    }
}