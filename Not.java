import java.util.List;
import java.util.Map;

/**
 * Not Represent the Not logical unary operator.
 * @author Yossi Maatook.
 */
public class Not extends UnaryExpression {

    /**
     * Constructor.
     * @param e - the expression forming the not expression.
     */
    public Not(Expression e) {
        super(e);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !getExpression().evaluate(assignment);
    }

    @Override
    public Boolean evaluate() throws Exception {
        return !getExpression().evaluate();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected String getExpressionSign() {
        return "~";
    }

    @Override
    public List<String> getVariables() {
        return super.getVariables();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return super.assign(var, expression);
    }

    @Override
    protected Expression createInstance(Expression expression) {
        return new Not(expression);
    }

    @Override
    public Expression norify() {
        return new Nor(getExpression().norify(), getExpression().norify());
    }

    @Override
    public Expression nandify() {
        return new Nand(getExpression().nandify(), getExpression().nandify());
    }

    @Override
    public Expression simplify() {
        Expression simplified = this.getExpression().simplify();
        try {
            return new Val(!simplified.evaluate());
        } catch (Exception e) {
            return new Not(simplified);
        }
    }
}
