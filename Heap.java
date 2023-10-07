public class MyHeap {
    private Integer[] heap;
    private int size;
    private int capacity;

    public MyHeap() throws Exception {
        this(10);
    }

    public MyHeap(int capacity) throws Exception{
        if(capacity<0)
            throw new Exception("IndexOutOfBounds");
        this.capacity = capacity;
        heap = new Integer[capacity];
    }


    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int parent(int i){
        return (i-1)/2;
    }

    public int kthChild(int i,int k){

        return 2*i + k;
    }

    public void insert(Integer element){
        heap[size++] = element;
        heapifyUp(size-1);
    }

    public void remove(int index) throws Exception {
        if (isEmpty())
            throw new Exception("IndexOutOfBounds");
        heap[index] = heap[size-1];
        size--;
        heapifyDown(index);
    }

    public void heapifyUp(int index){
        int temp = heap[index];
        while(index>0 && temp > heap[parent(index)]){
            int temp1 = heap[parent(index)];
            int temp2 = heap[index];
            heap[parent(index)] = temp2;
            heap[index] = temp1;
            index = parent(index);
        }
        heap[index] = temp;
    }

    public void heapifyDown(int index) throws Exception {
        int child;
        int temp = heap[index];
        while(kthChild(index, 1) < size){
            child = maxChild(index);
            if(temp < heap[child]){
                heap[index] = heap[child];
            }
            else
                break;
            index = child;
        }
        heap[index] = temp;
    }

    public int maxChild(int i) throws Exception {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
        if (heap[leftChild] > heap[rightChild])
            return leftChild;
        else
            return rightChild;
    }

    public Integer max() throws Exception {
        if(isEmpty())
            throw new Exception("IndexOutOfBounds");
        return heap[0];
    }

    public Integer min() throws Exception {
        if(isEmpty())
            throw new Exception("IndexOutOBounds");
        return heap[size-1];
    }

    public void printHeap(){
        for(int i=0;i<size;i++){
            System.out.print(heap[i] + " ");
        }
    }
}
