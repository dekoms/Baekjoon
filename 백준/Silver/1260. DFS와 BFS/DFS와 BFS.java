import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void dfs(int start, int[][] matrix, int[] visited) {
		visited[start] = 1;
		System.out.print(start + " ");

		int vertex = visited.length - 1;
		for (int i = 1; i <= vertex; i++) {
			if (matrix[start][i] == 1 && visited[i] == 0) {
				dfs(i, matrix, visited);
			}
		}

	}

	public static void bfs(int start, int[][] matrix, int[] visited) {		
		Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        visited[start] = 1;

        System.out.print(start + " ");

		int vertex = visited.length - 1;
        while(!queue.isEmpty()) {
            int n = queue.poll();

			// 노드 하나로 연결된 노드 먼저 다 체크 
            for(int i = 1; i <= vertex; i++) {
           		 // 연결된 노드인데 방문하지 않은 경우 
                if(matrix[n][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    System.out.print(i + " ");
                    queue.offer(i);
                }
            }
        } 
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int vertex, edge, start;
		vertex = sc.nextInt();
		edge = sc.nextInt();
		start = sc.nextInt();

		int[][] adjacencyMatrix = new int[vertex + 1][vertex + 1];
		int[] visited;

		int left, right;
		for (int i = 0; i < edge; i++) {
			left = sc.nextInt();
			right = sc.nextInt();
			adjacencyMatrix[left][right] = adjacencyMatrix[right][left] = 1;
		}

		visited = new int[vertex + 1];
		dfs(start, adjacencyMatrix, visited);
		System.out.println();

		visited = new int[vertex + 1];
		bfs(start, adjacencyMatrix, visited);

		sc.close();
		
	}

}
