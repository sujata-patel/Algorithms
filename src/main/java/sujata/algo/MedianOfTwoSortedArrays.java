package sujata.algo;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int []a = {1};
        int []b = {};
        float res = median(a, b);
        System.out.println(res);
    }

    private static float median(int[] a, int[] b) {
        //size =8 ...4
        //size =9 ...4 and 5
        int size = a.length + b.length;
        if(size == 1){
            return a.length != 0 ? a[0] : b[0];
        }
        int i=0, j=0;
        int prevMedian=0, median=0;
        while(i+j <= size/2){
            prevMedian = median;
            if(i >= a.length){
                median = b[j++];
            }else if(j >= b.length){
                median = a[i++];
            }else {
                if(a[i] > b[j]){
                    median = b[j++];
                }else{
                    median = a[i++];
                }
            }
        }

        if(size % 2 == 0 ){
            return ((prevMedian + median)/2f);
        }else{
            return median;
        }
    }
}
