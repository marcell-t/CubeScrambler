/**
 * Side.java
 * 
 * @author Elliot Penson
 */

package cube;

import java.awt.Color;

public class Side {
	
	/**
	 * Representation of the set of stickers on this side
	 */
	private Color[][] stickers;

	/**
	 * Sets the side to the given grid of colors
	 * @param stickers
	 */
	public Side(Color[][] stickers) {
		stickers = new Color[3][3];
	}

	/**
	 * Instantiates each sticker with a single color
	 * @param c
	 */
	public Side(Color c) {
		stickers = new Color[3][3];
		// TODO change to a for-each
		for(int x = 0; x < stickers.length; x++) 
			for(int y = 0; y < stickers.length; y++) 
				stickers[x][y] = c;
	}
	
	public void rotateStickers() {
		// rotate edges
		Color edgeBuffer = stickers[1][0];
		stickers[1][0] = stickers[2][1];
		stickers[2][1] = stickers[1][2];
		stickers[1][2] = stickers[0][1];
		stickers[0][1] = edgeBuffer;
		
		// rotate corners
		Color cornerBuffer = stickers[0][0];
		stickers[0][0] = stickers[2][0];
		stickers[2][0] = stickers[2][2];
		stickers[2][2] = stickers[0][2];
		stickers[0][2] = cornerBuffer;
	}

	public Color[] getRow(int y) {
		Color[] toReturn = new Color[3];
		for(int x = 0; x < 3; x++) {
			toReturn[x] = stickers[x][y];
		}
		return toReturn;
	}
	
	public void setRow(Color[] row, int y) {
		for(int x = 0; x < row.length; x++)
			stickers[x][y] = row[x];
	}

	public Color[] getColumn(int x) {
		Color[] toReturn = new Color[3];
		for(int y = 0; y < 3; y++) {
			toReturn[y] = stickers[x][y];
		}
		return toReturn;
	}
	
	public void setColumn(Color[] column, int x) {
		for(int y = 0; y < column.length; y++)
			stickers[x][y] = column[y];
	}
}