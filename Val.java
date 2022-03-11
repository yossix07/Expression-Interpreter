import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Val Represent the boolean true and false expressions.
 * @author Yossi Maatook.
 */
public class Val implements Expression {
    private Boolean value;

    /**
     * Constructor.
     * @param v - the boolean forming the val expression.
     */
    public Val(Boolean v) {
        this.value = v;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return this.value;
    }

    @Override
    public Boolean evaluate() throws Exception {
        return this.value;
    }

    @Override
    public List<String> getVariables() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        if (this.value) {
            return ("T");
        }
        return ("F");
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Val(this.value);
    }

    /**
     * Returns the boolean value of the var.
     * @return the boolean value of the var.
     */
    public Boolean getValue() {
        return this.value;
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
