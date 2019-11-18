package ua.procamp;

/**
 * {@link LinkedQueue} implements FIFO {@link Queue}, using singly linked nodes. Nodes are stores in instances of nested
 * class Node. In order to perform operations {@link LinkedQueue#add(Object)} and {@link LinkedQueue#poll()}
 * in a constant time, it keeps to references to the head and tail of the queue.
 *
 * @param <T> a generic parameter
 */
public class LinkedQueue<T> implements Queue<T> {

   private Node<T> tail;
   private Node<T> head;
   private int size;

    /**
     * Adds an element to the end of the queue.
     *
     * @param element the element to add
     */
    public void add(T element) {
        size++;
        Node<T> temp = Node.valueOf(element);
        if (head==null) {

            head = tail = temp;

        } else {
            tail.next = temp;
            tail = temp;
        }

    }



    /**
     * Retrieves and removes queue head.
     *
     * @return an element that was retrieved from the head or null if queue is empty
     */
    public T poll() {

        if(head == null){
            return null;
        }else{
            T temp  = head.element;
           head = head.next;
           size--;
            return temp;
        }


    }

    /**
     * Returns a size of the queue.
     *
     * @return an integer value that is a size of queue
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, returns {@code false} if it's not
     */
    public boolean isEmpty() {
       return head==null && tail==null;
    }

//    private static class Node<T> {
//        T element;
//        Node<T> next;
//
//        Node(T element) {
//
//            this.element = element;
//        }
//
//        static <T> Node<T> valueOf(T element) {
//
//            return new Node<>(element);
//        }
   // }
}
