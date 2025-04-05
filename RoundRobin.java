public class RoundRobin {
    // // Determine the waiting times for all processes using this function.
    public static void findWaitingTime(int[] processes, int n, int[] burst_time, int[] waittime, int quantum) {
        // / Copy burst times bt[] to store any remaining burst times.
        int[] remaining_bursttime = new int[n];
        System.arraycopy(remaining_bursttime, 0, remaining_bursttime, 0, n);
        int t = 0; // Current time
        //Till all the processes are finished, continue round-robin processing.
        while (true) {
            boolean done = true;
            // repeatedly go through each process one at a time
            for (int i = 0 ; i < n; i++) {
                //Whenever a process's burst time exceeds 0
                //then, only more processing is required.
                if (remaining_bursttime[i] > 0) {
                    done = false; // A process is still in progress.
                    if (remaining_bursttime[i] > quantum) {

                        t += quantum;

                        remaining_bursttime[i] -= quantum;
                    }
                    // if the burst time is less than or the same as the quantum. The final cycle of this
                    else {

                        t = t + remaining_bursttime[i];
                        // Current time less the time spent on this process is the waiting time.
                        waittime[i] = t - burst_time[i];
                        // Make the process's remaining burst time = 0
                        // once it completes
                        remaining_bursttime[i] = 0;
                    }
                }
            }
            // If all processes are done
            if (done)
                break;
        }
    }
    // Determine turn around time
    public static void findTurnAroundTime(int[] processes, int n, int[] bursttime, int[] waitingtime, int[] turnaroundtime) {
        // calculating turnaround time by adding
        // bursttime[i] + waittime[i]
        for (int i = 0; i < n ; i++)
            turnaroundtime[i] = bursttime[i] + waitingtime[i];
    }
    // Determine average time
    public static void findavgTime(int[] processes, int n, int[] bursttime, int quantum) {
        int[] waittime = new int[n];
        int[] turnaroundtime = new int[n];
        int total_waittime = 0;
        int total_turnaroundtime = 0;
        // Determine waiting time of all processes
        findWaitingTime(processes, n, bursttime, waittime, quantum);
        /* Determine turn around time for all processes */
        findTurnAroundTime(processes, n, bursttime, waittime, turnaroundtime);
        // Print processes along with the information
        System.out.print("Processes ");
        System.out.print(" Burst time ");
        System.out.print(" Waiting time ");
        System.out.print(" Turn around time\n");
        // Determine total waiting time and total turn
        // around time
        for (int i = 0; i < n; i++) {
            total_waittime = total_waittime + waittime[i];
            total_turnaroundtime = total_turnaroundtime + turnaroundtime[i];
            System.out.print(" ");
            System.out.print(i + 1);
            System.out.print("\t\t");
            System.out.print(bursttime[i]);
            System.out.print("\t ");
            System.out.print(waittime[i]);
            System.out.print("\t\t ");
            System.out.print(turnaroundtime[i]);
            System.out.print("\n");
        }
        System.out.print("Average waiting time = ");
        System.out.print((float)total_waittime / (float)n);
        System.out.print("\nAverage turn around time = ");
        System.out.print((float)total_turnaroundtime / (float)n);
    }
    public static void main(String[] args) {
        // process id's
        int[] processes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
// int n = size of processes / size of processes[0];
        int n = processes.length;
        // Burst time of all processes
        int[] burst_time = {10, 5, 8, 4, 3, 2, 1, 7, 8, 9};
        // Time quantum
        int quantum = 2;
        findavgTime(processes, n, burst_time, quantum);
    }
}
