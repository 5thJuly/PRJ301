public class test {

    public int[] GetSumArray(int ar[]) {
        int[] result = new int[ar.length];
        int sum;
        int digit;
        for (int i = 0; i < ar.length; i++) {
            sum = 0;
            digit = ar[i] % 2 ;
            System.out.println(digit);
            for(j = 0; j <= i; j++) {
                if (ar[j] % 2 = digit) {
                    sum += ar[j];
                }
            }
            result[j] = sum;
        }
        return result;
    }
}