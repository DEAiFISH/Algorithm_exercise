public class BinaryIndexTree {
    private final int N = 16;
    private int[] b;//从1开始

    public BinaryIndexTree() {
        this.b = new int[N + 1];
    }

    public static void main(String[] args) {
        BinaryIndexTree BIT = new BinaryIndexTree();
        for (int i = 1;i < BIT.N + 1;i++){
            BIT.add(i,i);
        }

        System.out.println(BIT.query(1,9));
    }
    private int lowBit(int x){
        return x & (-x);
    }

    /**
     * 单点修改
     * @param p
     * @param x
     */
    private void add(int p ,int x){
        while (p < N){
            b[p] += x;
            p += lowBit(p);
        }
    }

    /**
     * 单点查询
     * @param p
     * @return
     */
    private int count(int p){
        int result = 0;
        while(p > 0){
            result += b[p];
            p -= lowBit(p);
        }
        return result;
    }

    /**
     * 区间查询
     * @param n
     * @param m
     * @return
     */
    private int query(int n,int m){
        return count(m) - count(n - 1);
    }
}
