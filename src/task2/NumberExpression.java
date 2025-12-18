package task2;

// 3. Термінальний вираз: Число
public class NumberExpression implements Expression {
    private double number;

    public NumberExpression(double number) {
        this.number = number;
    }

    @Override
    public double interpret(Context context) {
        return number;
    }
}