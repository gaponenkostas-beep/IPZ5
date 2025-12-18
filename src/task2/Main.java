package task2;

// 6. Main - демонстрація
public class Main {
    public static void main(String[] args) {
        // Приклад 1: Простий вираз без змінних "3 + 5 * 2"
        Expression expr1 = new AddExpression(
                new NumberExpression(3),
                new MultiplyExpression(
                        new NumberExpression(5),
                        new NumberExpression(2)
                )
        );

        // Для цього виразу контекст порожній, бо немає змінних
        Context emptyContext = new Context();
        System.out.println("Вираз '3 + 5 * 2' = " + expr1.interpret(emptyContext));


        // Приклад 2: Вираз зі змінними "(x - 4) / y"
        Context context = new Context();
        context.setVariable("x", 20);
        context.setVariable("y", 2);

        Expression expr2 = new DivideExpression(
                new SubtractExpression(
                        new VariableExpression("x"),
                        new NumberExpression(4)
                ),
                new VariableExpression("y")
        );

        System.out.println("Вираз '(x - 4) / y' при x=20, y=2: " + expr2.interpret(context));


        // --- Приклад 3: Зміна контексту без зміни структури виразу ---
        context.setVariable("x", 100);
        context.setVariable("y", 8);
        System.out.println("Той самий вираз '(x - 4) / y' при x=100, y=8: " + expr2.interpret(context));


        // --- Приклад 4: Комбінований складний вираз
        // (x * y) + (z - 5)
        context.setVariable("z", 10);
        Expression complexExpr = new AddExpression(
                new MultiplyExpression(new VariableExpression("x"), new VariableExpression("y")), // 100 * 8 = 800
                new SubtractExpression(new VariableExpression("z"), new NumberExpression(5))      // 10 - 5 = 5
        );
        System.out.println("Складний вираз '(x * y) + (z - 5)': " + complexExpr.interpret(context));
    }
}
