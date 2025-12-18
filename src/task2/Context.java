package task2;

import java.util.HashMap;
import java.util.Map;
// 2. Клас Context (Контекст) - зберігає значення змінних
public class Context {
    private Map<String, Double> variables = new HashMap<>();

    public void setVariable(String name, double value) {
        variables.put(name, value);
    }

    public double getVariable(String name) {
        if (!variables.containsKey(name)) {
            throw new IllegalArgumentException("Змінна '" + name + "' не визначена в контексті!");
        }
        return variables.get(name);
    }
}
