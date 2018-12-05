package flux.assoc.metier;

/**
 * 
 * @author diadji
 *
 */
public class Tiers extends Contributeurs {
	private String type;

	/**
	 * 
	 * @param nom
	 * @param adresse
	 * @param type
	 */
	public Tiers(String nom, String adresse, String type) {

		super(nom, adresse);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
