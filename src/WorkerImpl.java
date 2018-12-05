/**
 * @author Tereza Holm
 */
public class WorkerImpl implements Worker {
    private Table table;

    public WorkerImpl(Table table) {
        this.table = table;
    }

    @Override
    public boolean addWorkItem(WorkItem item) {
        table.push(item);
        return true;
    }

    @Override
    public boolean work() {
        return table.pop() != null;
    }

    @Override
    public boolean deadlineWork(WorkItem item) {
        if (item == null) {
            return false;
        }
        try {
            int position = table.getItemPosition(item);
            for (int i = 1; i < position; i++) {
                table.pop();
            }
            return work();
        } catch (UnknownItemException ex) {
            return false;
        }
    }
}
