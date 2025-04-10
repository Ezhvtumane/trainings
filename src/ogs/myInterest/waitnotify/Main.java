package ogs.myInterest.waitnotify;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Pub pub = new Pub(store);
        Sub sub = new Sub(store);

        new Thread(pub).start();
        new Thread(sub).start();
        new Thread(sub).start();
        new Thread(sub).start();
    }
}

class Store {
    private int productCount;

    public Store() {
        this.productCount = 0;
    }

    public synchronized void put() {
        System.out.println(Thread.currentThread().getName() + ", PUT. Method start");
        while (productCount >= 2) {
            try {
                System.out.println(Thread.currentThread().getName() + ", PUT. Before wait");
                this.wait();
                System.out.println(Thread.currentThread().getName() + ", PUT. After wait");
            } catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
        productCount++;
        System.out.println(Thread.currentThread().getName() + ", PUT. Before notify");
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + ", PUT. After notify. Method end. Products: " + productCount);
    }

    public synchronized void get() {
        System.out.println(Thread.currentThread().getName() + ", GET. Method start");
        while (productCount < 1) {
            try {
                System.out.println(Thread.currentThread().getName() + ", GET. Before wait");
                this.wait();
                System.out.println(Thread.currentThread().getName() + ", GET. After wait");
            } catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
        productCount--;
        System.out.println(Thread.currentThread().getName() + ", GET. Before notify");
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + ", GET. After notify. Method end. Products: " + productCount);
    }
}

class Pub implements Runnable {

    Store store;

    public Pub(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 9; i++) {
            store.put();
            try {
                Thread.sleep(100);
            } catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Sub implements Runnable {

    Store store;

    public Sub(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            store.get();
            try {
                Thread.sleep(100);
            } catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
