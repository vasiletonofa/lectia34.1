import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Service {
//    private static AtomicInteger counter = new AtomicInteger(0);
    private static Integer counter = 0;


    static List<Integer> list = new ArrayList<>();



    public void increment() {
        synchronized(this) {  // Thread1
//          counter = new AtomicInteger(counter.getAndIncrement()); // Thread1
          System.out.println(counter++); // Thread1
        }

//        System.out.println("sdsd");
    }


    // Thread1(counter = 10), Thread2(counter = 15)
    // counter = 10 + 1;
    // counter = 15 + 1;


    public void printList() {
        synchronized (list) {
            for (int i = 0; i < 3; i++) {
                list.add(i);
            }

            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }

            list.clear();

            System.out.println();
        }
    }



}
