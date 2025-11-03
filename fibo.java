class fibo{
    public static void main(String[] args){
        int prev1=0, prev2=1, temp;
        for (int m=0;m<18;m++){
            temp=prev1+prev2;
            System.out.println(temp);
            prev1=prev2;
            prev2=temp;
        }
    }
}