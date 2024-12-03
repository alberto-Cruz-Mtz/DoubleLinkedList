import java.util.function.Predicate;

public class DoubleLinkedList<T> implements IDoubleLinkedList<T> {

    private Node<T> head;
    private int size;

    public DoubleLinkedList() {
        this.head = null;
    }

    /**
     * @return el tamaño de la lista
     */
    public int size() {
        return size;
    }

    /**
     * @return true si la lista esta vacia, false de lo contrario
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void create(T data) {
        // inicializa la lista con el elemento especificado
        this.head = new Node<>(data);
        this.size++;
    }

    /**
     * Agrega un elemento al inicio de la lista
     * 
     * Si la lista esta vacia, crea una nueva lista con el elemento especificado
     * 
     * @param data elemento a ser contenido en la lista
     */
    @Override
    public void add(T data) {
        // agrega un elemento al inicio de la lista
        // si la lista esta vacia, crea una nueva lista con el elemento especificado
        if (isEmpty()) {
            this.create(data);
            return;
        }

        // crea un nuevo nodo con el elemento especificado
        Node<T> newNode = new Node<>(data);

        // el head actual sera el siguiente del nuevo nodo
        head.setPrev(newNode);
        // el nuevo nodo sera el anterior del head actual
        newNode.setNext(head);
        // el head sera el nuevo nodo
        head = newNode;
        // incrementa el tamaño de la lista
        size++;
    }

    /**
     * Agrega un elemento antes del elemento especificado en la lista
     * 
     * @param target elemento antes del cual se va a agregar
     * @param data   elemento a ser contenido en la lista
     */
    @Override
    public void addBefore(T target, T data) {
        // si la lista esta vacia, crea una nueva lista con el elemento especificado
        if (isEmpty()) {
            this.create(data);
            return;
        }

        // busca el nodo que contiene el elemento especificado
        Node<T> aux = this.head;
        while (aux != null && !aux.getData().equals(target)) {
            aux = aux.getNext();
        }

        // si no se encontro el elemento en la lista, sale del metodo
        if (aux == null)
            return;

        // crea un nuevo nodo con el elemento especificado
        Node<T> newNode = new Node<>(data);

        // el anterior del nodo que contiene el elemento especificado sera el
        // nuevo nodo
        Node<T> prev = aux.getPrev();
        prev.setNext(newNode);

        // el nuevo nodo sera el anterior del nodo que contiene el elemento
        // especificado
        newNode.setPrev(prev);
        newNode.setNext(aux);

        // el nodo que contiene el elemento especificado sera el siguiente del
        // nuevo nodo
        aux.setPrev(newNode);

        // incrementa el tamaño de la lista
        size++;
    }

    /**
     * Agrega un elemento despues del elemento especificado en la lista
     * 
     * Si la lista esta vacia, crea una nueva lista con el elemento especificado
     * 
     * @param target elemento despues del cual se va a agregar
     * @param data   elemento a ser contenido en la lista
     */
    @Override
    public void addAfter(T target, T data) {
        // si la lista esta vacia, crea una nueva lista con el elemento especificado
        if (isEmpty()) {
            this.create(data);
            return;
        }

        // busca el elemento en la lista
        Node<T> aux = this.head;
        while (aux != null && !aux.getData().equals(target)) {
            aux = aux.getNext();
        }

        // si no se encontro el elemento en la lista, sale del metodo
        if (aux == null)
            return;

        // crea un nuevo nodo con el elemento especificado
        Node<T> newNode = new Node<>(data);

        // el siguiente del nuevo nodo sera el nodo que estaba despues del nodo
        // que contiene el elemento especificado
        Node<T> next = aux.getNext();
        next.setPrev(newNode);

        // el nuevo nodo sera el siguiente del nodo que contiene el elemento
        // especificado
        newNode.setNext(next);

        // el anterior del nuevo nodo sera el nodo que contiene el elemento
        // especificado
        newNode.setPrev(aux);
        aux.setNext(newNode);

        // incrementa el tamaño de la lista
        size++;
    }

    /**
     * Agrega un elemento al final de la lista
     * 
     * Si la lista esta vacia, crea una nueva lista con el elemento especificado
     * 
     * @param data elemento a ser contenido en la lista
     */
    @Override
    public void addLast(T data) {
        // Si la lista está vacía, crea una nueva lista con el elemento especificado
        if (isEmpty()) {
            this.create(data);
            return;
        }

        // Busca el último nodo de la lista
        Node<T> aux = this.head;
        int next = 1;
        while (next < size) {
            aux = aux.getNext();
            next++;
        }

        // Crea un nuevo nodo con el elemento especificado
        Node<T> newNode = new Node<>(data);

        // Ajusta las referencias para añadir el nuevo nodo al final de la lista
        aux.setNext(newNode);
        newNode.setPrev(aux);

        // Incrementa el tamaño de la lista
        size++;
    }

    /**
     * Elimina el elemento al inicio de la lista.
     * 
     * Si la lista está vacía, no se realiza ninguna operación.
     * 
     * @return true si se eliminó con éxito, false de lo contrario
     */
    @Override
    public boolean remove() {
        // Verifica si la lista está vacía
        if (isEmpty())
            return false;

        // Guarda la referencia al siguiente nodo del head actual
        Node<T> next = this.head.getNext();

        // Desconecta el nodo head actual
        head = null;

        // Ajusta la referencia del nodo siguiente para que no apunte al nodo eliminado
        next.setPrev(null);

        // Actualiza el head para que apunte al siguiente nodo
        head = next;

        // Decrementa el tamaño de la lista
        size--;

        // Retorna true indicando que la eliminación fue exitosa
        return true;
    }

    /**
     * Elimina el elemento al final de la lista.
     * 
     * Si la lista está vacía, no se realiza ninguna operación.
     * 
     * @return true si se eliminó con éxito, false de lo contrario
     */
    @Override
    public boolean removeLast() {
        // Verifica si la lista está vacía
        if (isEmpty())
            return false;

        // Busca el último nodo de la lista
        Node<T> aux = this.head;
        int next = 1;
        while (next < size) {
            aux = aux.getNext();
            next++;
        }

        // Guarda la referencia al nodo anterior del nodo a eliminar
        Node<T> prev = aux.getPrev();

        // Desconecta el nodo a eliminar
        prev.setNext(null);
        aux.setPrev(null);

        // Elimina el nodo
        aux = null;

        // Decrementa el tamaño de la lista
        size--;

        // Retorna true indicando que la eliminación fue exitosa
        return true;
    }

    /**
     * Elimina el elemento antes del elemento especificado en la lista.
     * 
     * Si el elemento especificado no existe en la lista, no se realiza ninguna
     * operación.
     * 
     * @param target elemento antes del cual se va a eliminar
     * @return true si se elimino con exito, false de lo contrario
     */
    @Override
    public boolean removeBefore(T target) {
        // Verifica si la lista está vacía
        if (isEmpty())
            return false;

        // Busca el nodo que contiene el elemento especificado
        Node<T> aux = this.head;
        Node<T> prev = null;
        while (aux != null && !aux.getData().equals(target)) {
            prev = aux;
            aux = aux.getNext();
        }

        // Si no se encontró el elemento especificado, no se realiza ninguna
        // operación
        if (aux == null)
            return false;

        // Desconecta el nodo anterior del nodo que contiene el elemento
        // especificado
        Node<T> firstPrev = prev.getPrev();
        prev.setPrev(null);
        prev.setNext(null);
        prev = null;

        // Conecta el nodo que contiene el elemento especificado con el nodo
        // anterior
        aux.setPrev(firstPrev);
        firstPrev.setNext(aux);

        // Decrementa el tamaño de la lista
        size--;

        // Retorna true indicando que la eliminación fue exitosa
        return true;
    }

    /**
     * Elimina el elemento después del elemento especificado en la lista.
     * 
     * Si la lista está vacía o el elemento especificado no está presente, no se
     * realiza ninguna operación.
     * 
     * @param target el elemento después del cual se va a eliminar
     * @return true si se eliminó con éxito, false de lo contrario
     */
    @Override
    public boolean removeAfter(T target) {
        if (isEmpty())
            return false;

        // Busca el nodo que contiene el elemento especificado
        Node<T> aux = this.head;
        // Guarda la referencia del nodo siguiente del nodo que contiene el
        // elemento especificado
        Node<T> next = aux.getNext();
        while (aux != null && !aux.getData().equals(target)) {
            aux = aux.getNext();
            next = next.getNext();
        }

        // Si el elemento especificado no está presente en la lista, no se
        // realiza ninguna operación
        if (aux == null || next.getNext() == null)
            return false;

        // Desconecta el nodo que contiene el elemento especificado del nodo
        // siguiente
        Node<T> lastNext = next.getNext();
        aux.setNext(lastNext);
        // Conecta el nodo siguiente con el nodo que contiene el elemento
        // especificado
        lastNext.setPrev(aux);
        // Desconecta el nodo que contiene el elemento especificado del nodo
        // siguiente
        next.setPrev(null);
        next.setNext(null);
        // Elimina la referencia al nodo que se va a eliminar
        next = null;

        // Decrementa el tamaño de la lista
        size--;

        // Retorna true indicando que la eliminación fue exitosa
        return true;
    }

    /**
     * Elimina el elemento que coincide con el valor especificado en la lista
     * 
     * @param target valor a ser buscado en la lista
     * @return true si se elimino con exito, false de lo contrario
     */
    @Override
    public boolean removeByValue(T target) {
        // Verifica si la lista está vacía
        if (isEmpty())
            return false;

        // Busca el nodo que contiene el elemento especificado
        Node<T> aux = this.head;
        while (aux != null && !aux.getData().equals(target)) {
            aux = aux.getNext();
        }

        // Si el elemento no existe en la lista, no se realiza ninguna
        // operación
        if (aux == null && aux.getNext() == null && aux.getPrev() != null)
            return false;

        // Desconecta el nodo que contiene el elemento especificado de la
        // lista
        Node<T> prev = aux.getPrev();
        Node<T> next = aux.getNext();
        aux.setPrev(null);
        aux.setNext(null);
        aux = null;
        // Conecta el nodo anterior con el nodo siguiente
        prev.setNext(next);
        // Conecta el nodo siguiente con el nodo anterior
        next.setPrev(prev);
        // Decrementa el tamaño de la lista
        size--;
        // Retorna true indicando que la eliminación fue exitosa
        return false;
    }

    /**
     * Devuelve el elemento que se encuentra en la posicion especificada en la
     * lista
     * 
     * @param index posicion del elemento a ser devuelto
     * @return elemento en la posicion especificada, null si no existe
     */
    @Override
    public T get(int index) {
        // Verifica si la lista está vacía o si el índice es invalido
        if (isEmpty() || index > size || index < 0)
            return null;

        // Busca el nodo en la posición especificada
        Node<T> aux = this.head;
        int next = 0;
        while (next < index) {
            aux = aux.getNext();
            next++;
        }

        // Retorna el contenido del nodo en la posición especificada
        return aux.getData();
    }

    /**
     * Devuelve el primer elemento de la lista
     * 
     * @return primer elemento de la lista, null si no existe
     */
    @Override
    public T getFirst() {
        // Verifica si la lista está vacía
        if (isEmpty())
            return null;
        // Devuelve el contenido del primer nodo
        return head.getData();
    }

    /**
     * Devuelve el ultimo elemento de la lista
     * 
     * @return ultimo elemento de la lista, null si no existe
     */
    @Override
    public T getLast() {
        // Verifica si la lista está vacía
        if (isEmpty())
            return null;

        // Busca el ultimo nodo de la lista
        Node<T> aux = this.head;
        int next = 1;
        while (next < size) {
            // Avanza al siguiente nodo
            aux = aux.getNext();
            next++;
        }
        // Devuelve el contenido del nodo en la posición especificada
        return aux.getData();
    }

    /**
     * Devuelve el primer elemento que coincide con el valor especificado en la
     * lista
     * 
     * @param data valor a ser buscado en la lista
     * @return primer elemento que coincide con el valor especificado, null si no
     *         existe
     */
    public T getByData(T data) {
        // Busca el primer nodo que coincide con el valor especificado
        Node<T> aux = this.head;
        while (aux != null && !aux.getData().equals(data)) {
            // Avanza al siguiente nodo
            aux = aux.getNext();
        }

        // Si no se encontró el elemento, retorna null
        if (aux == null)
            return null;

        // Retorna el contenido del primer nodo que coincide con el valor especificado
        return aux.getData();
    }

    /**
     * Devuelve el primer elemento que coincide con la condicion especificada en
     * la lista
     * 
     * @param condition condicion a ser evaluada en la lista
     * @return primer elemento que coincide con la condicion especificada, null
     *         si no existe
     */
    @Override
    public T getByData(Predicate<T> condition) {
        // Busca el primer nodo que coincide con la condicion especificada
        Node<T> aux = this.head;
        while (aux != null && !condition.test(aux.getData())) {
            // Avanza al siguiente nodo
            aux = aux.getNext();
        }

        // Si no se encontró el elemento, retorna null
        if (aux == null)
            return null;

        // Retorna el contenido del primer nodo que coincide con la condicion
        // especificada
        return aux.getData();
    }

    /**
     * Devuelve una representación en forma de cadena de la lista.
     * 
     * @return una cadena que representa la lista a partir del nodo head
     */
    @Override
    public String toString() {
        return head.toString();
    }
}
