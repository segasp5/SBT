/**
 * Created by user6 on 15.12.2017.
 */
public class ExecuteManagerImpl implements ExecutionManager {

    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        return new ContextImpl(callback, tasks);
    }
}
