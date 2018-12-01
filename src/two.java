public class two {
    public static void main(String[] args) {
        NewThreadTwo ob1 = new NewThreadTwo("One");
        NewThreadTwo ob2 = new NewThreadTwo("Two");
        NewThreadTwo ob3 = new NewThreadTwo("Three");

        System.out.println("Thread one is running: " + ob1.t.isAlive());
        System.out.println("Thread two is running: " + ob2.t.isAlive());
        System.out.println("Thread three is running: " + ob3.t.isAlive());

        try {
            System.out.println("waiting for threads complete");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }catch (InterruptedException e){
            System.out.println("Главный поток прерван");
        }

        System.out.println("Thread one is running: " + ob1.t.isAlive());
        System.out.println("Thread two is running: " + ob2.t.isAlive());
        System.out.println("Thread three is running: " + ob3.t.isAlive());

        System.out.println("Main thread finished");
    }
}

class NewThreadTwo implements Runnable {
    String name;
    Thread t;

    NewThreadTwo(String threadName){
        name = threadName;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        t.start();
    }

    @Override
    public void run() {
        try{
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            System.out.println(name + " прерван");
        }
        System.out.println(name + " завершен");
    }
}
