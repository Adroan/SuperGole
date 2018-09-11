package linear.queue;

import entities.Product;

public class TestLinkedQueue {
	static LinkedQueue<Product> queue = new LinkedQueue<>(); 
	
	public static void main(String[] args) {
		queue.enqueue(new Product("Camisa", 80d));
		queue.enqueue(new Product("Tênis", 200d));
		queue.enqueue(new Product("Meia", 15d));
		queue.enqueue(new Product("Calça", 150d));
		System.out.println(queue.toString());
		System.out.println(queue.dequeue().toString());
		System.out.println(queue.first().toString());
		System.out.println(queue.toString());
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		System.out.println(queue.isEmpty());
	}
}
