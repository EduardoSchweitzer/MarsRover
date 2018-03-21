
import java.util.InputMismatchException;
import java.util.Scanner;
public class App {
	public static void main(String[] args) {
		
		Plateau p = new Plateau("0 0");
		Rover r1 = new Rover("0 0 N", p);
		
		Scanner in = new Scanner(System.in);
		boolean quit = false;
		String input = "";
		
		System.out.println("Digite as cordenadas da borda superior direita do grid.");
		
		while (input == "") {
			input = in.nextLine();
			try {
				p = new Plateau(input);
			} catch (InputMismatchException e) {
				input = "";
				System.out.println("Valor inválido");
			}
		}
		
		while (!quit) {
			input = "";
			System.out.println("Informe a posição inicial do Rover: ");
			while (input == "") {
				input = in.nextLine();
				r1 = new Rover(input, p);
				
			}
			
			input = "";
			System.out.println("Informe a sequencia de movimentos do Rover: ");
			while (input == "") {
				input = in.nextLine();
				r1.move(input);
			}
			System.out.println("Posicao final do Rover: " + r1.getPosition());
			System.out.println("Gostaria de enviar outro Rover? (Y/N)");
			input = in.nextLine();
			quit = input.matches("N") || input.matches("n");
			
		}

	}
}
