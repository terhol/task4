/**
 * @author Tereza Holm
 */
public class WorkerImpl implements Worker  {
    private Table table;

    public WorkerImpl (Table table) {
        this.table = table;
    }

    @Override
    public boolean addWorkItem(WorkItem item) {
        table.push(item);
        return true;
    }

    @Override
    public boolean work() {
        table.pop();
        return true;
    }

    @Override
    public boolean deadlineWork(WorkItem item) {
        try {
            for (int i = table.getTop(); i > table.getItemPosition(item); i-- ) {
                table.pop();
            }
        }
        catch (UnknownItemException e) {
            return false;
        }

        return true;
    }
}
