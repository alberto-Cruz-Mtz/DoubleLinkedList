/**
 * Clase para representar un nodo en una lista doblemente enlazada
 *
 * @param <T> tipo de los elementos a contener en la lista
 * @author Jose Alberto Cruz Martinez
 */
public class Node<T> {

    /**
     * Contenido del nodo
     */
    private T data;
    /**
     * Referencia al siguiente nodo de la lista
     */
    private Node<T> next;
    /**
     * Referencia al nodo anterior de la lista
     */
    private Node<T> prev;

    /**
     * Constructor de un nodo con contenido y referencias a siguiente y anterior
     *
     * @param data contenido del nodo
     * @param next siguiente nodo de la lista
     * @param prev nodo anterior de la lista
     */
    public Node(T data, Node<T> next, Node<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    /**
     * Constructor de un nodo con contenido y referencia al siguiente
     *
     * @param data contenido del nodo
     * @param next siguiente nodo de la lista
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Constructor de un nodo con contenido
     *
     * @param data contenido del nodo
     */
    public Node(T data) {
        this.data = data;
    }

    /**
     * Constructor de un nodo vacio
     */
    public Node() {
    }

    /**
     * Devuelve el contenido del nodo
     *
     * @return contenido del nodo
     */
    public T getData() {
        return data;
    }

    /**
     * Modifica el contenido del nodo
     *
     * @param data contenido del nodo
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Devuelve la referencia al siguiente nodo de la lista
     *
     * @return siguiente nodo de la lista
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Modifica la referencia al siguiente nodo de la lista
     *
     * @param next siguiente nodo de la lista
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Devuelve la referencia al nodo anterior de la lista
     *
     * @return nodo anterior de la lista
     */
    public Node<T> getPrev() {
        return prev;
    }

    /**
     * Modifica la referencia al nodo anterior de la lista
     *
     * @param prev nodo anterior de la lista
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    /**
     * Representacion en forma de cadena de la lista
     *
     * @return representacion en forma de cadena de la lista
     */
    @Override
    public String toString() {
        return data + ", -> " + next;
    }
}
