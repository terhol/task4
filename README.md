# Task 4
Forth learning task from subject PB162 on [FI MUNI](https://www.fi.muni.cz/)

## Task description (Czech language only)

### Co je potřeba znát

-   práci s poli
-   výjimky

### Popis úlohy

Úloha simuluje pracovní stůl, kde se hromadí práce (pracovní zásobník) a
pracovníka, který u něj pracuje. K dispozici máte třídu `WorkItem`
představující pracovní položku, které můžete v konstruktoru nastavit
název. Přiložené testovací třídy testují základní funkčnost. Testy
můžete použít pro kontrolu správnosti vašeho kódu. Testy pro domácí část
jsou zakomentované, odkomunujte je až při psaní domácí části.

Žádnou z předdefinovaných tříd/rozhraní neměňte (pokud se to od vás
nevyžaduje přímo v zadání)!

### Zadání pro cvičení (3 body)

-   Vytvořte třídu `Table`, která představuje pracovní stůl a
    implementuje rozhraní `WorkStack`.
    -   Třída dostane v konstruktoru maximum pracovních položek, které
        se na pracovní stůl vejdou. Pomocí `IllegalArgumentException`
        ošetřete situaci, kdy dostanete jako maximum jiné než kladné
        číslo.
    -   Položky se na pracovním stole kupí a poslední položka, kterou na
        stůl vložíme, bude první, kterou z něj odebereme (LIFO). (Pokud
        z pracovního stolu odebereme položku, uvolní se v něm místo pro
        další)
    -   **Implementace bude pomocí pole!**
-   Vytvořte třídu `Demo` spustitelnou z příkazového řádku, která:
    -   vytvoří nový pracovní stůl o velikosti 3;
    -   vloží na něj postupně 4 různé pracovní položky snázvem "the
        first item", "the second item", atd.;
    -   postupně bude ze stolu pracovní položky odebírat a vypisovat na
        std. výstup.
-   Při správném řešení by třída měla vypsat:

        the third item
        the second item
        the first item
                        

### Zadání na doma (3 body)

-   Vytvořte hlídanou výjimku `UnknownItemException`.
-   Přepište rozhraní `WorkStack` tak, aby metoda `getItemPosition()`
    vyhazovala pouze výjimku `UnknownItemException` a to v případě, kdy
    je pracovní položka `null` nebo se v pracovním zásobníku vůbec
    nevyskytuje.
-   Změňte třídu `Table` tak, aby vyhovovala změněnému rozhraní
    `WorkStack`
-   Vytvořte třídu `WorkerImpl` implementující rozhraní `Worker`.
-   Při vyhazování výjimek, nastavte výjimkám zprávu, ve které popíšete
    důvod vyhození výjimky.
-   *Pozn.: Výjimky jsou v tomto příkladě použity pouze z důvodu
    prověření vašich znalostí. Dalo by se bez nich docela dobře obejít.
    Nechápejte tedy toto zadání jako vhodný příklad na použití výjimek.*

## License
MIT