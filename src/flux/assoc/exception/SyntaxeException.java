package flux.assoc.exception;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class SyntaxeException extends Exception {
	public SyntaxeException(String message) {
		JOptionPane.showMessageDialog(null, message, "Erreur Syntaxe", JOptionPane.ERROR_MESSAGE);
	}
}
