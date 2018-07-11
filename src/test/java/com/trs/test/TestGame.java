package com.trs.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.trs.components.Direction;
import com.trs.components.GameBoard;
import com.trs.components.Position;
import com.trs.components.Robot;
import com.trs.exception.ToyStimulatorException;
import com.trs.game.Game;


public class TestGame {
	 final int BOARD_ROWS = 5;
	    final int BOARD_COLUMNS = 5;
	    @Rule
	    public org.junit.rules.ExpectedException thrown = ExpectedException.none();

	    @Test
	    public void testPlacing() throws ToyStimulatorException {

	        GameBoard board = new GameBoard(BOARD_COLUMNS, BOARD_ROWS);
	        Robot robot = new Robot();
	        Game game = new Game(board, robot);

	        Assert.assertTrue(game.placeToyRobot(new Position(0, 1, Direction.NORTH)));
	        Assert.assertTrue(game.placeToyRobot(new Position(2, 2, Direction.SOUTH)));
	        Assert.assertFalse(game.placeToyRobot(new Position(6, 6, Direction.WEST)));
	        Assert.assertFalse(game.placeToyRobot(new Position(-1, 5, Direction.EAST)));
	    }

	    @Test
	    public void testPlacingExceptions() throws ToyStimulatorException {

	    	GameBoard board = new GameBoard(BOARD_COLUMNS, BOARD_ROWS);
	        Robot robot = new Robot();
	        Game game = new Game(board,robot);

	        thrown.expect(ToyStimulatorException.class);
	        game.placeToyRobot(null);
	        thrown.expect(ToyStimulatorException.class);
	        game.placeToyRobot(new Position(0, 1, null));
	    }

	    @Test
	    public void testEval() throws ToyStimulatorException {

	    	GameBoard board = new GameBoard(BOARD_COLUMNS, BOARD_ROWS);
	        Robot robot = new Robot();
	        Game game = new Game(board, robot);

	        game.eval("PLACE 0,0,NORTH");
	        Assert.assertEquals("0,0,NORTH", game.eval("REPORT"));

	        game.eval("MOVE");
	        game.eval("RIGHT");
	        game.eval("MOVE");
	        Assert.assertEquals("1,1,EAST", game.eval("REPORT"));

	        // if it goes out of the board it ignores the command
	        for (int i = 0; i < 10; i++)
	            game.eval("MOVE");
	        Assert.assertEquals("5,1,EAST", game.eval("REPORT"));

	        //rotate on itself
	        for (int i = 0; i < 4; i++)
	            game.eval("LEFT");
	        Assert.assertEquals("5,1,EAST", game.eval("REPORT"));

	        // invalid commands
	        thrown.expect(ToyStimulatorException.class);
	        Assert.assertEquals("Invalid command", game.eval("PLACE12NORTH"));
	        thrown.expect(ToyStimulatorException.class);
	        Assert.assertEquals("Invalid command", game.eval("LEFFT"));
	        thrown.expect(ToyStimulatorException.class);
	        Assert.assertEquals("Invalid command", game.eval("RIGHTT"));
	    }

}
