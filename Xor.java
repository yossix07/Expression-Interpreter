//ID: 208641472

import java.util.List;
import java.util.Map;

/**
 * Xor Represent the Xor logical operator between two Expressions.
 * @author Yossi Maatook.
 */
public class Xor extends BinaryExpression {

    /**
     * Constructor.
     * @param first - one expression forming the And operator.
     * @param second - second expression forming the And operator.
     */
    public Xor(Expression first, Expression second) {
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
        return ((firstValue && !secondValue) || (!firstValue && secondValue));
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
        return ("^");
    }

    @Override
    protected Expression createInstance(Expression firstExpression, Expression secondExpression) {
        return new Xor(firstExpression, secondExpression);
    }

    @Override
    public Expression norify() {
        Nor aNorA = new Nor(getFirstExpression().norify(), getFirstExpression().norify());
        Nor bNorB = new Nor(getSecondExpression().norify(), getSecondExpression().norify());
        Nor aNorB = new Nor(getFirstExpression().norify(), getSecondExpression().norify());
        return new Nor(new Nor(aNorA, bNorB), aNorB);
    }

    @Override
    public Expression nandify() {
        Nand firstSubNor = new Nand(getFirstExpression().nandify(),
                new Nand(getFirstExpression().nandify(), getSecondExpression().nandify()));
        Nand secondSubNor = new Nand(getSecondExpression().nandify(),
                new Nand(getFirstExpression().nandify(), getSecondExpression().nandify()));
        return new Nand(firstSubNor, secondSubNor);
    }

    @Override
    public Expression simplify() {
        return super.simplify();
    }

    @Override
    protected Expression oneSubExpressionIsFalse(Expression expression, Boolean isOnRight) {
        return expression;
    }

    @Override
    protected Expression oneSubExpressionIsTrue(Expression expression, Boolean isOnRight) {
        return new Not(expression);
    }

    @Override
    protected Expression bothSubExpressionIsSame(Expression expression) {
        return new Val(false);
    }
}
