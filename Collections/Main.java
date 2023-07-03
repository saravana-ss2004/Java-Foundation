public class Main {
   public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(5);
        list.insert(9);
        list.insert(23);

        list.insertAtPos(2, 34);

        list.update(1,4);

        list.deleteAt(0);

        list.show();

   }
}
