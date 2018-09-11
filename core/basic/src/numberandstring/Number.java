package numberandstring;

import java.math.BigDecimal;
import java.util.Arrays;

public class Number {
    public void convertToString(){
        int i = 5;

        String str = String.valueOf(i);

        String str2 = Integer.toString(i);

        Integer it = i;

        String str3 =it.toString();
        System.out.println(str);
        System.out.println(str2);
        System.out.println(str3);
    }

    public void stringToInt(){
        String str = "99";
        int i = Integer.parseInt(str);
        System.out.println(i);
    }

    void test(){
        String fs = Float.toString(3.14f);
        System.out.println(fs);
        Float f = Float.parseFloat(fs);
        System.out.println(f);
        Float t = 0f;
        try {
            t = Float.parseFloat("3.1a4");
        }
        catch(Exception ex){
            System.out.println(ex +  Arrays.toString(ex.getStackTrace()) );
        }
        System.out.println(t);

    }

    void calNumber(){
        double n = Integer.MAX_VALUE;
        double e  = Math.pow((1+1.0/n),n);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(e);
        System.out.println(Math.E);
    }

    void calPrimeNumber(){
        int count =0;
        for(int i=0;i<1000;i++){
            if(isPrime(i)){
                count++;
            }
        }
        System.out.println(count);
    }

    private boolean isPrime(int number){
        if(number<=1) {return false;}
        if(number ==2||number==3){
            return true;
        }
        if(number%6!=1&&number%6!=5){
            return false;
        }
        int temp = (int)Math.sqrt(number);
        for(int i=5;i<=temp;i+=6){
            if(number % i==0 || number %(i+2) ==0){
                return false;
            }
        }
        return true;
    }

    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] notPrimes = new boolean[n];
        for (int i = 2; i * i < n; i++) {

            if (notPrimes[i]) continue;
            for (int j = i; j * i < n; j++)
                notPrimes[i * j] = true;
        }
        int ans = 0;
        for (int i = 2; i < n; i++)
            if (!notPrimes[i]) ans++;
        return ans;
    }
}
