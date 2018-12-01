//Создание многих потоков исполнения
public class Main {

    public static void main(String[] args) {
        new NewThread("Один");
        new NewThread("Два");
        new NewThread("Три");

        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            System.out.println("Главный поток прерван");
        }

        System.out.println("Главный поток завршен.");
    }
}

class NewThread implements Runnable {
    String name;
    Thread t;

    NewThread(String threadname) {
        name = threadname;
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
