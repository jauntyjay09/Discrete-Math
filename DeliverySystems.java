

import java.util.*;

 class DeliverySystems
{
    public static void tsp(int adjacencyMatrix[][])
    {
        int numberOfNodes = adjacencyMatrix[1].length - 1; // Calculating from the input , the numbe of cities to visit
        Stack<Integer> stack = new Stack<Integer>();
        int[] visited = new int[numberOfNodes + 1]; // Keeping a track of the visited Cities
        visited[1] = 1; // Starting from the city 1 , so it is marked as visited
        stack.push(1); //Storing city 1 as the city visited
        int element, dst = 0, i; 
        int min = Integer.MAX_VALUE; // To store the minimum distance
        boolean minFlag = false; //Flag to check if minimum
        System.out.print(1 + "-->");
        while (!stack.isEmpty())
        {
            element = stack.peek(); // Checking the last city we visited
            i = 1; 
            min = Integer.MAX_VALUE;
            while (i <= numberOfNodes) //To not loop through the same process again
            {
                if (adjacencyMatrix[element][i] > 1 && visited[i] == 0) // Checking if the path between element and i exists and makes sure that it is not visited
                {
                    if (min > adjacencyMatrix[element][i]) // Comparing with the minimum value
                    {
                        min = adjacencyMatrix[element][i];
                        dst = i; //The destination from the element
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag)
            {
                visited[dst] = 1;
                stack.push(dst);// Pushes destination city to the stack to recurse through those connecting cities
                System.out.print(dst + "-->");
                minFlag = false;
                continue;
            }
            stack.pop();
        }
    }
 
    public static void main(String args[])
    {
        int number_of_nodes = 3;
        int adjacency_matrix[][] = {{0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0, 2451, 713, 1018, 1631, 1374, 2408, 213, 2571, 875, 1420, 2145, 1972},
                {0,2451, 0, 1745, 1524, 831, 1240, 959, 2596, 403, 1589, 1374, 357, 579},
                {0,713, 1745, 0, 355, 920, 803, 1737, 851, 1858, 262, 940, 1453, 1260},
                {0,1018, 1524, 355, 0, 700, 862, 1395, 1123, 1584, 466, 1056, 1280, 987},
                {0,1631, 831, 920, 700, 0, 663, 1021, 1769, 949, 796, 879, 586, 371},
                {0,1374, 1240, 803, 862, 663, 0, 1681, 1551, 1765, 547, 225, 887, 999},
                {0,2408, 959, 1737, 1395, 1021, 1681, 0, 2493, 678, 1724, 1891, 1114, 701},
                {0,213, 2596, 851, 1123, 1769, 1551, 2493, 0, 2699, 1038, 1605, 2300, 2099},
                {0,2571, 403, 1858, 1584, 949, 1765, 678, 2699, 0, 1744, 1645, 653, 600},
                {0,875, 1589, 262, 466, 796, 547, 1724, 1038, 1744, 0, 679, 1272, 1162},
                {0,1420, 1374, 940, 1056, 879, 225, 1891, 1605, 1645, 679, 0, 1017, 1200},
                {0,2145, 357, 1453, 1280, 586, 887, 1114, 2300, 653, 1272, 1017, 0, 504},
                {0,1972, 579, 1260, 987, 371, 999, 701, 2099, 600, 1162, 1200, 504, 0}};
        System.out.println("the citys are visited as follows");
        tsp(adjacency_matrix);
        System.out.print(1);
    }
}
