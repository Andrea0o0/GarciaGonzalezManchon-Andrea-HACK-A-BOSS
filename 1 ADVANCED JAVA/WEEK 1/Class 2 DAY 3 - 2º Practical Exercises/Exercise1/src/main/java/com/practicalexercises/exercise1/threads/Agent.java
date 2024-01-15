package com.practicalexercises.exercise1.threads;

import com.practicalexercises.exercise1.models.Call;
import com.practicalexercises.exercise1.models.EndCalls;
import java.util.Random;
import java.util.concurrent.BlockingQueue;


public class Agent extends Thread {
    private String agentName;
//    BlockingQueue in this case is bounded queue which means you create sub queues or now threads/subprocess by passing the limit of the constructor. By now 10 is the capacity for this blocking Queue
    private BlockingQueue<Call> callQueue;

    public Agent(String agentName, BlockingQueue<Call> callQueue) {
        this.agentName = agentName;
        this.callQueue = callQueue;
    }

    @Override
    public void run() {
        while (true) {
            Random rand = new Random();
            try {
                // Agents wait for a call to be available
                Call call = callQueue.take();
                if (call instanceof EndCalls) {
                    System.out.println(agentName + " is done for the day.");
                    break;
                }
                System.out.println(agentName + " is attending a call from " + call.getClientName()+
                        ". Query: " + call.getInfoQuery());
                // Simulate resolving the query
                int timeEnd = rand.nextInt(5000)+5000;
                Thread.sleep(timeEnd);
                System.out.println(agentName + " completed the call with " + call.getClientName() + " at " + (timeEnd/1000) + " seconds"  );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
