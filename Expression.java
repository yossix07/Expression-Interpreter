//ID: 208641472

import java.util.List;
import java.util.Map;

/**
 * Expression Represents discrete mathematics expressions.
 */
public interface Expression {

    /**
     * Evaluate the expression using the variable values provided in the assignment, and return the result.
     * If the expression contains a variable which is not in the assignment, an exception is thrown.
     * @param assignment - Map with the boolean values of each variable.
     * @return true if the expression value is true and false otherwise.
     * @throws Exception if there is a variable in the expression that has no value in the map.
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    //
    //

    /**
     * A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * Meaning, returns the value of the expression if possible.
     * @return true if the expression value is true and false otherwise.
     * @throws Exception if there is a variable in the expression that has no value in the map.
     */
    Boolean evaluate() throws Exception;

    /**
     * Returns a list of the variables in the expression.
     * @return list with all the variables in the expression.
     */
    List<String> getVariables();

    /**
     * Returns a string representation of the expression.
     * @return a string representation of the expression.
     */
    String toString();

    /**
     * Returns a new expression in which all occurrences of the variable var are replaced with the provided expression
     * (Does not modify the current expression).
     * @param var - the var which will be replaced.
     * @param expression - the expression which will replace var.
     * @return a new expression in which all occurrences of the variable var are replaced with the provided expression.
     */
    Expression assign(String var, Expression expression);

    /**
     * Returns the expression tree resulting from converting all the operations to the logical Nand operation.
     * @return expression tree resulting from converting all the operations to the logical Nand operation.
     */
    Expression nandify();

    /**
     * Returns the expression tree resulting from converting all the operations to the logical Nor operation.
     * @return expression tree resulting from converting all the operations to the logical Nor operation.
     */
    Expression norify();

    /**
     * Returns a simplified version of the current expression.
     * @return simplified version of the current expression.
     */
    Expression simplify();
}