import java.io.ObjectOutputStream.PutField;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.StringTokenizer;

public class Plateau {
	
	private int yMax, xMax;
	private Map<String,String> occPosition = new HashMap<>();
	
	public Plateau(String size) {
		
		if (size.matches("-?\\d+ " + "-?\\d+")) {
		
			StringTokenizer st = new StringTokenizer(size, " ");
			this.xMax = Integer.parseInt(st.nextToken());
			this.yMax = Integer.parseInt(st.nextToken());
		} else throw new InputMismatchException("Valores inválidos");
		
	}
	
	private boolean checkPos(String pos) {
		return occPosition.containsKey(pos);
	}
	
	public boolean updatePosition(String nextPos, String currentPos) {
		if (!checkPos(nextPos)) {
			occPosition.remove(currentPos);
			occPosition.put(nextPos, nextPos);
			return true;
		}
		
		else return false;
	}
	
	public boolean updatePosition(String newPos) {
		return newPosition(newPos);
	}
	
	public boolean newPosition(String pos) {
		if (pos.matches("-?\\d+ " + "-?\\d+")) {
			occPosition.put(pos, pos);
			return true;
		}
		else return false;
	}
	
}
