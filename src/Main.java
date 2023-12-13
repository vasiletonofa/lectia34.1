import java.util.ArrayList;
import java.util.concurrent.*;

public class Main { // main thread
    public static void main(String[] args) {

        // Sincrona si Asincrona

//        System.out.println("sd"); // thread 1 -> 5 min
//        System.out.println("sd"); // thread 2 -> 5 min
//        System.out.println("sd"); // thread 3 -> 5 main = 5 min
//
//        Thread thread = new Thread(() -> System.out.println("sd")); // main
//        Thread thread2 = new Thread(() -> System.out.println("sd")); // main
//        Thread thread3 = new Thread(() -> System.out.println("sd")); // main
//
//        thread.start(); // main -> Thread 1 .....
//        thread2.start(); // main -> Thread 2 .....
//        thread3.start(); // main -> Thread 3 ..... finisat primul


        // Cpu (Processor) -> 4
        // Core1 -> Thread1 -> timp nelimitat de executie fara schimbare de context
        // Core2 -> Thread2 -> timp nelimitat de executie fara schimbare de context
        // Core3 -> Thread3 -> timp nelimitat de executie fara schimbare de context
        // Core4 -> Thread4 -> timp nelimitat de executie fara schimbare de context


//        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()); // echipa de lucratori
//
//         executorService.execute(() -> System.out.println("fgh")); // Thread 1
//        executorService.execute(() -> System.out.println("fgh")); // Thread 2
//        executorService.execute(() -> System.out.println("fgh")); // Thread 3
//        executorService.execute(() -> System.out.println( "fgh")); // Thread 4
//        executorService.execute(() -> System.out.println("fgh")); // Thread 5
//        executorService.execute(() -> {
//            throw new RuntimeException();
//        });
//
//       Future<Integer> future = executorService.submit( () -> {
//           throw new Exception();
//       });
//
//       try {
//         int a =  future.get(); // main
//       } catch (Exception e) {
//           System.out.println("Eroare");
//       }
      // Error
////       future.cancel(true);
//
//       try {
//           Integer val = future.get(); // main ->  200000
//           System.out.println(val); // 10
//       } catch (Exception e) {
//           System.out.println(e.getMessage());
//       }
//
//        ScheduledExecutorService scheduledExecutorService = null;
//       try {
//           scheduledExecutorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
//           scheduledExecutorService.schedule(() -> System.out.println("Hello World"), 1000, TimeUnit.MILLISECONDS);
//
//           scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("ABC"), 1, 3, TimeUnit.SECONDS);
//
//           scheduledExecutorService.scheduleWithFixedDelay(() -> System.out.println("ABC"), 1, 3, TimeUnit.SECONDS); // timp de executie task + 3sec
//       } finally {
//           scheduledExecutorService.shutdownNow();
//       }
//
//       ExecutorService executorService1 = Executors.newCachedThreadPool(); // 10 threads
//        executorService1.execute(() -> System.out.println());
//        executorService1.execute(() -> System.out.println());
//        executorService1.execute(() -> System.out.println());

        Service service = new Service();

        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

            for (int i = 0; i < 10; i++) {
                executorService.submit(() -> new Service().printList());
                executorService.submit(() -> new Service().printList());
                executorService.submit(() -> new Service().printList());
                executorService.submit(() -> new Service().printList());
                executorService.submit(() -> new Service().printList());
            }

        } finally {
            executorService.shutdown();
        }


        // Main - fir de executie principal



    }
}