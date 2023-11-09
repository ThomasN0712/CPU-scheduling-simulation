/**
 * FCFS scheduling algorithm.
 */
 
import java.util.*;

public class FCFS implements Algorithm
{
    private List<Task> queue;
    
    public FCFS(List<Task> queue) {
        this.queue = queue;
    }
    
    public void schedule() {
        System.out.println("-------------------FCFS Scheduling---------------------\n");
        
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