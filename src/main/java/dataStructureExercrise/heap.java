package dataStructureExercrise;// 手写堆排(优先队列)

public class heap {
    private boolean bigRoot;
    private int[] arr = new int[100];
    int size = 0;

    public heap() {}
    public heap(boolean bigRoot) {this.bigRoot = bigRoot;}

    public int pop() {
        int res = arr[0];
        size--;
        arr[0] = arr[size];
        for (int i = 0; 2*i+1 < size;) {  // 注意！这里的判断条件是，没有孩子节点就结束！！
            int son;
            if ((2*i+2) >= size || compare(arr[2*i+1], arr[2*i+2])) {
                son = 2*i+1;
            } else {
                son = 2*i+2;
            }
            if(compare(arr[i], arr[son])) {
                break;
            } else {
                swap(arr, i, son);
                i = son;
            }
        }
        return res;
    }

    public void push(int a) {
        arr[size++] = a;
        for (int i = size-1; i > 0; ){
            if (compare(arr[(i-1) / 2], arr[i])){
                break;
            } else {
                swap(arr, (i-1)/2, i);
                i = (i-1) / 2;
            }
        }
    }

    public int peek() {
        return arr[0];
    }

    private boolean compare(int a, int b) {
        if (this.bigRoot && a > b) return true;
        if (!this.bigRoot && a < b) return true;
        return false;
    }

    private void swap (int[] l, int a, int b) {
        int tmp = l[a];
        l[a] = l[b];
        l[b] = tmp;
    }

    public static void main(String[] args) {
        heap h = new heap(false);
        h.push(1);
        h.push(45);
        h.push(7);
        h.push(834);
        h.push(9);
        h.push(16);
        h.push(2);
        h.push(20);
        h.push(100);

        for (int i = 0; i < 9; i++) {
            System.out.println(h.pop());
        }
    }
}
