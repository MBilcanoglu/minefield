package minefield;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int row,column;
		MineSweeper mineSweeper;
		
		Scanner scan=new Scanner(System.in);
		
		System.out.print("Satır Sayısı: ");
		row=scan.nextInt();
		System.out.print("Sütun Sayısı: ");
		column=scan.nextInt();
		
		mineSweeper=new MineSweeper(row, column);
	}

}
