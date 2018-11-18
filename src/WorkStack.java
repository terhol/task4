/**
 * Stack of work items.
 *
 * @author Jan Papousek
 */
public interface WorkStack {
    /**
     * Checks whether the stack is empty.
     *
     * @return true if the stack is empty,
     * false otherwise
     */
    boolean isEmpty();

    /**
     * Inserts a new work item to the stack.
     *
     * @param item work item which will be inserted to the stack
     * @return true if the item is successfully inserted,
     * false otherwise (e.g. if the stack is full)
     * @throws NullPointerException if the parameter item is null.
     */
    boolean push(WorkItem item);

    /**
     * It retrieves and removes the first item (top item) of the stack.
     * Returns null if the stack is empty.
     *
     * @return the top item of the stack,
     * or null if the stack is empty.
     */
    WorkItem pop();

    /**
     * It returns a position of the given work item in "to do list".
     * When the work item is on the top of the stack the position is 1,
     * when the work item is on the bottom of the stack, the position is number of items in the stack.
     *
     * @param item a work item
     * @return position of the work item
     * @throws NullPointerException     if the parameter item is null.
     * @throws IllegalArgumentException if the stack does not contain the given work item.
     */
    int getItemPosition(WorkItem item);
}
