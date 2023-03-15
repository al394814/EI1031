import java.util.Arrays;

public class Nerdle {
    public static final int NORMAL_LENGTH = 8;
    public static final int MINI_LENGTH = 6;
    public enum SymbolHint {
        USELESS,
        MISPLACED,
        CORRECT
    }
    public static boolean validateExpression(String expression) {
        // Given a string, it returns whether or not it follows the syntax
        // ArithmeticExpression "=" Result
        // with ints, "+", "-", "*" and "/" as operators and
        // without parentheses or spaces AND
        // the value of ArithmeticExpression equals Result
        // Not yet implemented...
        return false;
    }
    public static SymbolHint[] getHints(String guess, String solution, boolean isMini) {
        SymbolHint[] hints = new SymbolHint[isMini ? MINI_LENGTH : NORMAL_LENGTH];
        Arrays.fill(hints, SymbolHint.USELESS);

        // Validate input expressions
        if (validateExpression(guess) || validateExpression(solution)) {
            return hints;
        }

        // Parse input expressions

        int length = isMini ? MINI_LENGTH : NORMAL_LENGTH;

        // Compute symbol hints

        for (int i = 0; i < length; i++) {
            char guessChar = guess.charAt(i);
            char solutionChar = solution.charAt(i);

            if (guessChar==solutionChar) {
                hints[i] = SymbolHint.CORRECT;

            } else if (solution.contains(String.valueOf(guessChar))) {
                hints[i] = SymbolHint.MISPLACED;

            } else {
                hints[i] = SymbolHint.USELESS;
            }
        }




        return hints;
    }




}

