package org.example;

import java.util.ArrayList;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Participant user1 = new Participant("user1", 500);
        Participant user2 = new Participant("user2", 300);
        Participant user3 = new Participant("user3", 600);
        Participant user4 = new Participant("user4", 200);
        Participant user5 = new Participant("user5", 700);
        Participant user6 = new Participant("user6", 400);
        Participant user7 = new Participant("user7", 1000);


        List<Participant> participants = new ArrayList<>();
        participants.add(user1);
        participants.add(user2);
        participants.add(user3);
        participants.add(user4);
        participants.add(user5);
        participants.add(user6);
        participants.add(user7);



        MMSystem t1 = new MMSystem(user1, participants);
        MMSystem t2 = new MMSystem(user2, participants);
        MMSystem t3 = new MMSystem(user3, participants);
        MMSystem t4 = new MMSystem(user4, participants);
        MMSystem t5 = new MMSystem(user5, participants);
        MMSystem t6 = new MMSystem(user6, participants);
        MMSystem t7 = new MMSystem(user7, participants);


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
        }catch (InterruptedException e){
            System.out.println("Order process was Interrupted");
        }

        for (Participant p: participants){
            System.out.println(p.getName() + "final balance: $" + p.getBalance());
//            System.out.println("*****************************************");
        }
    }
}