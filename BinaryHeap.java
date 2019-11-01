public class BinaryHeap {
    protected int[] data = new int[10];
    protected int size = 0;

    public void add(int priority){
        if(size+1 > data.length){
            grow_array();
        }
        data[size++] = priority;
        int child = size-1;
        int parent = (child-1)/2;
        while(parent >= 0 && data[parent] > data[child]){
            swap(data, parent, child);
            child = parent;
            parent = (child-1)/2;
        }
    }

    public int remove() {
        int temp = data[0];
        data[0] = data[--size]; // takes the value at the end of the heap and places it at the top of the heap
        siftdown(0);
        return temp;
    }

    private void siftdown(int parent){
        int child = parent*2 + 1;
        if(child < size && child+1 < size && data[child+1] < data[child]){
            child = child+1;
        }
        if(child < size && data[parent] > data[child]){
            swap(data, child, parent);
            siftdown(child);
        }
    }

    private void swap(int[] a, int index1, int index2){
        int tempValue = a[index1];
        a[index1] = a[index2];
        a[index2] = tempValue;
    }

    private void grow_array(){
        int [] newArr = new int[data.length*2];
        System.arraycopy(data, 0, newArr, 0 , data.length);
        data = newArr;
        // grow it
    }

}
