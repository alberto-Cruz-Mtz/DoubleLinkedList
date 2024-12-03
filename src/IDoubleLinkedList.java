import java.util.function.Predicate;

/**
 * Interfaz con todas las operaciones de una lista doblemente enlazada
 *
 * @param <T> tipo de los elementos a contener en la lista
 * @author Jose Alberto Cruz Martinez
 */
public interface IDoubleLinkedList<T> {

    /**
     * Inicializa la lista con el elemento especificado
     *
     * @param data elemento a ser contenido en la lista
     */
    void create(T data);

    /**
     * Agrega un elemento al inicio de la lista
     *
     * @param data elemento a ser contenido en la lista
     */
    void add(T data);

    /**
     * Agrega un elemento antes del elemento especificado en la lista
     *
     * @param target elemento antes del cual se va a agregar
     * @param data   elemento a ser contenido en la lista
     */
    void addBefore(T target, T data);

    /**
     * Agrega un elemento despues del elemento especificado en la lista
     *
     * @param target elemento despues del cual se va a agregar
     * @param data   elemento a ser contenido en la lista
     */
    void addAfter(T target, T data);

    /**
     * Agrega un elemento al final de la lista
     *
     * @param data elemento a ser contenido en la lista
     */
    void addLast(T data);

    /**
     * Elimina el elemento al inicio de la lista
     *
     * @return true si se elimino con exito, false de lo contrario
     */
    boolean remove();

    /**
     * Elimina el elemento al final de la lista
     *
     * @return true si se elimino con exito, false de lo contrario
     */
    boolean removeLast();

    /**
     * Elimina el elemento antes del elemento especificado en la lista
     *
     * @param target elemento antes del cual se va a eliminar
     * @return true si se elimino con exito, false de lo contrario
     */
    boolean removeBefore(T target);

    /**
     * Elimina el elemento despues del elemento especificado en la lista
     *
     * @param target elemento despues del cual se va a eliminar
     * @return true si se elimino con exito, false de lo contrario
     */
    boolean removeAfter(T target);

    /**
     * Elimina el elemento que coincide con el valor especificado en la lista
     *
     * @param target valor a ser buscado en la lista
     * @return true si se elimino con exito, false de lo contrario
     */
    boolean removeByValue(T target);

    /**
     * Devuelve el elemento que se encuentra en la posicion especificada en la lista
     *
     * @param index posicion del elemento a ser devuelto
     * @return elemento en la posicion especificada, null si no existe
     */
    T get(int index);

    /**
     * Devuelve el primer elemento de la lista
     *
     * @return primer elemento de la lista, null si no existe
     */
    T getFirst();

    /**
     * Devuelve el ultimo elemento de la lista
     *
     * @return ultimo elemento de la lista, null si no existe
     */
    T getLast();

    /**
     * Devuelve el primer elemento que coincide con el valor especificado en la
     * lista
     *
     * @param data valor a ser buscado en la lista
     * @return primer elemento que coincide con el valor especificado, null si no
     * existe
     */
    T getByData(T data);

    /**
     * Devuelve el primer elemento que coincide con la condicion especificada en la
     * lista
     *
     * @param condition condicion a ser evaluada en la lista
     * @return primer elemento que coincide con la condicion especificada, null si
     * no existe
     */
    T getByData(Predicate<T> condition);
}
