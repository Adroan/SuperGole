package linear.queue;

/**
 * Esta interface serve de modelo para gerar os métodos
 * @author Vinicius Thome Vieira, Adroan Covari Heinen, Eduardo Woloszyn
 * @since 17/09/2018
 * @version 1.0
 */

public interface Queue<E> {
	int size();
	boolean isEmpty();
	void enqueue(E e);
	E first();
	E dequeue();
}
