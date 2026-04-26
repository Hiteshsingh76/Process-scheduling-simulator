import java.util.ArrayList;

class Process {
    int processId;
    int burstTime;
    int waitingTime;
    int turnaroundTime;

    public Process(int processId, int burstTime) {
        this.processId = processId;
        this.burstTime = burstTime;
    }
}

public class ProcessSchedulingSimulator {
    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();

        processes.add(new Process(1, 5));
        processes.add(new Process(2, 3));
        processes.add(new Process(3, 8));
        processes.add(new Process(4, 6));

        calculateFCFS(processes);
        displayResults(processes);
    }

    public static void calculateFCFS(ArrayList<Process> processes) {
        int currentTime = 0;

        for (Process process : processes) {
            process.waitingTime = currentTime;
            process.turnaroundTime = process.waitingTime + process.burstTime;
            currentTime += process.burstTime;
        }
    }

    public static void displayResults(ArrayList<Process> processes) {
        System.out.println("FCFS Scheduling Results");
        System.out.println("-----------------------");
        System.out.println("Process\tBurst Time\tWaiting Time\tTurnaround Time");

        for (Process process : processes) {
            System.out.println(
                    "P" + process.processId + "\t\t" +
                            process.burstTime + "\t\t\t" +
                            process.waitingTime + "\t\t\t\t" +
                            process.turnaroundTime
            );
        }
    }
}