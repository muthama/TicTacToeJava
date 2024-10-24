package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    public void testChooseValidMove() {
        TicTacToe game = new TicTacToe();
        assertTrue(game.choose(0, 0));  // Valid move
        assertEquals('O', game.getNextPlayerChar());  // Next player should be 'O'
    }

    @Test
    public void testChooseInvalidMoveOutOfRange() {
        TicTacToe game = new TicTacToe();
        assertFalse(game.choose(3, 3));  // Out of range
    }

    @Test
    public void testDidWin() {
        TicTacToe game = new TicTacToe();
        game.choose(0, 0);  // X
        game.choose(1, 0);  // O
        game.choose(0, 1);  // X
        game.choose(1, 1);  // O
        game.choose(0, 2);  // X - X wins
        assertTrue(game.didWin('X'));
    }

   /* @Test
    public void testDidTie() {
        TicTacToe game = new TicTacToe();
        game.choose(0, 0);  // X
        game.choose(0, 1);  // O
        game.choose(0, 2);  // X
        game.choose(1, 1);  // O
        game.choose(1, 0);  // X
        game.choose(1, 2);  // O
        game.choose(2, 0);  // X
        game.choose(2, 2);  // O
        game.choose(2, 1);  // X - No one wins
        assertTrue(game.didTie());
    }*/

}