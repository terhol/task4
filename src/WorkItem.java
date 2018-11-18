/**
 * Work item
 *
 * @author Jan Papousek
 */
public class WorkItem {
    private String name;

    /**
     * It creates a new work item with the specified name.
     *
     * @param name name of the work item
     * @throws NullPointerException if the name is null
     */
    public WorkItem(String name) {
        if (name == null) {
            throw new NullPointerException("The name of the work item can't be set to NULL");
        }
        this.name = name;
    }

    /**
     * It returns true if the given object is instance of this class
     * and has the same name.
     *
     * @param object
     * @return true if the given object equals to this one
     * false otherwise
     */
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof WorkItem)) {
            return false;
        }
        WorkItem item = (WorkItem) object;
        return item.getName().equals(getName());
    }

    /**
     * It returns the hashcode of the name of the work item
     *
     * @return hash code
     */
    public int hashCode() {
        return getName().hashCode();
    }

    /**
     * @return name of the work item
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
