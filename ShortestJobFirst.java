import java.util.Arrays;

import java.util.Scanner;

public class ShortestJobFirst {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" number of process:");
        //Initialize the variables
        var m = sc.nextInt();
        var proc = new int[m];
        var burst = new int[m];
        var comp = new int[m];
        var turn = new int[m];
        var wait = new int[m];
        var arrivaltime = new int [m];

        int st = 0, tot = 0;
        float avgwt = 0, avgta = 0;

        int[] at = new int[m];
        var g = new int[m];
        for (int i = 0; i < m; i++) {
            //Print the process and arrival time
            System.out.println("Enter Process " + (i + 1) + " Arrival Time:");
            arrivaltime[i] = sc.nextInt();
            //Enter Proces , arriva,l and burst time
            System.out.println("Enter Process " + (i + 1) + " Burst Time:");
            burst[i] = sc.nextInt();
            proc[i] = i + 1;
            g[i] = 0;
        }


        do {
            int c = m, min = 999999;

            if (tot == m)
                break;

            for (int i = 0; i < m; i++) {

                if ((at[i] <= st) && (g[i] == 0) && (burst[i] < min)) {
                    min = burst[i];
                    c = i;
                }
            }
            if (c == m)
                st++;
            else {
                //Calculating Complete time
                comp[c] = st + burst[c];
                st += burst[c];
                //Calculating turn around
                turn[c] = comp[c] - at[c];
                //Calculating wait time
                wait[c] = turn[c] - burst[c];
                g[c] = 1;
                proc[tot] = c + 1;
                tot++;
            }
        } while (true);

        System.out.println("\npro arrival burst  complete turn waiting");
        for (int i = 0; i < m; i++) {
            avgwt += wait[i];
            avgta += turn[i];
            //Print all the information for the processes from arrival time, burst time , complete time , turn around  time
            //Wait time and average for both wait and turn turnaround time
            System.out.println(proc[i] + "\t\t" + at[i] + "\t\t" + burst[i] + "\t\t" + comp[i] + "\t\t" + turn[i] + "\t\t" + wait[i]);
        }
        // Calculating average turn around and waiting time
        for (String s : Arrays.asList("\naverage turnaround is " + (avgta / m), "average wait time is " + (avgwt / m))) {
            System.out.println(s);
        }
        sc.close();
        for (int i = 0; i < m; i++) {
            System.out.print(proc[i] + " ");
        }
    }
}


