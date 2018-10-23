/** Double entry queue implemented using Linked List
 *
 */
public class LinkedListDeque <T>{


    /** Node of the Linked List
     *
     */
    class Node <T>{
        public T val;
        public Node next;
        public Node prev;

        /** Constructor of Node with no input param.
         *
         */
        public Node (){
            val = null;
            next = null;
            prev = null;
        }

        /**Constructor of Node with one param.
         *
         * @param val Node value of type T;
         */
        public Node (T val) {
            this.val = val;
            next = null;
            prev = null;
        }
    }


    private Node dummy;
    private int size;

    /** Constructor of LinkedListDeque. Initialize local variables.
     *
     */
    public LinkedListDeque(){
        dummy = new Node();
        dummy.next = dummy;
        dummy.prev = dummy;
        size = 0;
    }


    /** Add new item in front of the Deque.
     *
     * @param item new item
     */
    public void addFirst(T item){
        Node newNode = new Node(item);
        newNode.next = dummy.next;
        newNode.prev = dummy;
        dummy.next.prev = newNode;
        dummy.next = newNode;
        size ++;
    }

    /** Add new item at the end of the Deque.
     *
     * @param item new item
     */
    public void addLast(T item){
        Node newNode = new Node(item);
        newNode.next = dummy;
        newNode.prev = dummy.prev;
        dummy.prev.next = newNode;
        dummy.prev = newNode;
        size ++;
    }

    /** Check if Deque is empty.
     *
     * @return true if Deque is empty else false.
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /** Check the size of the Deque.
     *
     * @return Num of items in the Deque
     */
    public int size(){
        return size;
    }

    /** Remove the first item from the Deque.
     *
     * @return the first item.
     */
    public T removeFirst(){
        if (this.isEmpty()) {
            return null;
        }
        else {
            T result = (T) dummy.next.val;
            size --;
            dummy.next = dummy.next.next;
            dummy.next.prev = dummy;
            return result;
        }
    }

    /** Remove the last item from the Deque.
     *
     * @return the last item.
     */
    public T removeLast(){
        if (this.isEmpty()){
            return null;
        }
        else {
            T result = (T) dummy.prev.val;
            size --;
            dummy.prev = dummy.prev.prev;
            dummy.prev.next = dummy;
            return result;
        }
    }

    /** Print the Deque from first to last;
     *
     */
    public void printDeque(){
        Node itt = dummy.next;
        for (int i=0; i<size; i++) {
            System.out.print(itt.val+" ");
            itt = itt.next;
        }
    }

    /** Get the index-th item in the Deque
     *
     * @param index index of the desired item.
     * @return the index-th item.
     */
    public T get(int index){
        if (index >= size) return null;
        Node itt = dummy.next;
        for (int i=0; i<index;i++) {
            itt = itt.next;
        }
        return (T) itt.val;
    }

    /** Get the index-th item in the Deque using recursion.
     *
     * @param index index of the desired item.
     * @return the index-th item.
     */
    public T getRecursive(int index){
        if (index >= size) return null;
        return (T) getNext(dummy.next,index).val;
    }

    private Node getNext(Node curr, int index) {
        if (index == 0) return curr;
        return getNext(curr.next,index-1);
    }
}


