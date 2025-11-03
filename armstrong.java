class armstrong {
    public static void main(String[] args) {
        int original_num = 153;
        int dup = original_num;
        int remainder, result = 0;

        while (dup != 0) {
            remainder = dup % 10;
            result += Math.pow(remainder, 3);
            dup /= 10;
        }

        if (result == original_num) {
            System.out.println(original_num + " is an Armstrong number.");
        } else {
            System.out.println(original_num + " is not an Armstrong number.");
        }
    }
}
 