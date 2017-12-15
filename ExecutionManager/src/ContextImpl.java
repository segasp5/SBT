/**
 * Created by user6 on 15.12.2017.
 */
public class ContextImpl implements Context {

    public ContextImpl(Runnable callback, Runnable... tasks) {
        for (Runnable task : tasks) {
            new Thread(task).start();
        }
    }

    @Override
    public int getCompletedTaskCount() {
        return 0;
    }

    @Override
    public int getFailedTaskCount() {
        return 0;
    }

    @Override
    public int getInterruptedTaskCount() {
        return 0;
    }

    @Override
    public void interrupt() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
