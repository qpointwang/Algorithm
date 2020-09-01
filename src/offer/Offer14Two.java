package offer;

public class Offer14Two {


    public int cuttingRope(int n) {
        int a = n / 3;
        int b = n % 3;
        if (n <= 3) {
            return n - 1;
        }
        long res = 1;
        int p = 1000000007;
        for (int i = 0; i < a - 1; i++) {
            res = res * 3 % 1000000007;
        }
        if (b == 0) {
            return (int) (res * 3 % p);
        } else if (b == 1) {
            return (int) (res * 4 % p);
        } else {
            return (int) (res * 6 % p);
        }
    }

    public static void main(String[] args) {
        Offer14Two offer14Two = new Offer14Two();
        System.out.println(offer14Two.cuttingRope(1000));
    }
}
