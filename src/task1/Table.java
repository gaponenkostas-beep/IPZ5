package task1;

import java.util.HashMap;
import java.util.Map;
public class Table {
    private Map<Integer, Row> rows = new HashMap<>();

    public void insert(Row row) {
        if (rows.containsKey(row.getId())) {
            throw new IllegalArgumentException("Рядок з ID " + row.getId() + " вже існує.");
        }
        rows.put(row.getId(), row);
        System.out.println("LOG: Вставлено " + row);
    }

    public void update(int id, String newData) {
        if (!rows.containsKey(id)) {
            System.out.println("LOG: Помилка update - ID " + id + " не знайдено.");
            return;
        }
        Row row = rows.get(id);
        String oldData = row.getData();
        row.setData(newData);
        System.out.println("LOG: Оновлено ID=" + id + " ('" + oldData + "' -> '" + newData + "')");
    }

    public void delete(int id) {
        if (rows.remove(id) != null) {
            System.out.println("LOG: Видалено рядок з ID=" + id);
        } else {
            System.out.println("LOG: Помилка delete - ID " + id + " не знайдено.");
        }
    }

    public TableSnapshot createSnapshot() {
        return new TableSnapshot(this.rows);
    }

    public void restore(TableSnapshot snapshot) {
        this.rows = new HashMap<>();
        for (Map.Entry<Integer, Row> entry : snapshot.getState().entrySet()) {
            this.rows.put(entry.getKey(), entry.getValue().clone());
        }
    }

    @Override
    public String toString() {
        if (rows.isEmpty()) return "[Таблиця порожня]";
        StringBuilder sb = new StringBuilder("Поточний стан таблиці:\n");
        rows.values().forEach(row -> sb.append("  ").append(row).append("\n"));
        return sb.toString();
    }
}