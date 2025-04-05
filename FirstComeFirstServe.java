
public class FirstComeFirstServe {


    private static int[] processes;

    // Determine the waiting times for all processes using this function.
    public static void findWaitingTime(int[] processes, int m, int[] bursttime, int[] waittime) {
        FirstComeFirstServe.setProcesses(processes);
        // waiting time for first process is 0
        waittime[0] = 0;

        // calculating waiting time
        for (int i = 1; i < m ; i++)
            waittime[i] = bursttime[i - 1] + waittime[i - 1];
    }

    // Turnaround time computation
    public static void findTurnAroundTime(int[] processes, int n, int[] bursttime, int[] waitttime, int[] turnaroundtime) {
        FirstComeFirstServe.setProcesses(processes);
        // calculating turnaround time by adding
        // bursttime[i] + waittime[i]
        for (int i = 0; i < n ; i++)
            turnaroundtime[i] = bursttime[i] + waitttime[i];
    }

    //Calculator for the average time
    public static void findavgTime(int[] processes, int m, int[] bursttime) {
        int[] waittime = new int[m];
        int[] turnaroundtime = new int[m];
        int total_waittime = 0;
        int total_turnaroundtime = 0;

        //a method to calculate the waiting times
        findWaitingTime(processes, m, bursttime, waittime);

        //For all processes, there is a function to determine turnaround time.
        findTurnAroundTime(processes, m, bursttime, waittime, turnaroundtime);

        //Print all the Process with these information
        System.out.print("Processes  ");
        System.out.print("");
        System.out.print("Burst  ");
        System.out.print("");
        System.out.print(" Waiting time  ");
        System.out.print("");
        System.out.print(" Turn around time\n");

        // Calculate total waiting time and total turn
        // around time
        for (int i = 0; i < m; i++) {
            total_waittime = total_waittime + waittime[i];
            total_turnaroundtime = total_turnaroundtime + turnaroundtime[i];
            System.out.print("  ");
            System.out.print(i + 1);
            System.out.print("  ");
            System.out.print("\t\t");
            System.out.print("   ");
            System.out.print(bursttime[i]);
            System.out.print("  ");
            System.out.print("\t   ");
            System.out.print(waittime[i]);
            System.out.print("  ");
            System.out.print("\t\t   ");
            System.out.print("  ");
            System.out.print(turnaroundtime[i]);
            System.out.print("  ");
            System.out.print("\n");

        }

        System.out.print("Average waiting time = ");
        System.out.print((float)total_waittime / (float)m);
        System.out.print("\nAverage turn around time = ");
        System.out.print((float)total_turnaroundtime / (float)m);


    }

    // The Driver code
    public static void main(String[] args) {
        //process id's
        int[] processes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        /* : int n = sizeof processes / sizeof processes[0]; */
        int m = processes.length;

        //Burst time of all processes
        int[] burst_time = {10, 5, 8, 2, 4, 6, 7, 8, 9, 12};

        findavgTime(processes, m, burst_time);
    }

    public static void setProcesses(int[] processes) {
        FirstComeFirstServe.processes = processes;
    }
}