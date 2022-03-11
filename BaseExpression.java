import java.util.ArrayList;
import java.util.List;

/**
 * BaseExpression represents complex expressions which are formed from one expression or more.
 * @author Yossi Maatook.
 */
public abstract class BaseExpression implements Expression {

    /**
     * Returns the sign of the Expression(it's logical symbol).
     * @return Returns the sign of the Expression(it's logical symbol).
     */
    protected abstract String getExpressionSign();

    /**
     * Returns a list with the expressions which are forming the BaseExpression.
     * @return list with the expressions which are forming the BaseExpression.
     */
    protected abstract ArrayList<Expression> getExpressions();

    @Override
    public List<String> getVariables() {
        //Get list of the expression forming the BaseExpression//
        ArrayList<Expression> expressions = getExpressions();
        ArrayList<String> variables = new ArrayList<>();

        //Add the variables from each expression to the list//
        for (Expression e:expressions) {
            variables.addAll(e.getVariables());
        }
        return new ListActions().removeDuplicates(variables);
    }
}
