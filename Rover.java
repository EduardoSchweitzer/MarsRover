
public class Rover {

	
	private Plateau p;
	private String facinDir;
	private int posX;
	private int posY;
	
	public Rover(int x, int y, String dir,Plateau p) {
		posX=x;
		posY=y;
		facinDir=dir;
		this.p=p;
		p.update(x+" "+y);
		
	}
	
	
	public boolean updateX(int value) {
		if (value!=1 || value!=-1) return false;
		else posX=value;
		return true;
	}
	
	
	public boolean updateY(int value) {
		if (value!=1 || value!=-1) return false;
		else posY=value;
		return true;
	}
	
	
	public boolean move(String mov) {
		int nposX;
		int nposY;
		String nDir;
		String nextPos;
		String currentPos=posX + " " + posY;
		for (int index = 0; index < mov.length(); index++) {
				     char c = mov.charAt(index);
				     if(c=='M') {
				    	 if(facinDir=="N") nposY=posY+1;
				    	 else if(facinDir=="S") nposY=posY-1;
				    	 else if(facinDir=="E") nposX=posX+1;
				    	 else if(facinDir=="W") nposX=posX-1;
				     }
				     else if(c=='L') {
				    	 if(facinDir=="N") nDir="W";
				    	 if(facinDir=="W") nDir="S";
				    	 if(facinDir=="S") nDir="E";
				    	 if(facinDir=="E") nDir="N";
				     }
				     else if(c=='R') {
				    	 if(facinDir=="N") nDir="E";
				    	 if(facinDir=="E") nDir="S";
				    	 if(facinDir=="S") nDir="W";
				    	 if(facinDir=="W") nDir="N";
				     }
				     nextPos=nposX+" "+nposY;
				     if(p.updatePosition(nextPosition,currentPosition)) {
				    	 posX=nposX;
				    	 posY=nposY;
				     }
				     
				     
				}
		
		
		
	}
	
	
	
	
	
	
}




