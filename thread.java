
    class Threading_try extends Thread {

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    class Letter implements Runnable {

        public void run() {

            for (char ch = 'A'; ch <= 'P'; ch++) {
                System.out.println(ch);
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    class thread {

        public static void main(String[] args) {
            Threading_try Thread_1 = new Threading_try();
            Thread_1.start();
            Letter Thread_2 = new Letter();
            Thread task2 = new Thread(Thread_2);
            task2.start();
        }
    }
