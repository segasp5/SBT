/**
 * Created by user6 on 15.12.2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("!!!");
        Task t1 = new Task(1);
        Task t2 = new Task(2);
        Task t3 = new Task(3);

        Runnable callback = new Callback();

        ExecutionManager manager = new ExecuteManagerImpl();

        manager.execute(callback, t1, t2, t3);


    }
}
