
public class Rover {

	private Plateau p;
	private String facinDir;
	private int posX;
	private int posY;

	public Rover(int x, int y, String dir, Plateau p) {
		posX = x;
		posY = y;
		facinDir = dir;
		this.p = p;
		p.updatePosition(x + " " + y);

	}

	public boolean updateX(int value) {
		if (value != 1 || value != -1)
			return false;
		else
			posX = value;
		return true;
	}

	public boolean updateY(int value) {
		if (value != 1 || value != -1)
			return false;
		else
			posY = value;
		return true;
	}

	public String getPosition() {
		return posX + " " + posY + " " + facinDir;
	}

	public boolean move(String mov) {
		int nposX = posX;
		int nposY = posY;
		String nDir = facinDir;
		String nextPos;
		for (int index = 0; index < mov.length(); index++) {
			char c = mov.charAt(index);
			String currentPos = posX + " " + posY;
			if (c == 'M') {
				if (facinDir == "N")
					if(posY+1>p.getYMax()) return false;
					else nposY = posY + 1;
				else if (facinDir == "S")
					if(posY-1<0) return false;
					else nposY = posY - 1;
				else if (facinDir == "E")
					if(posX+1>p.getXMax()) return false;
					else nposX = posX + 1;
				else if (facinDir == "W")
					if(posX-1<0) return false;
					else nposX = posX - 1;
				
				nextPos = nposX + " " + nposY;
				if (p.updatePosition(nextPos, currentPos)) {
					posX = nposX;
					posY = nposY;
					
					
				} 
			} else if (c == 'L') {
				if (facinDir == "N")
					nDir = "W";
				if (facinDir == "W")
					nDir = "S";
				if (facinDir == "S")
					nDir = "E";
				if (facinDir == "E")
					nDir = "N";
			} else if (c == 'R') {
				if (facinDir == "N")
					nDir = "E";
				if (facinDir == "E")
					nDir = "S";
				if (facinDir == "S")
					nDir = "W";
				if (facinDir == "W")
					nDir = "N";
			} else return false;
			facinDir = nDir;
			

		}
		return true;

	}

}
