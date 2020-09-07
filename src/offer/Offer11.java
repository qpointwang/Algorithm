package offer;

public class Offer11 {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low<high){
            int m = (low+high)/2;
            if (numbers[m]<numbers[high]){
                high = m;
            }else if (numbers[m]>numbers[high]){
                low=m+1;
            }
            else {
                high--;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        System.out.println(new Offer11().minArray(new int[]{2,2,2,0,1}));
    }
}
