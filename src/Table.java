/**
 * @author Tereza Holm
 */
public class Table implements WorkStack {
    private int top = -1;
    private WorkItem[] stack;

    public Table(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("Table cannot have less than zero items");
        }
        stack = new WorkItem[max];
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    public int getTop() {
        return this.top;
    }

    @Override
    public boolean push(WorkItem item) {
        if (item == null) {
            throw new NullPointerException("Parameter [item] cannot be null.");
        }
        if (top < stack.length - 1) {
            top++;
            stack[top] = item;
            return true;
        }
        return false;
    }

    @Override
    public WorkItem pop() {
        if (isEmpty()) {
            return null;
        } else {
            top--;
            return stack[top + 1];
        }
    }

    @Override
    public int getItemPosition(WorkItem item) throws UnknownItemException {
        if (item == null) {
            throw new UnknownItemException ("Parameter [item] cannot be null.");
        }
        for (int i = top, position = 1; i >= 0; i--, position++) {
            if (item.equals(stack[i])) {
                return position;
            }
        }
        throw new UnknownItemException ("The item was not found on this table.");
    }
}
