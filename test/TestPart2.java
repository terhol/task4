import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author Jan Papousek
 */
public class TestPart2 {

    private static WorkItem[] items = new WorkItem[]{new WorkItem("Prvni polozka"), new WorkItem("Druha polozka"), new WorkItem("Treti polozka")};
    private Worker worker;

    @BeforeEach
    public void setUp() {
        this.worker = new WorkerImpl(new Table(2));
    }

    @Test
    public void testNullPush() {
        try {
            worker.addWorkItem(null);
            fail("Pri vkladani [null] nebyla vyhozena vyjimka.");
        } catch (NullPointerException e) {
        } catch (Exception e) {
            fail("Pri vkladani [null] byla vyhozena spatna vyjimka [" + e.getClass().getName() + "].");
        }
    }

    @Test
    public void testNullDeadlineWork() {
        try {
            worker.deadlineWork(null);
            assertFalse(worker.deadlineWork(null), "Pri deadline praci s pracovni polozkou [null] nebylo vraceno false.");
        } catch (Exception e) {
            fail("Pri deadline praci s pracovni polozkou [null] byla vyhozena vyjimka [" + e.getClass().getName() + "].");
        }
    }

    @Test
    public void testDeadlineWork() {
        worker.addWorkItem(items[0]);
        worker.addWorkItem(items[1]);
        assertTrue(worker.deadlineWork(items[1]), "Deadline prace nevraci true.");
        assertTrue(worker.deadlineWork(items[0]), "Deadline prace nevraci true.");
        assertFalse(worker.work(), "Deadline prace nemaze pracovni polozky.");

        worker.addWorkItem(items[0]);
        worker.addWorkItem(items[1]);
        assertFalse(worker.deadlineWork(items[2]), "Pri deadline praci s pracovni polozkou, ktera nebyla pracovnikovi zadana, nebylo vraceno false.");
        assertTrue(worker.deadlineWork(items[0]), "Deadline prace s pracovni polozkou, ktera nebyla prirazena pracovnikovi, byly pravdepodobne smazany dalsi pracovni polozky.");
        assertFalse(worker.work(), "Deadline prace s pracovni polozkou, ktera byla zadana jako prvni, nevymazala vsechny polozky.");
    }

    @Test
    public void testWork() {
        assertFalse(worker.work(), "Metoda [work] nevraci false, kdyz nema pracovnik pridelenou praci.");
        worker.addWorkItem(items[0]);
        assertTrue(worker.work(), "Metoda [work] nevraci true, kdyz ma pridelenou praci.");
        assertFalse(worker.work(), "Metoda [work] nevraci false, kdyz nema pracovnik pridelenou praci.");
        worker.addWorkItem(items[0]);
        worker.addWorkItem(items[1]);
        assertTrue(worker.work(), "Metoda [work] nevraci true, kdyz ma pridelenou praci.");
        assertTrue(worker.work(), "Metoda [work] nevraci true, kdyz ma pridelenou praci.");
        assertFalse(worker.work(), "Metoda [work] nevraci false, kdyz nema pracovnik pridelenou praci.");
    }

}
