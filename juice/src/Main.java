import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by р on 17.02.2015.
 */
public class Main {
    public static void main(String[] args) {
        final ArrayList<Juice> data = read();
        final Solver solver = new Solver();
        Thread task1 = new Thread() {
            public void run() {
                solver.solve1(data);
                System.out.println("finished with task1");
            }
        };

        Thread task2 = new Thread() {
            public void run() {
                solver.solve2(data);
                System.out.println("finished with task2");
            }
        };

        Thread task3 = new Thread() {
            public void run() {
                solver.solve3(data);
                System.out.println("finished with task3");
            }
        };
        task1.start();
        task2.start();
        task3.start();
    }
    static ArrayList<Juice> read() {
        ArrayList<Juice>result = new ArrayList<Juice>();

        try {
            Scanner in = new Scanner(new FileInputStream("juice.in"));
            while (in.hasNext()) {
                ArrayList<String> newComponents = new ArrayList<String>();
                String curString = in.nextLine();
                StringTokenizer tokens = new StringTokenizer(curString, " ");
                while (tokens.hasMoreTokens()) {
                    String newComponent = tokens.nextToken();
                    newComponents.add(newComponent);
                }
                result.add(new Juice(newComponents));
            }
        } catch (Exception e) {
            System.out.println("problems while reading");
        }
        return result;
    }
}


