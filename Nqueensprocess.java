  
package backTracking;

import java.io.IOException;
import java.util.Scanner;
public class Nqueensprocess {
	
	static int[] rows = new int[32];
	static boolean findSolution =false;

	static boolean valid(int row, int column) {
		for (int lastPlayed = 0; lastPlayed < column; lastPlayed++) {
			if (rows[lastPlayed] == row || Math.abs(rows[lastPlayed] - row) == Math.abs(lastPlayed-column)) {
				return false;
			}
		}
		return true;
	}

	static void solution(int column) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		if(n>0 || n<=32) {
		if (column == n) {
			for (int i = 0; i < n; i++) {
				System.out.print("[" + (rows[i] + 1) + "] ");
			}
			System.out.println();
			findSolution = true;
			return;
		}
		for (int row = 0; row < n; row++) {
			if (valid(row, column)) {

				rows[column] = row;
				solution(column + 1);
				if(findSolution) {
					break;
				}
			}
		}
	}
}

	public static void main(String[] args) throws IOException {
		solution(0);
	}
}
