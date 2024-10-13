package org.example;


import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MMSystem extends Thread implements Transaction {
    private Participant participant;
    private List<Participant> participants;
    private Lock lock = new ReentrantLock();

    public MMSystem(Participant participant, List<Participant> participants) {
        this.participant = participant;
        this.participants = participants;
    }

    @Override
    public void provideHelp() {
        lock.lock();
        try {
            System.out.println(participant.getName() + " is providing help.");
            participant.setProvidedHelp(true);
            participant.setBalance(participant.getBalance() - 100);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void receiveHelp() {
        lock.lock();
        try {
            for (Participant p : participants) {
                if (p.hasProvidedHelp() && p != participant) {
                    System.out.println(participant.getName() + " is receiving help from " + p.getName());
                    participant.setBalance(participant.getBalance() + 150);
                    p.setProvidedHelp(false);
                    break;
                }
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        provideHelp();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        receiveHelp();
    }
}
