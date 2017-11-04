package com.imranariffin.goterritorycounter;

public class Counter {
	private static boolean[][] visited;
	private static boolean isTerritory = false;
	
	public static int countTerritory(int[][] board, String whichStone) throws Exception {
		if (!whichStone.equals("white") && !whichStone.equals("black")) {
			throw new Exception("stone must be either 'white' or 'black'");
		}
		int territorySize = 0;
		int stone = whichStone.equals("black") ? 1 : 2;
		int len = board.length;
		
		visited = new boolean[len][len];
		
		for (int i=0; i<len; i++) {
			for (int j=0; j<len; j++) {
				if (board[i][j] == 0 && !visited[i][j]) {
					isTerritory = true;
					int r = dfs(board, stone, i, j);
					territorySize = isTerritory ? territorySize + r : territorySize; 
				}
			}
		}
		
		return territorySize;
	}

	private static int dfs(int[][] board, int stone, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board.length) {
			return 0;
		}
		if (visited[i][j]) {
			return 0;
		}
		if (board[i][j] != 0 && board[i][j] != stone) {
			isTerritory = false;
			return 0;
		}
		if (board[i][j] != 0) {
			return 0;
		}
		
		int ret = 1;
		visited[i][j] = true;
		
		ret += dfs(board, stone, i - 1, j);
		ret += dfs(board, stone, i + 1, j);
		ret += dfs(board, stone, i, j - 1);
		ret += dfs(board, stone, i, j + 1);
		
		return ret;
	}
}
