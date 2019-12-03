<<<<<<< HEAD
package ua.procamp;

public class Node<T> {
    T element;
    Node<T> next;

    Node(T element) {

        this.element = element;
    }

    static <T> Node<T> valueOf(T element) {

        return new Node<>(element);
    }
=======
package ua.procamp;

public class Node<T> {
    T element;
    Node<T> next;

    Node(T element) {

        this.element = element;
    }

    static <T> Node<T> valueOf(T element) {

        return new Node<>(element);
    }
>>>>>>> 5laba
}