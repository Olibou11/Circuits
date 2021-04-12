// Importation package
package ca.cegepjonquiere.simulohmatique.resistor;

// Importations
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Classe ''ca.cegepjonquiere.resistor.FabriqueResistor''
public class FabriqueResistor {

    // Constructeur
    public FabriqueResistor() {
    }

    // Méthode''fabriqueResistor''
    public static Resistor fabriquerResistor(String couleurs) throws IllegalArgumentException{

        // Regarde si la couleur est null pour éviter le plantage
        if(couleurs == null)
            throw new IllegalArgumentException("Erreur dans les couleurs invalides");

        // Vérification du String couleur
        Pattern patronCouleur = Pattern.compile("[NBROJVbMLG]{2,3}[NBROJVbMLoAG][BROJVbMoAG]");
        Matcher matcher = patronCouleur.matcher(couleurs);

        if(matcher.find()){ // Match trouvé

            if(couleurs.length() == 4){ // Résisteurs qui contiennent 4 couleurs
                CodeCouleur premier = CodeCouleur.valueOf(couleurs.substring(0, 1));
                CodeCouleur deuxieme = CodeCouleur.valueOf(couleurs.substring(1, 2));
                CodeCouleur troisieme = CodeCouleur.valueOf(couleurs.substring(2, 3));
                CodeCouleur quatrieme = CodeCouleur.valueOf(couleurs.substring(3, 4));
                return new Resistor((deuxieme.getValeur() + (premier.getValeur()*10))*troisieme.getMultiplicateur(), quatrieme.getTolerance());
            }
            if (couleurs.length() == 5){ // Résisteurs qui contiennent 5 couleurs
                CodeCouleur premier = CodeCouleur.valueOf(couleurs.substring(0, 1));
                CodeCouleur deuxieme = CodeCouleur.valueOf(couleurs.substring(1, 2));
                CodeCouleur troisieme = CodeCouleur.valueOf(couleurs.substring(2, 3));
                CodeCouleur quatrieme = CodeCouleur.valueOf(couleurs.substring(3, 4));
                CodeCouleur cinquieme = CodeCouleur.valueOf(couleurs.substring(4, 5));
                return new Resistor(((premier.getValeur() * 100) + (deuxieme.getValeur() * 10) + troisieme.getValeur()) * quatrieme.getMultiplicateur(), cinquieme.getTolerance());
            }
            else
                throw new IllegalArgumentException("Erreur trop de couleur");
        }
        else // Match non trouvé
            throw new IllegalArgumentException("Erreur de la fabrication de résistor plus de 5 couleurs ou moins de 4 couleurs");
    }
}
