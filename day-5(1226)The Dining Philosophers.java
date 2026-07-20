import java.util.concurrent.Semaphore;

class DiningPhilosophers {
    // Locks for the 5 forks
    private final Semaphore[] forks = new Semaphore[5];
    // Global lock allowing at most 4 philosophers to attempt eating simultaneously
    private final Semaphore table = new Semaphore(4);

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    public void wantsToEat(int philosopher,
                            Runnable pickLeftFork,
                            Runnable pickRightFork,
                            Runnable eat,
                            Runnable putLeftFork,
                            Runnable putRightFork) throws InterruptedException {

        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

        // Limit maximum concurrent eating attempts to 4 to avoid deadlock
        table.acquire();

        // Acquire both left and right forks
        forks[leftFork].acquire();
        forks[rightFork].acquire();

        // Perform actions
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();

        // Release forks
        forks[leftFork].release();
        forks[rightFork].release();

        // Release table slot for another philosopher
        table.release();
    }
}
