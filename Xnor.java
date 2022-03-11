import java.util.List;
import java.util.Map;

/**
 * Xnor Represent the Xnor logical operator between two Expressions.
 * @author Yossi Maatook.
 */
public class Xnor extends BinaryExpression {

    /**
     * Constructor.
     * @param first - one expression forming the And operator.
     * @param second - second expression forming the And operator.
     */
    public Xnor(Expression first, Expression second) {
        super(first, second);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return super.evaluate(assignment);
    }

    @Override
    public Boolean evaluate() throws Exception {
        return super.evaluate();
    }

    @Override
    protected boolean evaluate(boolean firstValue, boolean secondValue) {
        return (firstValue && secondValue) || (!firstValue && !secondValue);
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return super.assign(var, expression);
    }

    @Override
    public List<String> getVariables() {
        return super.getVariables();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getExpressionSign() {
        return ("#");
    }

    @Override
    protected Expression createInstance(Expression firstExpression, Expression secondExpression) {
        return new Xnor(firstExpression, secondExpression);
    }

    @Override
    public Expression nandify() {
        Nand aNandA = new Nand(getFirstExpression().nandify(), getFirstExpression().nandify());
        Nand bNandB = new Nand(getSecondExpression().nandify(), getSecondExpression().nandify());
        Nand aNandB = new Nand(getFirstExpression().nandify(), getSecondExpression().nandify());
        return new Nand(new Nand(aNandA, bNandB), aNandB);
    }

    @Override
    public Expression norify() {
        Nor firstSubNor = new Nor(getFirstExpression().norify(),
                new Nor(getFirstExpression().norify(), getSecondExpression().norify()));
        Nor secondSubNor = new Nor(getSecondExpression().norify(),
                new Nor(getFirstExpression().norify(), getSecondExpression().norify()));
        return new Nor(firstSubNor, secondSubNor);
    }

    @Override
    public Expression simplify() {
        return super.simplify();
    }

    @Override
    protected Expression oneSubExpressionIsFalse(Expression expression, Boolean isOnRight) {
        if (isOnRight) {
            return createInstance(new Val(false), expression);
        }
        return createInstance(expression, new Val(false));
    }

    @Override
    protected Expression oneSubExpressionIsTrue(Expression expression, Boolean isOnRight) {
        if (isOnRight) {
            return createInstance(new Val(true), expression);
        }
        return createInstance(expression, new Val(true));
    }

    @Override
    protected Expression bothSubExpressionIsSame(Expression expression) {
        return new Val(true);
    }
}
