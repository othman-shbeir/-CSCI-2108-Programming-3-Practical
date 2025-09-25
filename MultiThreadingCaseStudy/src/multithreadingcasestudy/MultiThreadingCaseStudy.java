package multithreadingcasestudy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadingCaseStudy {

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();

//        Thread t1 = new Thread(new FileDownloader("f1.pdf"));
//        Thread t2 = new Thread(new FileDownloader("f2.pdf"));
//        Thread t3 = new Thread(new FileDownloader("f3.pdf"));
//        t1.start();
//        t2.start();
//        t3.start();
//
//        try {
//            t1.join();
//            t2.join();
//            t3.join();
//        } catch (InterruptedException ex) {
//            System.getLogger(MultiThreadingCaseStudy.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
//        }
        ExecutorService executor = Executors.newFixedThreadPool(4);

        FileDownloader f1 = new FileDownloader("f1.pdf");
        FileDownloader f2 = new FileDownloader("f2.pdf");
        FileDownloader f3 = new FileDownloader("f3.pdf");
        FileDownloader f4 = new FileDownloader("f4.pdf");
        FileDownloader f5 = new FileDownloader("f5.pdf");
        FileDownloader f6 = new FileDownloader("f6.pdf");
        FileDownloader f7 = new FileDownloader("f7.pdf");

//        Submit the tasks for the executor
        executor.submit(f1);
        executor.submit(f2);
        executor.submit(f3);
        executor.submit(f4);
        executor.submit(f5);
        executor.submit(f6);
        executor.submit(f7);
        
        System.out.println("All tasks are submitted...");
        
        executor.shutdown();
        
        Long end = System.currentTimeMillis();
        System.out.println("Total execution time: " + (end - start) + "ms");

    }

}
