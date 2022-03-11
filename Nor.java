//ID: 208641472

import java.util.List;
import java.util.Map;

/**
 * Nor Represent the Nor logical operator between two Expressions.
 * @author Yossi Maatook.
 */
public class Nor extends BinaryExpression {

    /**
     * Constructor.
     * @param first - one expression forming the And operator.
     * @param second - second expression forming the And operator.
     */
    public Nor(Expression first, Expression second) {
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
        return !firstValue && !secondValue;
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
        return ("V");
    }

    @Override
    protected Expression createInstance(Expression firstExpression, Expression secondExpression) {
        return new Nor(firstExpression, secondExpression);
    }

    @Override
    public Expression norify() {
        return createInstance(getFirstExpression().norify(), getSecondExpression().norify());
    }

    @Override
    public Expression nandify() {
        Nand subNand = new Nand(new Nand(getFirstExpression().nandify(), getFirstExpression().nandify()),
                new Nand(getSecondExpression().nandify(), getSecondExpression().nandify()));
        return new Nand(subNand, subNand);
    }

    @Override
    public Expression simplify() {
        return super.simplify();
    }

    @Override
    protected Expression oneSubExpressionIsTrue(Expression expression, Boolean isOnRight) {
        return new Val(false);
    }

    @Override
    protected Expression oneSubExpressionIsFalse(Expression expression, Boolean isOnRight) {
        return new Not(expression);
    }

    @Override
    protected Expression bothSubExpressionIsSame(Expression expression) {
        return new Not(expression);
    }
}
