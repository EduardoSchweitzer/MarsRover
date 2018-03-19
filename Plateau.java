import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Plateau {
	
	private int yMax, xMax;
	private Map<String,String> occPosition = new HashMap<>();
	
	public Plateau(String size) {
		
		StringTokenizer st = new StringTokenizer(size, " ");
		this.xMax = Integer.parseInt(st.nextToken());
		this.yMax = Integer.parseInt(st.nextToken());
		
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
	
}
