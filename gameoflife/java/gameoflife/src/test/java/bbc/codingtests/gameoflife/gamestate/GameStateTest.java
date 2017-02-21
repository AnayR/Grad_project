package bbc.codingtests.gameoflife.gamestate;

import org.junit.Test;

import static org.junit.Assert.*;
import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;
import bbc.codingtests.gameoflife.Life;
import bbc.codingtests.gameoflife.LifeImpl;

public class GameStateTest {

    		@Test
    		public void testParsing() {
    		String input1 = ".*.\n*.*\n...";
    		GameState testState = new GameStateImpl(input1);  
    		assertTrue("Row 0, col 1 should be alive", testState.isCellAliveAt(0, 1));
    		assertFalse("Row 2, col 2 should not be alive", testState.isCellAliveAt(2, 2));
    		}

    		@Test
    		public void testRowColCounts() {
    		String input2 = "...\n***\n..*";
    		GameState testState = new GameStateImpl(input2);			
    		assertEquals("The game should have 3 columns", 3, testState.numberOfColumns());
    		assertEquals("The game should have 3 rows", 3, testState.numberOfRows());
    		}

    }
