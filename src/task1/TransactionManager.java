package task1;

// 4. TransactionManager - керує процесом
public class TransactionManager {
    private Table table;
    private TableSnapshot transactionStartSnapshot;
    private boolean isTransactionActive = false;

    public TransactionManager(Table table) {
        this.table = table;
    }

    public void beginTransaction() {
        if (isTransactionActive) {
            System.out.println("ТМ: Транзакція вже активна!");
            return;
        }
        // Створюємо знімок перед початком серії операцій
        this.transactionStartSnapshot = table.createSnapshot();
        this.isTransactionActive = true;
        System.out.println("\n=== ТМ: Транзакція розпочата. Знімок збережено. ===");
    }

    public void commit() {
        if (!isTransactionActive) return;
        this.transactionStartSnapshot = null; // Видаляємо знімок, зміни затверджені
        this.isTransactionActive = false;
        System.out.println("=== ТМ: Транзакція зафіксована (Commit). ===");
    }

    public void rollback() {
        if (!isTransactionActive || transactionStartSnapshot == null) {
            System.out.println("ТМ: Немає активної транзакції для відкату.");
            return;
        }
        System.out.println("!!! ТМ: Виконується ROLLBACK... !!!");
        table.restore(transactionStartSnapshot);
        this.isTransactionActive = false;
        this.transactionStartSnapshot = null;
        System.out.println("=== ТМ: Таблицю відновлено до стану на початок транзакції. ===");
    }

    // Методи-обгортки для виконання операцій всередині транзакції
    public void insert(Row row) {
        ensureTransaction();
        table.insert(row);
    }

    public void update(int id, String newData) {
        ensureTransaction();
        table.update(id, newData);
    }

    public void delete(int id) {
        ensureTransaction();
        table.delete(id);
    }

    // Автоматичний початок транзакції, якщо забули викликати begin
    private void ensureTransaction() {
        if (!isTransactionActive) {
            beginTransaction();
        }
    }
}
