package task1;


public class Main {
    public static void main(String[] args) {
        // 1. Створити таблицю та заповнити початковими даними
        Table myTable = new Table();
        System.out.println("--- Ініціалізація даних ---");
        myTable.insert(new Row(1, "Apple"));
        myTable.insert(new Row(2, "Banana"));
        myTable.insert(new Row(3, "Cherry"));

        System.out.println(myTable);

        // 2. Створюємо менеджер транзакцій
        TransactionManager tm = new TransactionManager(myTable);

        // --- Сценарій 1: Успішна транзакція (не показана явно в умові, але для логіки) ---
        // --- Сценарій 2: Транзакція з відкатом (Rollback) ---
        tm.beginTransaction();

        // Виконуємо серію операцій
        try {
            // а) Оновлення
            tm.update(1, "Avocado"); // Apple -> Avocado

            // б) Видалення
            tm.delete(2); // Видаляємо Banana

            // в) Вставка
            tm.insert(new Row(100, "Dragonfruit"));

            System.out.println("\n(Стан таблиці всередині транзакції, перед rollback):");
            System.out.println(myTable);

            // Симулюємо "помилку" або просто рішення відкотити зміни
            System.out.println("-> Виявлено помилку в бізнес-логіці. Ініціюємо відкат...");
            tm.rollback();

        } catch (Exception e) {
            e.printStackTrace();
            tm.rollback();
        }

        // 3. Перевіряємо, чи відновилися дані
        System.out.println("\n(Стан таблиці після rollback):");
        System.out.println(myTable);

        // Перевірка: Apple має бути Apple, Banana має бути на місці, Dragonfruit має зникнути.
    }
}
