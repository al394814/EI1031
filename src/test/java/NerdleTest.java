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
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NerdleTest {


    public static Stream<Arguments> casos() {
        Nerdle.SymbolHint[] caso2 =new Nerdle.SymbolHint[]{Nerdle.SymbolHint.CORRECT, Nerdle.SymbolHint.CORRECT, Nerdle.SymbolHint.CORRECT, Nerdle.SymbolHint.CORRECT, Nerdle.SymbolHint.CORRECT, Nerdle.SymbolHint.CORRECT, Nerdle.SymbolHint.CORRECT, Nerdle.SymbolHint.CORRECT};
        Nerdle.SymbolHint[] caso3 = new Nerdle.SymbolHint[]{Nerdle.SymbolHint.CORRECT,Nerdle.SymbolHint.CORRECT,Nerdle.SymbolHint.CORRECT,Nerdle.SymbolHint.CORRECT,Nerdle.SymbolHint.CORRECT,Nerdle.SymbolHint.CORRECT};
        Nerdle.SymbolHint[] caso1 =new Nerdle.SymbolHint[]{Nerdle.SymbolHint.CORRECT, Nerdle.SymbolHint.MISPLACED, Nerdle.SymbolHint.MISPLACED, Nerdle.SymbolHint.MISPLACED, Nerdle.SymbolHint.CORRECT, Nerdle.SymbolHint.MISPLACED, Nerdle.SymbolHint.CORRECT, Nerdle.SymbolHint.USELESS};
        return Stream.of(
                arguments("1-8+16=9","1-8+16=9",false, caso2),
                arguments("12-6=6","12-6=6",true, caso3),
                arguments("19+-18=1","1-8+16=9",false, caso1),
                arguments("19+++18=37","1-8+16=9",false, new Exception()),
                arguments("19+1=20","1-8+16=9", true, new Exception()),
                arguments("19+1=20","1-8+16=9",false, new Exception()),
                arguments("1+1=2","1-8+16=9",true, new Exception()),
                arguments("19++18=37","1-8+16=9",false, new Exception()),
                arguments("1+2=3","1-8+16=9",true, new Exception()),
                arguments("19+-18=1","1–+8+16=9",false, new Exception()),
                arguments("19+-18=1","19+++18=37",false, new Exception()),
                arguments("2+-1=1","1+2=3",true, new Exception())
        );
    }
    @ParameterizedTest
    @MethodSource("casos")
    public void getHintsTest(String guess, String solution, boolean isMini,  Nerdle.SymbolHint[] expected) throws Exception{
        Nerdle.SymbolHint[] actualHints = Nerdle.getHints(guess, solution, isMini);
        for(Nerdle.SymbolHint hint: actualHints){
            System.out.println(hint);
        }

        assertArrayEquals(Arrays.stream(expected).toArray(),actualHints);
    }



}