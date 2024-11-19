import java.util.Arrays;

public class dw {
    public static int[] adjustDates(int[] dates) {
        int[] arr = new int[dates.length];
        System.arraycopy(dates, 0, arr, 0, dates.length);
        if(arr[0]> 2011  && arr[0] < 1000) {
            transomformToZero(arr,0);
        }
        final int j = arr.length;
        int i = 1;
        boolean foundWrongDate  = arr[i] > 2011 && arr[i] < 1000;
        while(i < j) {
        
        if(foundWrongDate) {
            transomformToZero(arr, i);
            break;
        }
        
        arr[i] = proccessDates(arr[i-1],arr[i]);
        
        
        i++;
        }
        return arr;
        }
        
        
        private  static void transomformToZero(int[] dates,int wrongDateIndex) {
           while(wrongDateIndex<dates.length){
            dates[wrongDateIndex] = 0;
            wrongDateIndex++;
           }
        
        }
        
        private static int proccessDates(int d1, int d2) {
            if(d1 <= d2){
                return d2;
            }

                StringBuilder d1s = new StringBuilder(String.valueOf(d1));
                StringBuilder d2s = new StringBuilder(String.valueOf(d2));
                    for(int i = 3;i >= 0;i--) {
                    char temp = d1s.charAt(i);
                    if(Integer.valueOf(temp) > Integer.valueOf(d2s.charAt(i))) {
                     d2s.setCharAt(i, temp);
                    }
            }
            int finalSol = Integer.valueOf(d2s.toString());
            return finalSol == d1 && finalSol+1<=2011?finalSol+1:finalSol;
            }
    public static void main(String[] args) {
           System.out.println(Arrays.toString(adjustDates(new int[]{1495, 1309, 1240})));
    }
}