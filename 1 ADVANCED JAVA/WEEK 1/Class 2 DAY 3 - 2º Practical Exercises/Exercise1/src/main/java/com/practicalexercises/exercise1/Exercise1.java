package com.practicalexercises.exercise1;

import com.practicalexercises.exercise1.models.Call;
import com.practicalexercises.exercise1.models.EndCalls;
import com.practicalexercises.exercise1.threads.Agent;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Exercise1 {

    public static void main(String[] args) {
        // 5 is the max people attending at the same time (threads)
         BlockingQueue<Call> callQueue = new ArrayBlockingQueue<>(5);
         Random rand = new Random();
         String[] queryTypes = {"Error with the WIFI", "Please lower my mobile rate", "You are scammers, unsubscribe now", "I love your services", "I want to hire more services", "doubts with my rate", "complaints"};
         String[] customersNames = {"Pepa", "Manola", "Jacinta", "Encarni","Concepción", "Gertrudis", "Inocencia", "Manolo", "Paco", "Antonio", "José", "Andrea", "Tomás", "Alex", "Luisina"};

         Agent[] agents = new Agent[3];
        // Create three customer service agents
        for (int i = 0; i < agents.length; i++) {
            agents[i] = new Agent("Agent "+(i+1), callQueue);
            // Start the agents
            agents[i].start();
        }
        

        // Simulate 20 incoming calls
        for (int i = 1; i <= 20; i++) {
            
            Call call = new Call(customersNames[rand.nextInt(customersNames.length)], queryTypes[rand.nextInt(queryTypes.length)]);
            try {
                callQueue.put(call);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Add end-of-calls marker to signal agents to stop
        for (Agent agent : agents) {
            try {
                callQueue.put(new EndCalls());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Wait for agents to finish
        for (Agent agent : agents) {
            try {
                agent.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // All calls processed, print a message
        System.out.println("All calls processed. Customer service center closed. Bye Bye :) ");
    }
}
