package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenPositionThenSuccess() {
        BishopBlack bb = new BishopBlack(Cell.A1);
        assertEquals(Cell.A1, bb.position());
    }

    @Test
    void whenCopyThenSuccess() {
        BishopBlack bb = new BishopBlack(Cell.A2);
        assertEquals(Cell.A7, bb.copy(Cell.A7).position());
    }

    @Test
    void whenWayFromC1ToG5ThenSuccess() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] expectedResult = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] result = bb.way(Cell.G5);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void whenWayFromC1ToF5ThenImpossibleMoveException() throws ImpossibleMoveException {
        BishopBlack bb = new BishopBlack(Cell.C1);
        ImpossibleMoveException e = assertThrows(ImpossibleMoveException.class, () -> {
            bb.way(Cell.F5);
        });
        assertThat(e.getMessage()).isEqualTo("Could not move by diagonal from C1 to F5");
    }
}