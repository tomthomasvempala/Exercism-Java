class PrimeCalculator {
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number/2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    int nth(int nth) {
        int n = 1;
        int num = 3;
        if(nth==1){
            return 2;
        }
        while(true){
            if(isPrime(num)){
                n++;
            }
            if(n==nth){
                return(num);
            }
            num++;
        }
    }

}
