/**
 * Created by user6 on 15.12.2017.
 */
public class Task implements Runnable {
    Thread t;
    int num;

    public Task(int i) {
        this.num = i;
    }

    @Override
    public void run() {
        for (int i = 1; i<= 100; i++){
            System.out.print(num);
        }
    }
}
