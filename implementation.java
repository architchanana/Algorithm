class MinHeap {
    int[] arr;
    int size;
    int capacity;
    public MinHeap(int c) {
        arr = new int[c];
        capacity = c;
        size = 0;
    }
    int left(int i) {
        return 2 * i + 1;
    }
    int right(int i) {
        return 2 * i + 2;
    }
    int parent(int i) {
        return (i - 1) / 2;
    }
    public void insert(int x){
        if(size==capacity){
            return;
        }
        size++;
        arr[size-1]=x;
        for(int i=size-1;i!=0&&arr[parent(i)]>arr[i];){
            int temp=arr[parent(i)];
            arr[parent(i)]=arr[i];
            arr[i]=temp;
            i=parent(i);
        }
    }

    public void MinHeapify(int i){
        int lt=left(i);
        int rt=right(i);
        int smallest=i;
        if(lt<size&& arr[lt]<arr[smallest]){
            smallest=lt;
        }
        if(rt<size&& arr[rt]<arr[smallest]){
            smallest=rt;
        }
        if(smallest!=i){
            int temp=arr[smallest];
            arr[smallest]=arr[i];
            arr[i]=temp;
            MinHeapify(smallest);
        }
    }
    public void MinHeapify_while(int i){
        while(left(i)<size&& right(i)<size && (arr[i]>arr[left(i)]||arr[i]>arr[right(i)])){
            int t=i;
            if(arr[t]>arr[left(i)]){
                t=left(i);
            }
            if(arr[t]>arr[right(i)]){
                t=right(i);
            }
            int temp=arr[t];
            arr[t]=arr[i];
            arr[i]=temp;
            i=t;
        }
    }
    public int extractMin(){
        if(size==0){
            return Integer.MAX_VALUE;
        }
        if(size==1){
            size--;
            return arr[0];
        }
        int temp=arr[size-1];
        arr[size-1]=arr[0];
        arr[0]=temp;
        size--;
        MinHeapify(0);
        return arr[size];
    }
    public void decreaseKey(int i,int x){
        arr[i]=x;
        while(arr[parent(i)]>arr[i]&&i!=0){
            int temp=arr[parent(i)];
            arr[parent(i)]=arr[i];
            arr[i]=temp;
            i=parent(i);
        }
    }
    public void delete(int i){
        decreaseKey(3,Integer.MIN_VALUE);
        extractMin();
    }
    public void delete_one_more(int i){
        if(size==0){
            return;
        }
        if(size==1){
            size--;
            return;
        }
        arr[i]=Integer.MAX_VALUE;
        MinHeapify(i);
        size--;
    }
    public void delete_my_way(int i){
        if(size==0){
            return;
        }
        if(size==1){
            size--;
            return;
        }
        int temp=arr[i];
        arr[i]=arr[size-1];
        arr[size-1]=temp;
        size--;
        MinHeapify(i);
    }
}
public class implementation {
    public static void main(String[] args) {
        MinHeap h=new MinHeap(11);
        h.insert(3);
        h.insert(2);
        h.insert(15);
        h.insert(20);
        System.out.println(h.extractMin());
        for(int i=0;i< h.size;i++){
            System.out.print(h.arr[i]+" ");
        }
        h.decreaseKey(2, 1);
        System.out.println();
        for(int i=0;i< h.size;i++){
            System.out.print(h.arr[i]+" ");
        }
        h.delete(0);
        System.out.println();
        for(int i=0;i< h.size;i++){
            System.out.print(h.arr[i]+" ");
        }

    }
}
