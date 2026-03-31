class PalindromeNumber{
  public static void main(String args[]){
    
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    System.out.println(isPalindrome(num));
  }
}


    public boolean isPalindrome(int x) {
       int num=x;
       int res=0;
       while(num>0){
           int r=num%10;
           res=r+(res*10);
           num/=10;
       } 
       if(x<0){
           return false;
       }
       else if(x==res){
           return true;
       }
       return false;
    }
