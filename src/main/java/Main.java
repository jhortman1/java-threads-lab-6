import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // create an executor
        ExecutorService executor = Executors.newCachedThreadPool();


        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            // submit tasks to your executor
            executor.submit(new PrimeLogger(num));
        }
        executor.shutdown();
        scanner.close();
    }
}

class PrimeLogger implements Runnable {
    private final int num;

    public PrimeLogger(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        // print num if it is prime
        List<Long> nums = new ArrayList<>();
        for (long x = 2; x * x <= num; x ++){
            nums.add(x);
        }
        if(!nums.stream().anyMatch((x) -> num % x == 0)) System.out.printf("%s is prime \n",num);
    }
}