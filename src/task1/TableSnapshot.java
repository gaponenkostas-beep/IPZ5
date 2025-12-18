package task1;

import java.util.HashMap;
import java.util.Map;
// 2. Клас Snapshot (Знімок) - зберігає стан таблиці
public class TableSnapshot {
    private final Map<Integer, Row> savedRows;

    public TableSnapshot(Map<Integer, Row> rows) {
        // Робимо глибоку копію мапи та самих об'єктів Row
        this.savedRows = new HashMap<>();
        for (Map.Entry<Integer, Row> entry : rows.entrySet()) {
            this.savedRows.put(entry.getKey(), entry.getValue().clone());
        }
    }

    public Map<Integer, Row> getState() {
        return savedRows;
    }
}