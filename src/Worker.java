/**
 * @author Jan Papousek
 */
public interface Worker {
    /**
     * It inserts a new work item into the worker's stack.
     *
     * @param item a new work item
     * @return true on success,
     * false otherwise (e.g. if the stack is full)
     * @throws NullPointerException if the parameter item is null.
     */
    boolean addWorkItem(WorkItem item);

    /**
     * The worker tries to work on the first item in the stack.
     * It prints the name of the work item on the standard output.
     *
     * @return true on success, false otherwise (stack is empty)
     */
    boolean work();

    /**
     * The worker tries to work on the specified work item
     * and prints its name on the standard output.
     * <p/>
     * If there are some items above the given one in the stack then the method
     * removes them from the stack (these items are just erased).
     * If the stack does not contain the given item,
     * the stack will not change and the method fails ATOMICALLY.
     *
     * @param item a work item which the worker will try to work on
     * @return true on success, false otherwise (stack does not contain the given item)
     */
    boolean deadlineWork(WorkItem item);
}
