
public class App {
	public static void main(String[] args) {
		
		boolean quit = false;
		while (!quit) {
			System.out.println("Digite as cordenadas da borda superior direita do ");
			
		}
		
		Plateau p = new Plateau("5 5");
		Rover r1 = new Rover(1, 2, "N", p);
		Rover r2 = new Rover(3, 3, "E", p);
		r1.move("LMLMLMLMM");
		System.out.println(r1.getPosition());
		System.out.println();
		r2.move("MMRMMRMRRM");
		System.out.println(r2.getPosition());
		System.out.println();
	}
}
