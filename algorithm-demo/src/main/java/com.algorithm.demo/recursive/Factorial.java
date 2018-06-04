package java.com.algorithm.demo.recursive;

/**
 * Created by lenovo on 2017/12/3.
 */
public class Factorial {

    public int factorial(int n) {
        if(n==0) {
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }

    public int factorialAge(int n) {
        if(n <= 0) {
            return 0;
        }else if( n == 1) {
            return 10;
        }else {
            return 2+ factorial(n-1);
        }


    }


    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        int num= factorial.factorial(5);
        System.out.println(num);

    }
}
