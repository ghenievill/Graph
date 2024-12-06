import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DirectedGraph {
    private Map<String, List<String>> adjacencyList;

    public DirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        adjacencyList.putIfAbsent(from, new ArrayList<>());
        adjacencyList.putIfAbsent(to, new ArrayList<>());
        adjacencyList.get(from).add(to);
    }

    public void display() {
        System.out.println("Directed Graph:");
        for (String node : adjacencyList.keySet()) {
            System.out.println(node + " -> " + adjacencyList.get(node));
        }
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Node");
            System.out.println("2. Add Directed Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter node name: ");
                    String nodeName = scanner.nextLine();
                    graph.addNode(nodeName);
                    break;
                case 2:
                    System.out.print("Enter the source node: ");
                    String fromNode = scanner.nextLine();
                    System.out.print("Enter the destination node: ");
                    String toNode = scanner.nextLine();
                    graph.addEdge(fromNode, toNode);
                    break;
                case 3:
                    graph.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
