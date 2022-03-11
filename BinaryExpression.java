//ID: 208641472

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * BinaryExpression represents expression that are formed from two expressions.
 * @author Yossi Maatook.
 */
public abstract class BinaryExpression extends BaseExpression {
    private Expression firstExpression;
    private Expression secondExpression;

    /**
     * Constructor.
     * @param first - one expression forming the And operator.
     * @param second - second expression forming the And operator.
     */
    public BinaryExpression(Expression first, Expression second) {
        this.firstExpression = first;
        this.secondExpression = second;
    }

    /**
     * Returns the first left expression of the BinaryExpression.
     * @return the first left expression of the BinaryExpression.
     */
    public Expression getFirstExpression() {
        return this.firstExpression;
    }

    /**
     * Returns the second left expression of the BinaryExpression.
     * @return the second left expression of the BinaryExpression.
     */
    public Expression getSecondExpression() {
        return this.secondExpression;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return createInstance(this.firstExpression.assign(var, expression),
                this.secondExpression.assign(var, expression));
    }

    @Override
    public List<String> getVariables() {
        return super.getVariables();
    }

    @Override
    public String toString() {
        return ("(" + getFirstExpression().toString() + " " + getExpressionSign()
                + " " + getSecondExpression().toString() + ")");
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return evaluate(firstExpression.evaluate(assignment),
                secondExpression.evaluate(assignment));
    }

    @Override
    public Boolean evaluate() throws Exception {
        return evaluate(getFirstExpression().evaluate(), getSecondExpression().evaluate());
    }

    /**
     * Evaluate the expression with two given booleans.
     * @param firstValue - first value of the expression to be valued.
     * @param secondValue - second value of the expression to be valued.
     * @return true if the logical operator is true with the given booleans and false otherwise.
     */
    protected abstract boolean evaluate(boolean firstValue, boolean secondValue);

    @Override
    public Expression simplify() {

        //Simplify first part of the binary expression//
        Expression firstExpressionSimplified = this.firstExpression.simplify();

        //Simplify second part of the binary expression//
        Expression secondExpressionSimplified = this.secondExpression.simplify();

        try {

            //In case the binary expression has no variables, evaluate it and returns a Val accordingly//
            if (firstExpressionSimplified.getVariables().isEmpty()
                    && secondExpressionSimplified.getVariables().isEmpty()) {
                return new Val(createInstance(firstExpressionSimplified, secondExpressionSimplified).evaluate());
            }

            //In case only first part of the expresion has variables and other part's value is true//
            if (!firstExpressionSimplified.getVariables().isEmpty()
                    && secondExpressionSimplified.getVariables().isEmpty() && secondExpressionSimplified.evaluate()) {
                return oneSubExpressionIsTrue(firstExpressionSimplified, false);
            }

            //In case only first part of the expresion has variables and other part's value is false//
            if (!firstExpressionSimplified.getVariables().isEmpty()
                    && secondExpressionSimplified.getVariables().isEmpty() && !secondExpressionSimplified.evaluate()) {
                return oneSubExpressionIsFalse(firstExpressionSimplified,  false);
            }

            //In case only second part of the expresion has variables and other part's value is true//
            if (firstExpressionSimplified.getVariables().isEmpty()
                    && !secondExpressionSimplified.getVariables().isEmpty() && firstExpressionSimplified.evaluate()) {
                return oneSubExpressionIsTrue(secondExpressionSimplified, true);
            }

            //In case only second part of the expresion has variables and other part's value is false//
            if (firstExpressionSimplified.getVariables().isEmpty()
                    && !secondExpressionSimplified.getVariables().isEmpty() && !firstExpressionSimplified.evaluate()) {
                return oneSubExpressionIsFalse(secondExpressionSimplified, true);
            }

            //In case both sides has variables and are equal//
            if (!firstExpressionSimplified.getVariables().isEmpty()
                    && !secondExpressionSimplified.getVariables().isEmpty()
                    && firstExpressionSimplified.toString().equals(secondExpressionSimplified.toString())) {
                return bothSubExpressionIsSame(firstExpressionSimplified);
            }
        } catch (Exception ignored) {

        }
        return createInstance(firstExpressionSimplified, secondExpressionSimplified);
    }

    @Override
    protected ArrayList<Expression> getExpressions() {
        ArrayList<Expression> list = new ArrayList<>();
        list.add(this.firstExpression);
        list.add(this.secondExpression);
        return list;
    }

    /**
     * Return an instance of the expression that is formed form two given expressions.
     * @param expressionOne - first part of the binary expression.
     * @param expressionTwo - second part of the binary expression.
     * @return an instance of the expression that is formed from the given expressions.
     */
    protected abstract Expression createInstance(Expression expressionOne, Expression expressionTwo);

    /**
     * Returns a simplified expression when both parts of the expression are equal.
     * @param expression - the sub expression that is equal to the other.
     * @return the simplified expression.
     */
    protected abstract Expression bothSubExpressionIsSame(Expression expression);

    /**
     * Returns a simplified expression one part of the expression is a false val, and the other is
     * a variables contained expression.
     * @param expression - the expression with the variables.
     * @param isOnRight - true if the var is the second part of the binary expression and false otherwise.
     * @return the simplified expression.
     */
    protected abstract Expression oneSubExpressionIsFalse(Expression expression, Boolean isOnRight);

    /**
     * Returns a simplified expression one part of the expression is a true val, and the other is
     * a variables contained expression.
     * @param expression - the expression with the variables.
     * @param isOnRight - true if the var is the second part of the binary expression and false otherwise.
     * @return the simplified expression.
     */
    protected abstract Expression oneSubExpressionIsTrue(Expression expression, Boolean isOnRight);

}
