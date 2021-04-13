package uff.ic.lleme.tcc00328.s20202.exemplo.thread.safelock;

import java.util.Random;

class BowLoop implements Runnable {

    private final Friend bower;
    private final Friend bowee;

    public BowLoop(Friend bower, Friend bowee) {
        this.bower = bower;
        this.bowee = bowee;
    }

    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                break;
            }
            bowee.bow(bower);
        }
    }

}
