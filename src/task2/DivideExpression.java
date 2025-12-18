package task2;

// Ділення (/)
public class DivideExpression implements Expression {
    private Expression left;
    private Expression right;

    public DivideExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret(Context context) {
        double denominator = right.interpret(context);
        if (denominator == 0) {
            throw new ArithmeticException("Ділення на нуль!");
        }
        return left.interpret(context) / denominator;
    }
}
