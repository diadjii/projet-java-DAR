/**
 * 
 */
package flux.assoc.metier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author diadji
 *
 */
public abstract class Contributeurs {
	protected String nom;
	protected String adresse;
	protected String info = "";

	public Contributeurs() {

	}

	public Contributeurs(String nom, String adresse) {
		setNom(nom);
		setAdresse(adresse);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * 
	 * @param name
	 * @return true or false
	 */

}
