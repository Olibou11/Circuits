// Importations
import java.util.Scanner;

// Classe ''Main''
public class Main {
    public static void main(String[] args) {

        // Initialisation du Scanner
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("\n" + "•----------------Calculatrice----------------•");
            System.out.println("\n" + "Veuiller entrer les couleurs d'une résistance.");
            System.out.print("  >>");
            Resistor resistor = FabriqueResistor.fabriquerResistor(sc.next());

            if (resistor == null){ // Entrée non valide
                System.out.println("\n" + "Ceci n'est pas une résistance.");
            }
            else // Entrée valide
                System.out.println("\n" + "Cette résistance vaut " + resistor.getResistance() + "Ω ±" + resistor.getTolerance() + "%");

        }while(true);
    }
}
