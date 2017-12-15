/**
 * Created by user6 on 15.12.2017.
 */
public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}
