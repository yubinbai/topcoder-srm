import java.util.*;
class PrimeFactors {
    public static List<Integer> primeFactors(int numbers) {
        int n = numbers;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }

    public static void main(String[] args) {
        System.out.println("Primefactors of 44");
        for (Integer integer : primeFactors(44)) {
            System.out.println(integer);
        }
        System.out.println("Primefactors of 3");
        for (Integer integer : primeFactors(3)) {
            System.out.println(integer);
        }
        System.out.println("Primefactors of 577007436");
        for (Integer integer : primeFactors(577007436)) {
            System.out.println(integer);
        }
    }
}