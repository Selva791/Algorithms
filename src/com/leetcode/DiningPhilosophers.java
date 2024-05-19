package com.leetcode;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {
    Thread lf;
    Thread rf;
    Thread e;
    Thread plf;
    Thread prf;
    int count = 0;
    Set<Integer> ids;
    ReentrantLock[] forks;

    public DiningPhilosophers() {
        count = 5;
        ids = ConcurrentHashMap.newKeySet();
        forks = new ReentrantLock[count];
        for (int i = 0; i < count; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {


        wantsToEatRunner(philosopher,
                pickLeftFork,
                pickRightFork,
                eat,
                putLeftFork,
                putRightFork);


    }

    public void wantsToEatRunner(int philosopher,
                                 Runnable pickLeftFork,
                                 Runnable pickRightFork,
                                 Runnable eat,
                                 Runnable putLeftFork,
                                 Runnable putRightFork) throws InterruptedException {

        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % count;

        if (!ids.contains(philosopher)) {

            forks[leftFork].lock();
            forks[rightFork].lock();


            try {
                rf = new Thread(pickRightFork);
                lf = new Thread(pickLeftFork);
                e = new Thread(eat);
                prf = new Thread(putRightFork);
                plf = new Thread(putLeftFork);

                rf.start();
                lf.start();
                e.start();
                prf.start();
                plf.start();

                ids.add(philosopher);
            } finally {
                forks[leftFork].unlock();
                forks[rightFork].unlock();
            }
        }
    }
}