package task1;

import java.util.HashMap;
import java.util.Map;

public class TableSnapshot {
    private final Map<Integer, Row> savedRows;

    public TableSnapshot(Map<Integer, Row> rows) {
        this.savedRows = new HashMap<>();
        for (Map.Entry<Integer, Row> entry : rows.entrySet()) {
            this.savedRows.put(entry.getKey(), entry.getValue().clone());
        }
    }

    public Map<Integer, Row> getState() {
        return savedRows;
    }
}