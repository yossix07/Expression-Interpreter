import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Var Represent the variables that are forming an expression.
 * @author Yossi Maatook.
 */
public class Var implements Expression {
    private String expressionString;

    /**
     * Constructor.
     * @param s - the var string.
     */
    public Var(String s) {
        this.expressionString = s;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        try {
            return assignment.get(this.expressionString);
        } catch (Exception e) {
            throw new Exception("Must set" + this.expressionString.toString() + "'s value!");
        }
    }

    @Override
    public Boolean evaluate() throws Exception {
        throw new Exception("Var has no value!");
    }

    @Override
    public List<String> getVariables() {
        List<String> list = new ArrayList<>();
        list.add(this.expressionString);
        return list;
    }

    @Override
    public String toString() {
        return this.expressionString;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if (var.equals(this.expressionString)) {
            return expression;
        }
        return this;
    }

    @Override
    public Expression nandify() {
        return this;
    }

    @Override
    public Expression norify() {
        return this;
    }

    @Override
    public Expression simplify() {
        return this;
    }
}
