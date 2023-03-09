import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NerdleTest {
    private List<String> correctaTamOcho;
    private List<String> correctaTamSeis;
    private List<String> incorrecta;

    private static Stream<Arguments> provideResults() {
        return Stream.of(
                Arguments.of(new Nerdle.SymbolHint[]{Nerdle.SymbolHint.CORRECT, Nerdle.SymbolHint.MISPLACED, Nerdle.SymbolHint.MISPLACED, Nerdle.SymbolHint.MISPLACED, Nerdle.SymbolHint.CORRECT, Nerdle.SymbolHint.MISPLACED, Nerdle.SymbolHint.CORRECT, Nerdle.SymbolHint.USELESS}, true),
                Arguments.of("", true),
                Arguments.of("  ", true),
                Arguments.of("not blank", false)
        );
    }
    @BeforeEach
    @MethodSource()
    void setUp() {


        correctaTamOcho = Arrays.asList("CORRECT","CORRECT","CORRECT","CORRECT","CORRECT","CORRECT","CORRECT","CORRECT");
        correctaTamSeis = Arrays.asList("CORRECT","CORRECT","CORRECT","CORRECT","CORRECT","CORRECT");
        incorrecta = Arrays.asList("CORRECT", "MISPLACED", "MISPLACED", "MISPLACED", "CORRECT", "MISPLACED", "CORRECT", "USELESS");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getHints() {
    }

    @ParameterizedTest
    void isBlank_ShouldReturnTrueForEmptyStrings(String guess, String solution, boolean isMini, boolean expected) {
        assertEquals(expected, Nerdle.getHints(guess,solution,isMini));
    }

}