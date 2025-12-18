package task2;

public class VariableExpression implements Expression {
    private String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public double interpret(Context context) {
        return context.getVariable(name);
    }
}
