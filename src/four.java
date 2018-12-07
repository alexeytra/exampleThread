public class four {
    public static void main(String[] args) {
        CallmeFour target = new CallmeFour();
        CallerFour ob1 = new CallerFour(target, "Добро пожаловать");
        CallerFour ob2 = new CallerFour(target, "в синхронизированный");
        CallerFour ob3 = new CallerFour(target, "мир!");

        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Прервано");
        }
    }
}

class CallmeFour {
     void callFour(String msg){
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Прервано");
        }
        System.out.println("]");
    }
}

class CallerFour implements Runnable {
    String msg;
    CallmeFour target;
    Thread t;

    public CallerFour(CallmeFour target, String s){
        this.target = target;
        this.msg = s;
        this.t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (target) {
            target.callFour(msg);
        }
    }
}


