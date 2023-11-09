/**
 * Non-preemptive priority scheduling algorithm.
 */
 
import java.util.*;

public class Priority
{
    private List<Task> queue;
    
    public Priority(List<Task> queue) {
        this.queue = queue;
    }
    
    public void schedule() {
        System.out.println("Priority Scheduling\n");
        
        while (!queue.isEmpty()) {
            Task task = pickNextTask();
            
            System.out.println("Running task: " + task.getName());   
            
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