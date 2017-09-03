import java.util.Random;
import java.util.Scanner;

public class WhackAMole {
	private int score;
	private int molesLeft;
	private int attemptsLeft;
	private char[][] moleGrid;
	
	public WhackAMole (int numAttempts, int gridDimension) {
		this.attemptsLeft = numAttempts;
		this.moleGrid = new char[gridDimension][gridDimension];
		for (int i = 0; i < gridDimension; i++) {
			for (int j = 0; j < gridDimension; j++) {
				moleGrid[i][j] = '*';
			}
		}
	}
	
	void randomPlaceAll(int numb){
		Random rand = new Random();
		while (this.molesLeft < numb) {
			int row = rand.nextInt(10);
			int column = rand.nextInt(10);
			place(row, column);
		}
	}
	
	boolean place(int x, int y) {
		if (moleGrid[x][y] == '*') {
			moleGrid[x][y] = 'M';
			molesLeft++;
			return true;
		} else {
			return false;
		}
		
	}
	
	void whack(int x, int y) {
		if (x > 9 || x < 0 || y > 9 || y < 0) {
			throw new IllegalArgumentException();
		}
		if (moleGrid[x][y] == 'M') {
			moleGrid[x][y] = 'W';
			score++;
			molesLeft--;
		}
		attemptsLeft--;
	}
	
	void printGridToUser() {
		for (int i = 0; i < moleGrid.length; i++) {
			for (int j = 0; j < moleGrid[0].length; j++) {
				if (moleGrid[i][j] == 'W') {
					System.out.print(moleGrid[i][j] + " ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}
	
	void printGrid() {
		for (int i = 0; i < moleGrid.length; i++) {
			for (int j = 0; j < moleGrid[0].length; j++) {
				System.out.print(moleGrid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WhackAMole wam = new WhackAMole(5, 10);
		wam.printGrid();
		wam.randomPlaceAll(40);
		System.out.println("Game start!");
		System.out.println("Whack at: x  y(both from 0 to 9)\n(-1 -1) means give up");
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		String[] inputs = input.trim().split(" ");
		int x = Integer.parseInt(inputs[0]);
		int y = Integer.parseInt(inputs[1]);
		while (x != -1 && y != -1 && wam.attemptsLeft > 0) {
			wam.whack(x, y);
			wam.printGridToUser();
			System.out.println("Whack at: x  y(both from 0 to 9)\n(-1 -1) means give up");
			input = scanner.nextLine();	
			inputs = input.trim().split(" ");
			x = Integer.parseInt(inputs[0]);
			y = Integer.parseInt(inputs[1]);
		}
		System.out.println("Game over!");
		System.out.println("Your score is: " + wam.score);
		wam.printGrid();

	}

}
