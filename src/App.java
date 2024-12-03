public class App {
    public static void main(String[] args) throws Exception {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.create(7);// crear lista
        // agregar elementos al inicio , despues, antes y al final
        list.add(5);
        list.add(3);
        list.add(2);
        list.add(1);
        list.addBefore(5, 4);
        list.addAfter(5, 6);
        list.addLast(8);

        // eliminar elemento al inicio, al final, antes de, despues de y por informacion
        System.out.println(list.remove());
        System.out.println(list.removeLast());
        System.out.println(list.removeBefore(5));
        System.out.println(list.removeAfter(5));
        System.out.println(list.removeByValue(5));

        System.out.println(list.getFirst());
        System.out.println(list.get(1));
        System.out.println(list.getLast());
        System.out.println(list.getByData(5));

        DoubleLinkedList<Pokemon> list2 = new DoubleLinkedList<>();
        list2.create(new Pokemon("pichu", "electrico", 5));
        list2.add(new Pokemon("pikachu", "electrico", 15));
        list2.add(new Pokemon("raichu", "electrico", 30));

        System.out.println(list2.getByData(p -> p.getName().equals("raichu")));

        System.out.println("================================================");
        System.out.println(String.format("%s size: %d", list.toString(), list.size()));
        System.out.println(String.format("%s size: %d", list2.toString(), list2.size()));
    }
}
