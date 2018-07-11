package com.trs.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import com.trs.components.GameBoard;
import com.trs.components.Position;


public class TestGameBoard {
	
	@Test
    public void testIsValidPosition() throws Exception {
        Position mockPosition = mock(Position.class);
        when(mockPosition.getX()).thenReturn(6);
        when(mockPosition.getY()).thenReturn(7);

        GameBoard board = new GameBoard(4, 5);
        Assert.assertFalse(board.isValidPosition(mockPosition));


        when(mockPosition.getX()).thenReturn(1);
        when(mockPosition.getY()).thenReturn(1);
        Assert.assertTrue(board.isValidPosition(mockPosition));


        when(mockPosition.getX()).thenReturn(-1);
        when(mockPosition.getY()).thenReturn(-1);
        Assert.assertFalse(board.isValidPosition(mockPosition));
    }

}
