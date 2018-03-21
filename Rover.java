import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class Rover {

	private Plateau p;
	private String facinDir;
	private int posX;
	private int posY;

	public Rover(String position, Plateau p) {

		if (position.matches("-?\\d+ " + "-?\\d+ " + "[A-Za-z]")) {
			StringTokenizer st = new StringTokenizer(position, " ");
			this.posX = Integer.parseInt(st.nextToken());
			this.posY = Integer.parseInt(st.nextToken());
			this.facinDir = st.nextToken();
		} else
			throw new InputMismatchException("Formato Invalido");

		this.p = p;
		p.updatePosition(posX + " " + posY);

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
				if (facinDir.matches("N"))
					if(posY+1>p.getYMax()) return false;
					else nposY = posY + 1;
				else if (facinDir.matches("S"))
					if(posY-1<0) return false;
					else nposY = posY - 1;
				else if (facinDir.matches("E"))
					if(posX+1>p.getXMax()) return false;
					else nposX = posX + 1;
				else if (facinDir.matches("W"))
					if(posX-1<0) return false;
					else nposX = posX - 1;
				
				nextPos = nposX + " " + nposY;
				if (p.updatePosition(nextPos, currentPos)) {
					posX = nposX;
					posY = nposY;
					
					
				} 
			} else if (c == 'L') {
				if (facinDir.matches("N"))
					nDir = "W";
				if (facinDir.matches("W"))
					nDir = "S";
				if (facinDir.matches("S"))
					nDir = "E";
				if (facinDir.matches("E"))
					nDir = "N";
			} else if (c == 'R') {
				if (facinDir.matches("N"))
					nDir = "E";
				if (facinDir.matches("E"))
					nDir = "S";
				if (facinDir.matches("S"))
					nDir = "W";
				if (facinDir.matches("W"))
					nDir = "N";
			} else return false;
			facinDir = nDir;
			

		}
		return true;

	}

}
