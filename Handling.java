class  Handling{
    public static void main(String[] args) {
        try{
            int a=10;
            int b=0;
            int div=a/b;
            System.out.println(div);
        }
        catch(ArithmeticException e){
            System.out.println("Chusko ra puka ");
        }
    }
}