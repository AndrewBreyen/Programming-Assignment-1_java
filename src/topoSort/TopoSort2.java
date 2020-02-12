// this version changes how nodes are stored from TopoSort.java
// Nodes are now stored in a Hash Map, with the key being a node, and the value being an ArrayList<Edge>



package topoSort;

 
import java.util.*;
 
public class TopoSort2 {
	Stack<Node> stack;
	ArrayList<Edge> edges = new ArrayList<Edge>();
	HashMap<Node, ArrayList<Edge>> graph = new HashMap<Node, ArrayList<Edge>>();
 
	public TopoSort2() {
		stack=new Stack<>();
	}
	
	static class Edge{
		
	}
	
	static class Node{
		int data;
		boolean visited;
		List<Node> neighbors;
 
		Node(int data)
		{
			this.data=data;
			this.neighbors=new ArrayList<>();
 
		}
		public void addNeighbors(Node neighborNode)
		{
			this.neighbors.add(neighborNode);
		}
		public List<Node> getNeighbors() {
			return neighbors;
		}
		public void setNeighbors(List<Node> neighbors) {
			this.neighbors = neighbors;
		}
		public String toString()
		{
			return ""+data;
		}
	}
 
	// Recursive topological Sort
	public  void topologicalSort(Node node){
		List<Node> neighbors=node.getNeighbors();
		for (int i = 0; i < neighbors.size(); i++) {
			Node n=neighbors.get(i);
			if(n!=null && !n.visited)
			{
				topologicalSort(n);
				n.visited=true;
			}
		}
		stack.push(node);
	}
	
	
	
	
	public static void main(String args[]){
		final long startTime = System.nanoTime();
		TopoSort2 topological = new TopoSort2();
		
//		for(i in arrayOfNodes) {
//			Node i = new Node(i)
//		}
		


 
		System.out.println("Topological Sorting Order:");
		topological.topologicalSort();
		
		// Print contents of stack
		Stack<Node> resultStack=topological.stack;
		final long endTime = System.nanoTime();
		
		while (!resultStack.empty())
			System.out.print("["+resultStack.pop() + "] ");
		int totalTime = (int)endTime-(int)startTime;
		System.out.println("\nExecution Time: " +totalTime+" ms");
	}
 
}
