package AdvancedDataStructures;

import java.util.HashSet;
import java.util.LinkedList;

public class Graph<E> {
	private Vertex<E> root;
	public Graph() {
		this.root = null;
	}
	
	public void setRoot(Vertex<E> root) {
		this.root = root;
	}
	
	public Vertex<E> root() {
		return this.root;
	}
	
	public LinkedList<E> dfs() {
		HashSet<Vertex<E>> visited = new HashSet<Vertex<E>>();
		return dfs(visited, this.root);
	}
	
	public LinkedList<E> dfs(HashSet<Vertex<E>> visited, Vertex<E> root) {
		LinkedList<E> list = new LinkedList<E>();
		if (!visited.contains(root)) {
			list.add(root.data());
			visited.add(root);
		}
		for (Vertex<E> neighbor : root.neighbors().values()) {
			list.addAll(dfs(visited, neighbor));
		}
		return list;
	}
	
	// test the graph
	public static void main(String args[]) {
		Graph<String> graph = new Graph<String>();
		graph.setRoot(new Vertex<String>("Hello"));
		graph.root().addNeighbor(new Vertex<String>("World"));
		Vertex<String> world = graph.root().neighbors().get("World");
		world.addNeighbor(new Vertex<String>("!!!!"));
		Vertex<String> ex = world.neighbors().get("!!!!");
		graph.setRoot(ex);
		LinkedList<String> entries = graph.dfs();
		for (String entry : entries) {
			System.out.println(entry);
		}
	}
}
