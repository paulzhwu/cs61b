/** Double entry queue implemented using Array
 *
 */
public class ArrayDeque <T>{

    private T[] array;
    private int size;
    private int start;
    private int end;
    private int capacity;
    /** Constructor of LinkedListDeque. Initialize local variables.
     *
     */
    public ArrayDeque(){
        capacity = 10;
        array = (T[]) new Object[capacity];
        size = 0;
        start = capacity/2;
        end = capacity/2;

    }

    private void resize(){
        int newCapacity = capacity;
        if (size < capacity/2) {
            newCapacity = newCapacity - newCapacity/2;
        }
        else {
            newCapacity += newCapacity/2;
        }

        int newStart = newCapacity/2 - size/2-1;
        int newEnd = newStart + size+1;
        if (size == 0){
            newEnd --;
        }
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array,start+1,newArray,newStart+1,size);
        array = newArray;
        start = newStart;
        end = newEnd;
        capacity = newCapacity;
    }

    /** Add new item in front of the Deque.
     *
     * @param item new item
     */
    public void addFirst(T item){
        if (start == -1) {
            resize();
        }
        array[start] = item;
        start --;
        if (size == 0) {
            end ++;
        }
        size ++;
    }

    /** Add new item at the end of the Deque.
     *
     * @param item new item
     */
    public void addLast(T item){
        if (end == capacity) {
            resize();
        }
        array[end] = item;
        end ++;
        if (size == 0) {
            start --;
        }
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
        if (size == 0) {
            return null;
        }
        T result = array[start+1];
        start ++;
        size --;
        if (size < capacity/2 && capacity>10){
            resize();
        }
        return result;
    }

    /** Remove the last item from the Deque.
     *
     * @return the last item.
     */
    public T removeLast(){
        if (size == 0) {
            return null;
        }
        T result = array[end-1];
        end --;
        size --;
        if (size < capacity/2 && capacity>10){
            resize();
        }
        return result;
    }

    /** Print the Deque from first to last;
     *
     */
    public void printDeque(){
        for(int i = start+1; i < end; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    /** Get the index-th item in the Deque
     *
     * @param index index of the desired item.
     * @return the index-th item.
     */
    public T get(int index){
        if (index >= size) {
            return null;
        }
        return array[start+1+index];
    }

}
