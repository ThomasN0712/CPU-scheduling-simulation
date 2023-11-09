/**
 * Non-preemptive priority scheduling algorithm.
 */
 
import java.util.*;

public class Priority implements Algorithm
{
    private List<Task> queue;
    
    public Priority(List<Task> queue) {
        this.queue = queue;

        // Create a empty sorted queue
        List<Task> sortedQueue = new ArrayList<Task>();

        // Sort the queue by priority
        while (!queue.isEmpty()) {
            Task lowestPri = queue.get(0);
            for (Task task : queue) {
                if (task.getPriority() < lowestPri.getPriority()) {
                    lowestPri = task;
                }
            }
            // Add the lowest priority task to the sorted queue and remove it from queue
            sortedQueue.add(lowestPri);
            queue.remove(lowestPri);
        }

        // Set the queue to the sorted queue
        this.queue = sortedQueue;
    }
    
    public void schedule() {
        System.out.println("-------------------Priority Scheduling---------------------\n");
        
        while (queue.isEmpty() == false) {
            Task task = pickNextTask();

            CPU.run(task, task.getBurst());

            System.out.println("Task finished: " + task.getName() + "\n");
            
            // Remove task from queue
            queue.remove(task);
        }
    }
    
    public Task pickNextTask() {
        // Pick the first task in the queue
        return queue.get(0);
    }
}