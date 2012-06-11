package array;
public class SpiralOrder {

	public void printSpiralOrder(int[][] array, int xMax, int yMax) {

		int xStart = 0;
		int yStart = 0;

		yMax--;
		xMax--;

		while (xStart <= xMax && yStart <= yMax) {

			for (int i = yStart; i <= yMax; i++) {
				System.out.println(array[xStart][i]);
			}

			xStart++;
			for (int i = xStart; i <= xMax; i++) {
				System.out.println(array[i][yMax]);
			}

			yMax--;
			for (int i = yMax; i >= yStart; i--) {
				System.out.println(array[xMax][i]);
			}

			xMax--;
			for (int i = xMax; i >= xStart; i--) {
				System.out.println(array[i][yStart]);
			}
			yStart++;

		}
	}

	public static void main(String[] args) {
		int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		SpiralOrder spiralOrder = new SpiralOrder();

		spiralOrder.printSpiralOrder(array, 3, 3);

	}

}
