import java.util.ArrayList;
import java.util.List;

/**
 * UnaryExpression represents expression that are formed from one expression.
 * @author Yossi Maatook.
 */
public abstract class UnaryExpression extends BaseExpression {
    private Expression expression;

    /**
     * Constructor.
     * @param e - the expression forming the unary expression.
     */
    public UnaryExpression(Expression e) {
        this.expression = e;
    }

    /**
     * Returns the expression forming the unary expression.
     * @return the expression forming the unary expression.
     */
    public Expression getExpression() {
        return this.expression;
    }

    @Override
    public String toString() {
        return (getExpressionSign() + "(" + this.expression.toString() + ")");
    }

    @Override
    public List<String> getVariables() {
        return super.getVariables();
    }

    @Override
    public Expression assign(String var, Expression e) {
        return createInstance(this.expression.assign(var, e));
    }

    @Override
    protected ArrayList<Expression> getExpressions() {
        ArrayList<Expression> list = new ArrayList<>();
        list.add(this.expression);
        return list;
    }

    /**
     * Return an instance of the expression that is formed form A given expression.
     * @param e - the expression forming the unary expression.
     * @return expression formed from the given expression.
     */
    protected abstract Expression createInstance(Expression e);
}
