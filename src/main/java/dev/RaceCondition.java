package dev;

public class RaceCondition {
    private int cnt = 0;

    public void increment() {
        // Race Condition 발생하는 부분!
        cnt++;
    }

    public int getCnt() {
        return cnt;
    }

    public static void main(String[] args) throws InterruptedException {
        RaceCondition example = new RaceCondition();
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                example.increment();
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // 예상 : 20000
        System.out.println("동기화 적용 X : " + example.getCnt());
    }
}
