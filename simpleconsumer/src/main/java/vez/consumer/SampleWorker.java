package vez.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class SampleWorker implements Runnable{

    private static BlockingQueue<String> requestQueue = new ArrayBlockingQueue<>(100);
    private static final AtomicInteger pendingItems = new AtomicInteger();

    private final String workerId;

    public SampleWorker(String workerId) {
        System.out.println("Creating worker for " + workerId);
        this.workerId =workerId;
    }

    public static void addToQueue(String order) {
        pendingItems.incrementAndGet();
        try {
            requestQueue.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int getPendingCount() {
        return pendingItems.get();
    }

    @Override
    public void run() {
        while(true) {
            try {
                String order = requestQueue.take();
                System.out.println("Worker " + workerId + " Processing : " + order);
                Thread.sleep(100); //Do all required processing
                pendingItems.decrementAndGet(); //After all processing is done
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
