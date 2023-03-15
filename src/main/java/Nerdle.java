import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    public static SymbolHint[] getHints(String guess, String solution, boolean isMini) throws Exception {
        SymbolHint[] hints = new SymbolHint[isMini ? MINI_LENGTH : NORMAL_LENGTH];
        Arrays.fill(hints, SymbolHint.USELESS);
        HashMap<Character, Integer> countsolution = getCharFreq(solution);
        // Validate input expressions
        if (validateExpression(guess) || validateExpression(solution)) {
            return hints;
        }


        // Check exceptions
        if( (isMini && (guess.length()!=6 || solution.length()!=6))||
                (!isMini && (guess.length()!=8 || solution.length()!=8))
            ){
            throw new Exception();
        }
        int length = isMini ? MINI_LENGTH : NORMAL_LENGTH;


        // Compute symbol hints

        for (int i = 0; i < length; i++) {
            char guessChar = guess.charAt(i);
            char solutionChar = solution.charAt(i);
            Integer count = countsolution.get(guessChar);
            if (guessChar==solutionChar) {
                hints[i] = SymbolHint.CORRECT;
                countsolution.put(guessChar,count-1);

            } else if (count != null && count>0) {
                hints[i] = SymbolHint.MISPLACED;
                countsolution.put(guessChar,count-1);

            }
        }

        return hints;
    }

    public static HashMap<Character,Integer> getCharFreq(String s) {
        HashMap<Character,Integer> charFreq = new HashMap<>();
        if (s != null) {
            for (Character c : s.toCharArray()) {
                Integer count = charFreq.get(c);
                int newCount = (count==null ? 1 : count+1);
                charFreq.put(c, newCount);
            }
        }
        return charFreq;
    }



}

