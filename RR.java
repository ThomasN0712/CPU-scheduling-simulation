
/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling.
 */

import java.util.*;

// Your code here
public class RR implements Algorithm {
  private List<Task> queue;
  private int timeQuantum;

  // constructor, initializes queue and sets the timeQuantum
  public RR(List<Task> queue) {
    this.queue = queue;
    this.timeQuantum = 10;
  }

  // algorithm itself
  public void schedule() {
    System.out.println("-------------------Round Robin Scheduling---------------------\n");
    while (queue.isEmpty() == false) {
      // read process from queue
      Task task = pickNextTask();

      // if task burst time shorter than time quantum, run for task's burst time
      if (task.getBurst() <= timeQuantum) {
        CPU.run(task, task.getBurst());
        task.setBurst(0);
      }
      // if task burst time larger than time quantum, run for time quantum
      else {
        CPU.run(task, timeQuantum);
        task.setBurst(task.getBurst() - timeQuantum);
      }

      // if task is not done, move to the back of the queue
      if (task.getBurst() > 0) {
        queue.remove(task);
        queue.add(task);
      }
      // if the task is done, remove forever
      else {
        System.out.println("Task finished: " + task.getName() + "\n");
        queue.remove(task);
      }
    }
  }

  public Task pickNextTask() {
    return queue.get(0);
  }
}