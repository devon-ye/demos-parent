package org.devon.concurrency;

/**
 * Created by lenovo on 2017/10/8.
 */
public class UnshareDataThread extends Thread{
    private int count = 100;

    public UnshareDataThread(String name) {
        super();
        this.setName(name);
    }


    @Override
    public  void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("current" + this.currentThread().getName() + "computed , count=" + this.count);
        }
    }

   public static void main(String args[]) {
        UnshareDataThread udt1 = new UnshareDataThread("A");
       UnshareDataThread udt2 = new UnshareDataThread("B");
       UnshareDataThread udt3 = new UnshareDataThread("C");
       UnshareDataThread udt4 = new UnshareDataThread("D");
       udt1.start();
       udt2.start();
       udt3.start();
       udt4.start();
   }

}
