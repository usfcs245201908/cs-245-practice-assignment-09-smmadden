public class BinaryHeap {
    protected int[] data = new int[10];
    protected int size = 0;

    public void add(int priority){
        // if the next item exceeds the length of the array then we need to grow the array
        if(size+1 > data.length){
            grow_array();
        }
        data[size++] = priority; // adds the item to the array
        // now must check to make sure that the item is in the correct place
        int child = size-1;
        int parent = (child-1)/2;
        // while the parent's data is greater than the child's, the items need to be swapped
        while(parent >= 0 && data[parent] > data[child]){
            swap(data, parent, child);
            // resetting the child and parent values
            child = parent;
            parent = (child-1)/2;
        }
    }

    public int remove() {
        int temp = data[0]; // the item being removed is stored to be returned later
        data[0] = data[--size]; // takes the value at the end of the heap and places it at the top of the heap
        siftdown(0); // make sure that the heap is formatted correctly (parent is less than child)
        return temp;
    }

    private void siftdown(int parent){
        // checks to make sure that the parent value is less than its children
        int child = parent*2 + 1;
        // need to find the lesser child value
        if(child < size && child+1 < size && data[child+1] < data[child]){
            child = child+1;
        }
        // if the child value is less than the parent
        if(child < size && data[parent] > data[child]){
            // then swap the parent and child
            swap(data, child, parent);
            // and check to make sure that the new child value is less than its children using recursion
            siftdown(child);
        }
    }

    private void swap(int[] a, int index1, int index2){
        // swap function for add and remove
        int tempValue = a[index1];
        a[index1] = a[index2];
        a[index2] = tempValue;
    }

    private void grow_array(){
        // grows the array to twice the original size, copying all of the values into the new array
        int [] newArr = new int[data.length*2];
        System.arraycopy(data, 0, newArr, 0 , data.length);
        data = newArr;
        // grow it
    }

}
