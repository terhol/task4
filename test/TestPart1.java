import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jan Papousek
 */
public class TestPart1 {
    private static WorkItem[] items = new WorkItem[]{new WorkItem("Prvni polozka"), new WorkItem("Druha polozka"), new WorkItem("Treti polozka")};

    @Test
    public void testIllegalSize() {
        try {
            WorkStack q = new Table(-1);
            fail("Pri vytvareni zasobniku se zapornou velikosti nebyla vyhozena vyjimka.");
        } catch (IllegalArgumentException e) {
        } catch (Exception e) {
            fail("Pri vytvareni zasobniku se zapornou velikosti byla vyhozena spatna vyjimka [" + e.getClass().getName() + "].");
        }

        try {
            WorkStack q = new Table(0);

            fail("Pri vytvareni zasobniku s nulovou velikosti nebyla vyhozena vyjimka.");
        } catch (IllegalArgumentException e) {
        } catch (Exception e) {
            fail("Pri vytvareni zasobniku s nulovou velikosti byla vyhozena spatna vyjimka [" + e.getClass().getName() + "].");
        }
    }

    @Test
    public void testNullPosition() {
        WorkStack q = new Table(1);
        q.push(items[0]);
        try {
            q.getItemPosition(null);
            fail("Pri pozadovani pozice polozky [null] nebyla vyhozena vyjimka.");
        } catch (NullPointerException e) {
        } catch (Exception e) {
            fail("Pri pozadovani pozice polozky [null] byla vyhozena spatna vyjimka [" + e.getClass().getName() + "].");
        }
    }

    @Test
    public void testNullPush() {
        WorkStack q = new Table(1);
        try {
            q.push(null);
            fail("Pri vkladani [null] nebyla vyhozena vyjimka.");
        } catch (NullPointerException e) {
        } catch (Exception e) {
            fail("Pri vkladani [null] byla vyhozena spatna vyjimka [" + e.getClass().getName() + "].");
        }
    }

    @Test
    public void testPushAndPop() {
        WorkStack q = new Table(2);
        assertTrue(q.isEmpty(), "Prave vytvorena zasobnik hlasi, ze neni prazdna.", );

        assertTrue(q.push(items[0]), "Pri vlozeni prvku zasobnik nevraci [true].");
        assertFalse(q.isEmpty(), "Po vlozeni jedne polozky zasobnik hlasi, ze je prazdna.");

        assertTrue(q.push(items[1]), "Pri vlozeni prvku zasobnik nevraci [true].");
        assertFalse(q.isEmpty(), "Po vlozeni druhe polozky zasobnik hlasi, ze je prazdna.");

        assertFalse(q.push(items[0]), "Pri vlozeni prvku, ktery se uz do zasobniku nevejde, zasobnik nevraci [false].");

        assertEquals(items[1], q.pop(), "Zasobnik pri prvnim volani [pop] nevratila prvek, ktery byl do ni vlozen jako posledni.");
        assertFalse(q.isEmpty(), "Po odebrani 1 prvku ze 2 zasobnik hlasi, ze je prazdna.");

        assertTrue(q.push(items[2]), "Pri vlozeni prvku zasobnik nevraci [true].");

        assertEquals(items[2], q.pop(), "Zasobnik pri druhem volani [pop] nevratila prvek, ktery byl do ni vlozen jako posledni.");
        assertFalse(q.isEmpty(), "Po odebrani 1 prvku ze 2 zasobnik hlasi, ze je prazdna.");

        assertEquals(items[0], q.pop(), "Zasobnik pri tretim volani [pop] nevratila prvek, ktery byl do ni vlozen jako prvni.");
        assertTrue(q.isEmpty(), "Po odebrani vsech prvku zasobnik hlasi, ze neni prazdna.");
    }

    @Test
    public void testPosition() throws Exception {
        WorkStack q = new Table(2);
        q.push(items[0]);
        q.push(items[1]);
        assertEquals(1, q.getItemPosition(items[1]), "Naposledy vlozeny prvek nema pozici 1.");
        assertEquals(2, q.getItemPosition(items[0]), "Nejdrive vlozeny prvek nema pozici [pocet polozek v zasobniku].");
        q.pop();
        assertEquals(1, q.getItemPosition(items[0]), "Nejdrive vlozeny prvek nema pozici [pocet polozek v zasobniku].");
    }
}
