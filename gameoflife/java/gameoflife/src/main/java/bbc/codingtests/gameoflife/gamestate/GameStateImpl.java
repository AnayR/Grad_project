package bbc.codingtests.gameoflife.gamestate;

public class GameStateImpl implements GameState {

	// TODO implement this method such that live cells are represented as a '*'
	// and dead cells are represented by a '.'
	// TODO use newline ('\n') to separate rows
	public boolean[][] cells;
	char[][] newArray = new char[3][3];
	String currentState = "";

	@Override
	public String toString() {
		return currentState;
	}

	// TODO implement this constructor to parse an input string and return a new
	// GameStateImpl object representing what you got in the string
	// TODO as above, live cells are '*' and dead cells are '.' Rows are
	// separated by newline ('\n')
	public GameStateImpl(String input) {
		currentState = input;
	}

	// TODO implement this method according to explanation in GameState.java
	public boolean isCellAliveAt(int row, int col) {
		char[] grid = currentState.toCharArray();
		// convert to 2d array
		int size = grid.length;
		for (int i = 0, j = 0, k = 0; i < size; i++) {
			if (grid[i] == '\n') {
				j++; // start next row
				k = 0; // start columns from 0
			} else {
				newArray[j][k] = grid[i];
				k++;
			}
		}
		if (newArray[row][col] == '*') {
			return true;
		} else
			return false;
	}

	@Override
	public int numberOfRows() {
		return newArray.length;
	}

	@Override
	public int numberOfColumns() {
		return newArray[0].length;
	}
}
