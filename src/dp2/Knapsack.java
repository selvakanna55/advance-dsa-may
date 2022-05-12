package dp2;

public class Knapsack {
    static int f(int ind, int W, int weight[], int value[]) {
        if(ind==0){
            if(weight[0]<=W){
                return  value[0];
            }else return 0;
        }
        int pick = Integer.MIN_VALUE;
        if (weight[ind] <= W)
            pick = value[ind] + f(ind - 1, W - weight[ind], weight, value);
        int notPick = f(ind - 1, W, weight, value);
        return Math.max(pick, notPick);
    }

    public static void main(String[] args) {
        int weight[] = {3, 2, 5};
        int value[] = {30, 40, 60};
        int cap = 6;
        int n = weight.length;
        System.out.println(f(n - 1, cap, weight, value));
    }
}
