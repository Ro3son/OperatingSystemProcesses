import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) {

        Process p1 = new Process("1", "Ready", "High");
        Process p2 = new Process("2", "Ready", "Low");
        Process p3 = new Process("3", "Ready", "Medium");

        Queue<Process> readyQueue = new LinkedList<Process>();

        readyQueue.offer(p1);
        readyQueue.offer(p2);
        readyQueue.offer(p3);

        boolean isAlive = false;

        while (!readyQueue.isEmpty()) {

            Process process = readyQueue.poll();

            process.state = "Running";

            System.out.println("PID: " + process.pid + " " + "state: " + "Ready to " + process.state);

            if (process.state == "Running" && !isAlive) {

                process.state = "Ready";

                readyQueue.offer(process);

                isAlive = true;

                System.out.println("PID: " + process.pid + " " + "state: " + "Running to " + process.state);

            } else {

                process.state = "Terminated";

                isAlive = false;

                System.out.println("PID: " + process.pid + " " + "state: " + "Running to " + process.state);
            }
        }
    }
}