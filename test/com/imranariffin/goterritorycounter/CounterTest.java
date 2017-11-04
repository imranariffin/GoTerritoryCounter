package com.imranariffin.goterritorycounter;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CounterTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test_CountTerritory_ReturnsNumberOfTerritory_GivenBoardAndStoneIdentifier() throws Exception {
		int[][] board1 = new int[][] {
			{2, 2, 2},
			{2, 0, 2},
			{2, 2, 2}
		};
		assertEquals(1, Counter.countTerritory(board1, "white"));
		
		int[][] board2 = new int[][] {
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{1, 2, 0, 2, 0, 0, 1, 0},
			{2, 0, 2, 2, 2, 2, 1, 0},
			{0, 2, 1, 2, 0, 0, 2, 1},
			{0, 0, 1, 1, 2, 2, 2, 1},
			{0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
		};
		assertEquals(3, Counter.countTerritory(board2, "white"));
	}
	
	@Test
	void test_CountTerritory_ReturnsNumberOfTerritory_GivenBoardAndStoneIdentifierAndTerritoryOnSide() 
			throws Exception {
		int[][] board = new int[][] {
			{0, 0, 0, 0, 0, 0, 2, 0},
			{0, 0, 0, 0, 0, 0, 2, 0},
			{1, 2, 0, 2, 0, 0, 2, 0},
			{2, 0, 2, 2, 2, 2, 1, 2},
			{0, 2, 1, 2, 0, 0, 2, 1},
			{0, 0, 1, 1, 2, 2, 2, 1},
			{0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
		};
		assertEquals(6, Counter.countTerritory(board, "white"));
	}
	
	@Test
	void test_countTerritory_ReturnsNumberOfWhiteTerritory_GivenComplexBoard_1() 
			throws Exception {
		int[][] board = new int[][] {
			{0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,1,0,0,0,0,0,0,0},
			{0,1,2,2,2,1,0,0,0,0,0,0,0},
			{0,1,1,2,2,1,1,0,0,0,0,0,0},
			{0,1,2,2,0,2,1,1,0,0,0,0,0},
			{1,1,0,2,2,2,2,1,0,0,0,0,0},
			{1,2,2,2,2,0,2,1,1,1,1,1,1},
			{2,2,2,2,2,2,0,2,2,2,1,2,1},
			{0,2,2,0,2,0,0,2,0,2,2,2,2},
			{2,2,0,2,0,0,2,2,2,0,2,0,2},
			{0,0,2,2,0,2,2,2,0,0,2,2,2},
			{2,2,0,2,2,0,0,2,0,0,2,2,0},
			{0,2,2,0,0,2,2,0,0,0,2,0,2},
		};
		assertEquals(31, Counter.countTerritory(board, "white"));
	}
}
