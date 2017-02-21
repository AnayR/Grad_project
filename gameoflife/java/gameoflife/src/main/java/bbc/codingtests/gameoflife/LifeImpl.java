package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;

public class LifeImpl implements Life {
	char[][] newArray = new char[3][3];
	boolean isAlive;
	int numberOfNeighbors;
	char[][] grid = new char[3][3];
	char[][] board = new char[newArray.length][newArray[0].length];
	char[][] initialboard = new char[newArray.length][newArray[0].length];
	char[][] nextBoard = new char[newArray.length][newArray[0].length];

	public GameState evolve(GameState currentState) {
		char[] grid = currentState.toString().toCharArray();
		// convert to 2d array
		int k = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3;) {
				if (grid[k] == '\n') {
					k++;
					j = 0;
				} else {
					newArray[i][j] = grid[k];
					k++;
					j++;
				}
			}
		}
		initialboard = newArray;
		nextBoard = nextGeneration(initialboard);

		// convert 2d array to string
		String nstr = "";
		String newstr = "";
		int j;
		for (int i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				nstr += nextBoard[i][j];
			}
			nstr += "\n";
		}
		newstr = nstr.trim();
		GameState gm = new GameStateImpl(newstr);
		return gm;
	}

	public char[][] nextGeneration(char[][] initialboard) {
		for (int i = 0; i < initialboard.length; i++) {
			for (int j = 0; j < initialboard[i].length; j++) {
				if (initialboard[i][j] == '*' && (countSurrounding(i, j) == 0 || countSurrounding(i, j) == 1)) {
					board[i][j] = '.';
				} else if (initialboard[i][j] == '*' && (countSurrounding(i, j) == 2 || countSurrounding(i, j) == 3)) {
					board[i][j] = '*';
				} else if (initialboard[i][j] == '*' && (countSurrounding(i, j) >= 4)) {
					board[i][j] = '.';
				} else if (initialboard[i][j] == '.' && countSurrounding(i, j) == 3) {
					board[i][j] = '*';
				} else if (initialboard[i][j] == '.' && countSurrounding(i, j) < 3) {
					board[i][j] = '.';
				}
			}
		}
		return board;
	}

	public int countSurrounding(int row, int col) {
		int count = 0;
		for (int i = row - 1; i <= row + 1; i++) {
			if (i >= 0 && i < initialboard.length) // fixed here
				for (int j = col - 1; j <= col + 1; j++)
					if (j >= 0 && j < initialboard[i].length) // fixed here
						if (i != row || j != col)
							if (initialboard[i][j] == '*')
								count++;
		}
		return count;
	}
}