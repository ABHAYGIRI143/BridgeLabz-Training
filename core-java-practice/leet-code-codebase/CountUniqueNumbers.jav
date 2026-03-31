class CountUniqueNumbers{
    public static void main(String arggs[]){
          if (n == 0) return 1;

        int count = 10;     
        int uniqueDigits = 9;
        int availableNumbers = 9;

        for (int i = 2; i <= n && availableNumbers > 0; i++) {
            uniqueDigits *= availableNumbers;
            count += uniqueDigits;
            availableNumbers--;
        }

        return count;
    }
}

