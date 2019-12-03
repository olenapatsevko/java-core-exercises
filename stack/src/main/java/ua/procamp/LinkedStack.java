package ua.procamp;


import ua.procamp.exception.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {

	private Node<T> head;
	private int size = 0;
	@Override
	public void push(T element) {
		Node<T> temp = Node.valueOf(element);
		if (head!=null){
				temp.next = head;

		}
		head = temp;
		size++;
	}

	@Override
	public T pop() {
		if(head==null){
			throw  new EmptyStackException();
		}else{
			Node <T> temp = head;
			this.head = this.head.next;
			size--;
			return temp.element;
		}

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head==null;
	}
}
