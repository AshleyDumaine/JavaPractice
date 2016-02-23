package AdvancedDataStructures;

import java.util.HashMap;

public class Vertex<E> {
	private E data;
	private HashMap<E, Vertex<E>> neighbors;
	
	public Vertex(E data) {
		this.data = data;
		this.neighbors = new HashMap<E, Vertex<E>>();
	}
	
	public HashMap<E, Vertex<E>>neighbors() {
		return this.neighbors;
	}
	
	public E data() {
		return this.data;
	}
	
	public void addNeighbor(Vertex<E> neighbor) {
		this.neighbors.put(neighbor.data(), neighbor);
	}
}
