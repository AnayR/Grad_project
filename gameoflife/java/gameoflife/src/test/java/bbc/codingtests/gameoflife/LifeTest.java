package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;
import org.junit.Test;

import static org.junit.Assert.*;

import bbc.codingtests.gameoflife.LifeImpl;
import bbc.codingtests.gameoflife.Life;


public class LifeTest {

	// TODO make this test pass
	@Test
	public void testEmptyGrid() {
		String emptyStateInput = "...\n...\n...";
		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(emptyStateInput);
		assertEquals("An empty grid should stay the same", emptyStateInput, testLife.evolve(emptyState).toString());
	}

	@Test
	public void testHorizontalGrid() {
		String horzStateInput = "...\n***\n...";
		Life testLife = new LifeImpl();
		GameState newState = new GameStateImpl(horzStateInput);
		GameState newGen = testLife.evolve(newState);
		assertTrue("Row 0, col 1 should be alive", newGen.isCellAliveAt(0, 1));
		assertTrue("Row 1, col 1 should not be alive", newGen.isCellAliveAt(1, 1));
		assertTrue("Row 2, col 1 should not be alive", newGen.isCellAliveAt(2, 1));
	}

	@Test
	public void testUnderpopulation() {
		String upStateInput = "...\n.**\n...";
		Life testLife = new LifeImpl();
		GameState newState = new GameStateImpl(upStateInput);
		GameState newGen = testLife.evolve(newState);
		assertFalse("Row 1, col 1 should not be alive", newGen.isCellAliveAt(1, 1));
		assertFalse("Row 1, col 2 should not be alive", newGen.isCellAliveAt(1, 2));
	}

	@Test
	public void testOverpopulation() {
		String opStateInput = ".*.\n***\n.*.";
		Life testLife = new LifeImpl();
		GameState newState = new GameStateImpl(opStateInput);
		GameState newGen = testLife.evolve(newState);
		assertFalse("Row 1, col 1 should not be alive", newGen.isCellAliveAt(1, 1));
	}

	@Test
	public void testSurvival() {
		String stateInput = "...\n*.*\n.*.";
		Life testLife = new LifeImpl();
		GameState newState = new GameStateImpl(stateInput);
		GameState newGen = testLife.evolve(newState);
		assertTrue("Row 1, col 1 should be alive", newGen.isCellAliveAt(1, 1));
	}
}
