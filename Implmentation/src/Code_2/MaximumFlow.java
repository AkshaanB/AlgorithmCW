package Code_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

/**
 *
 * @author Dhanasekara Mudiyanselage Akshaan Dileesha Bandara
 * @UOW_ID/IIT_ID w1743055/2018597
 */

public class MaximumFlow {
    private final int vertices;
    private ArrayList<Integer> visitedNode = new ArrayList<>();

    public MaximumFlow(int vertices) {
        this.vertices = vertices;
    }

    private boolean breadthFirstSearch(int[][] residualGraph, int source, int sink, int[] paths) {
        boolean pathFound = false;
        boolean[] visited = new boolean[vertices];

        LinkedList<Integer> nodes = new LinkedList<>();
        nodes.add(source);
        visited[source] = true;
        paths[source] = -1;

        while (nodes.size() != 0) {
            int u = nodes.poll();
            for (int v = 0; v < vertices; v++) {
                if (visited[v] == false && residualGraph[u][v] > 0) {
                    nodes.add(v);
                    paths[v] = u;
                    visited[v] = true;
                }
            }
        }
        pathFound = visited[sink];
        return pathFound;
    }

    private int maxFlow(int[][] graph, int source, int sink) {
        int u;
        int v;

        int[][] residualGraph = new int[vertices][vertices];
        for (u = 0; u < vertices; u++) {
            for (v = 0; v < vertices; v++) {
                residualGraph[u][v] = graph[u][v];
            }
        }
        int[] path = new int[vertices];

        int maxFlow = 0;

        while (breadthFirstSearch(residualGraph, source, sink, path)) {
            int pathFlow = Integer.MAX_VALUE;
            for (v = sink; v != source; v = path[v]) {
                visitedNode.add(v);
                u = path[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            for (v = sink; v != source; v = path[v]) {
                u = path[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }
            maxFlow += pathFlow;
            Collections.reverse(visitedNode);
            System.out.println("Path: "+visitedNode+" Flow: "+pathFlow);
            visitedNode.clear();
        }

        return maxFlow;
    }

    public static void main(String[] args) {
        Stopwatch stopwatch_1 = new Stopwatch();
        String filePath = "D:\\My Work\\Syllabus\\Algorithms\\CW\\Implmentation\\";
        Scanner input = new Scanner(System.in);

        int[][] graph = new int[0][];
        Scanner data = null;
        ArrayList<Integer> generalData = new ArrayList<>();

        try {
            //**
            graph = matrix(filePath+"Data6x6.txt");
            data = new Scanner(new File(filePath+"GeneralData.txt"));
            //**
            while(data.hasNextInt()){
                int num = data.nextInt();
                generalData.add(num);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        int source = generalData.get(0);
        System.out.println("Source: "+source);
        int sink = generalData.get(1);
        System.out.println("Sink: "+sink);
        MaximumFlow m_1 = new MaximumFlow(graph.length);

        System.out.println("The maximum possible flow is " +
                m_1.maxFlow(graph, source, sink));
        System.out.println("The time elapsed: " + stopwatch_1.elapsedTime());

        System.out.println("Select option: ");
        System.out.println("   1) Delete a link and get the maximum flow");
        System.out.println("   2) Modify the capacity of any link and get the maximum flow");
        System.out.println("   3) Print the graph");
        System.out.println("   4) Exit");
        System.out.print("Option: ");
        int option = getInteger(input);
        while ((option<=1 && option>=4)){
            System.err.println("Invalid response!");
            System.out.print("Please reenter");
            option = getInteger(input);
        }

        while ((option>=1 && option<=4)){
            if(option==1){
                Stopwatch stopwatch_2 = new Stopwatch();
                if(!(graph.length==0)) {
                    System.out.println("graph"+Arrays.deepToString(graph));
                }else {
                    System.err.println("Graph doesn't exist!");
                }
                System.out.print("Starting node: ");
                int startingNode = getInteger(input);

                System.out.print("Ending node: ");
                int endingNode = getInteger(input);

                graph [startingNode] [endingNode] = 0;
                System.out.println("graph"+Arrays.deepToString(graph));
                source = generalData.get(0);
                System.out.println("Source: "+source);
                sink = generalData.get(1);
                System.out.println("Sink: "+sink);
                MaximumFlow m_2 = new MaximumFlow(graph.length);

                System.out.println("The maximum possible flow is " +
                        m_2.maxFlow(graph, source, sink));
                System.out.println("The time elapsed: " + stopwatch_2.elapsedTime());
                System.out.print("Do you want to save the file? (enter y or yes or 1 OR vice versa) ");
                String option_2 = input.next();
                while (!(option_2.equalsIgnoreCase("y") || option_2.equalsIgnoreCase("yes") || option_2.equalsIgnoreCase("n") || option_2.equalsIgnoreCase("no") || option_2.equalsIgnoreCase("0") || option_2.equalsIgnoreCase("1"))){
                    System.err.println("Invalid input!");
                    System.out.print("Please reenter: ");
                    option_2 = input.next();
                }
                if(option_2.equalsIgnoreCase("y") || option_2.equalsIgnoreCase("yes") || option_2.equalsIgnoreCase("1")){
                    String saveFile = filePath+"Save_Data.txt";
                    readToFile(graph, saveFile);
                }
            }else if(option==2){
                Stopwatch stopwatch_3 = new Stopwatch();
                if(!(graph.length==0)) {
                    System.out.println("graph"+Arrays.deepToString(graph));
                }else {
                    System.err.println("Graph doesn't exist!");
                }
                System.out.print("Starting node: ");
                int startingNode = getInteger(input);

                System.out.print("Ending node: ");
                int endingNode = getInteger(input);

                System.out.print("Enter new capacity: ");
                int newCapacity = getInteger(input);

                graph [startingNode] [endingNode] = newCapacity;
                System.out.println("graph"+Arrays.deepToString(graph));
                source = generalData.get(0);
                System.out.println("Source: "+source);
                sink = generalData.get(1);
                System.out.println("Sink: "+sink);
                MaximumFlow m_3 = new MaximumFlow(graph.length);

                System.out.println("The maximum possible flow is " +
                        m_3.maxFlow(graph, source, sink));
                System.out.println("The time elapsed: " + stopwatch_3.elapsedTime());
                System.out.print("Do you want to save the file? (enter y or yes or 1 OR vice versa) ");
                String option_2 = input.next();
                while (!(option_2.equalsIgnoreCase("y") || option_2.equalsIgnoreCase("yes") || option_2.equalsIgnoreCase("n") || option_2.equalsIgnoreCase("no") || option_2.equalsIgnoreCase("0") || option_2.equalsIgnoreCase("1"))){
                    System.err.println("Invalid input!");
                    System.out.print("Please reenter: ");
                    option_2 = input.next();
                }
                if(option_2.equalsIgnoreCase("y") || option_2.equalsIgnoreCase("yes") || option_2.equalsIgnoreCase("1")){
                    String saveFile = filePath+"Save_Data.txt";
                    readToFile(graph, saveFile);
                }
            }else if(option==3){
                System.out.println("<< The graph >>");
                if(!(graph.length==0)) {
                    System.out.println(Arrays.deepToString(graph));
                }else {
                    System.err.println("Graph doesn't exist!");
                }
            }else {
                System.out.println("<< Program quiting >>");
                System.exit(0);
            }
            System.out.println("Select option: ");
            System.out.println("   1) Delete a link and get the maximum flow");
            System.out.println("   2) Modify the capacity of any link and get the maximum flow");
            System.out.println("   3) Print the graph");
            System.out.println("   4) Exit");
            System.out.print("Option: ");
            option = getInteger(input);
        }

        input.close();
        data.close();
    }

    private static int getInteger(Scanner input){
        while (!input.hasNextInt()){
            System.err.println("Invalid input!");
            System.out.print("Please reenter: ");
            input.next();
        }
        return input.nextInt();
    }

    private static int[][] matrix(String filename) throws Exception {
        int[][] matrix = {{1}, {2}};

        File inFile = new File(filename);
        Scanner in = new Scanner(inFile);

        int intLength = 0;
        String[] length = in.nextLine().trim().split("\\s+");
        for (int i = 0; i < length.length; i++) {
            intLength++;
        }

        in.close();

        matrix = new int[intLength][intLength];
        in = new Scanner(inFile);

        int lineCount = 0;
        while (in.hasNextLine()) {
            String[] currentLine = in.nextLine().trim().split("\\s+");
            for (int i = 0; i < currentLine.length; i++) {
                matrix[lineCount][i] = Integer.parseInt(currentLine[i]);
            }
            lineCount++;
        }
        return matrix;
    }

    private static void readToFile(int[][] graph, String filename){
        try (
            PrintStream output = new PrintStream(new File(filename));) {
            for (int i = 0; i < graph.length; i++) {
                String s= "";
                for (int j = 0; j < graph[i].length; j++) {
                    if(graph[i][j]>=0 && graph[i][j]<10){
                        s+= " " + graph[i][j] + " ";
                    }else {
                        s += "" + graph[i][j] + " ";
                    }
                }
                output.println(s);
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }


}
