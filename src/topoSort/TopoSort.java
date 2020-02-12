package topoSort;

 
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
 
public class TopoSort {
	Stack<Node> stack;
 
	public TopoSort() {
		stack=new Stack<>();
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
		TopoSort topological = new TopoSort();
		
//		for(i in arrayOfNodes) {
//			Node i = new Node(i)
//		}
		
		Node node4 = new Node(4);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node6 = new Node(6);
		Node node5 = new Node(5);
		Node node8 = new Node(8);
		Node node7 = new Node(7);
		
 
		node2.addNeighbors(node5);
		node2.addNeighbors(node7);
		node3.addNeighbors(node8);
		node4.addNeighbors(node5);
		node4.addNeighbors(node8);
		node5.addNeighbors(node6);
		node8.addNeighbors(node1);
		node8.addNeighbors(node6);
		node8.addNeighbors(node7);

 
		System.out.println("Topological Sorting Order:");
		topological.topologicalSort(node6);
		
		// Print contents of stack
		Stack<Node> resultStack=topological.stack;
		final long endTime = System.nanoTime();
		
		while (!resultStack.empty())
			System.out.print("["+resultStack.pop() + "] ");
		int totalTime = (int)endTime-(int)startTime;
		System.out.println("\nExecution Time: " +totalTime+" ms");
	}
 
}
