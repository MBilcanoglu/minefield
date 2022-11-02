package minefield;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
	int row;
	int column;
	String[][] mineField;

	MineSweeper(int row, int column) {
		this.row = row;
		this.column = column;
		addMines();
	}

	void run(int row, int column) {
		int rowValue, columnValue;
		Scanner scan = new Scanner(System.in);
		boolean isWin = true;
		int count = 0;
		while (isWin && ((count+(row * column/4)) != (row * column))) {
			showMine(false);
			System.out.print("Satır Giriniz: ");
			rowValue = scan.nextInt();
			System.out.print("Sütun Giriniz: ");
			columnValue = scan.nextInt();
			if (!(rowValue >= 0 && rowValue < this.row) || !(columnValue >= 0 && columnValue < this.column)) {
				System.out.println("Hatalı giriş yaptınız!!!!");
				System.out.println("===================================");
				continue;
			}
			if (mineField[rowValue][columnValue].equals("x")) {
				isWin = false;
				break;
			}
			Object value=control(rowValue, columnValue);
			this.mineField[rowValue][columnValue]=value.toString();
			count++;
			System.out.println("===================================");

		}

		if (isWin) {
			System.out.println("********Oyunu Kazandınız !********");
			showMine(isWin);
		} else {
			System.out.println("********Game Over!!********");
		}
		System.out.println("===================================");


	}

	int control(int row, int column) {
		int count = 0;

		if ((column + 1 > 0) && (column + 1 < this.column)) {
			if (mineField[row][column + 1].equals("x")) {
				count++;
			}
		}

		if ((column - 1 >= 0) && (column - 1 < this.column)) {
			if (mineField[row][column - 1].equals("x")) {
				count++;
			}
		}

		if ((row + 1 > 0) && (row + 1 < this.row)) {
			if (mineField[row + 1][column].equals("x")) {
				count++;
			}

			if ((column - 1 >= 0) && (column - 1 < this.column)) {
				if (mineField[row + 1][column - 1].equals("x")) {
					count++;
				}
			}

			if ((column + 1 > 0) && (column + 1 < this.column)) {
				if (mineField[row + 1][column + 1].equals("x")) {
					count++;
				}
			}
		}

		if ((row - 1 >= 0) && (row - 1 < this.row)) {
			if (mineField[row - 1][column].equals("x")) {
				count++;
			}
			if ((column - 1 >= 0) && (column - 1 < this.column)) {
				if (mineField[row - 1][column - 1].equals("x")) {
					count++;
				}
			}
			if ((column + 1 > 0) && (column + 1 < this.column)) {
				if (mineField[row - 1][column + 1].equals("x")) {
					count++;
				}
			}
		}

		return count;
	}

	void addMines() {
		mineField = new String[this.row][this.column];
		Random random = new Random();
		int mineCount = ((row * column) / 4) - 1;
		int mineRowLoc = random.nextInt(row);
		int mineColLoc = random.nextInt(column);
		mineField[mineRowLoc][mineColLoc] = "x";
		while (mineCount != 0) {
			int tempRowLoc = random.nextInt(row);
			int tempColLoc = random.nextInt(column);
			if (mineRowLoc != tempRowLoc && mineColLoc != tempColLoc) {
				mineRowLoc = tempRowLoc;
				mineColLoc = tempColLoc;

				mineField[mineRowLoc][mineColLoc] = "x";

				mineCount--;
			}
		}
		run(row, column);
	}

	void showMine(boolean isWin) {
		for (int i = 0; i < this.mineField.length; i++) {
			for (int k = 0; k < mineField[i].length; k++) {
				if(isWin) {
					System.out.print(this.mineField[i][k]);
				}else {
					if (this.mineField[i][k] == null ) {
						mineField[i][k] = "-";
						System.out.print("-");
					}else {
						if(this.mineField[i][k].equals("x")) {
							System.out.print("-");
						}else {
							System.out.print(mineField[i][k]);
						}
					}
				}
			}
			System.out.println();
		}
	}

}
