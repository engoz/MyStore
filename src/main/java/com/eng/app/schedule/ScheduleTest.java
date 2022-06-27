package com.eng.app.schedule;

import org.apache.catalina.Executor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ScheduleTest {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private static AtomicInteger count = new AtomicInteger();
    private static AtomicInteger countExecuter = new AtomicInteger();
    private BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(1000);

    @PostConstruct
    public void loadQueue(){
        for (int i=0; i<1000; i++){
            try {
                blockingQueue.put(i);
                System.out.println("Loading pool size " + blockingQueue.size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void testSchedule(){
        long start = System.currentTimeMillis();
        int i = count.incrementAndGet();
        System.out.println("Enter Schedule " + i);
            executor.submit(()->{
                int i1 = countExecuter.incrementAndGet();
                System.out.println("Block call " + i1);
                while (blockingQueue.size() > 0) {
                    System.out.println("Thread Name - > " + Thread.currentThread().getName());
                    Integer poll = blockingQueue.poll();
                    System.out.println("Run Executor calisiyor Pool Value = " + poll + " Size : " + blockingQueue.size());
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        long passTime = System.currentTimeMillis() - start;
        //System.out.println("Exit Schedule " + passTime);

    }


  //  @Scheduled(fixedDelay = 3000)
    public void putPull(){

        boolean offer = blockingQueue.offer(new Random().nextInt());
        System.out.println("Put Executor calisiyor Pool = " + offer);
    }
}
