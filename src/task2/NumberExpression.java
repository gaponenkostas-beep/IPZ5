package task2;

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