
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// This is a dummy Controller, so the View compiles



public class Controller {
	private View view;
	private EncryptionEngine encryptionEngine;
	
	Controller(){
		encryptionEngine = new EncryptionEngine(this);
		view = new View(this);
	}
	
	private boolean isValidEncryptionKey(String key) {
		
		int i = 0;
		do {
		    if (key.isEmpty() || !Character.isDigit(key.charAt(i))) {
		        JOptionPane.showMessageDialog(null, "Enter A Positive Encryption Key In Digits! (Avoid 0 and 26)", "Error", JOptionPane.ERROR_MESSAGE);
		        return false;
		    }
		    i++;
		} while (i < key.length());
		
		int intKey = Integer.parseInt(key);
		if(intKey == 0 || intKey == 26) {
	        JOptionPane.showMessageDialog(null, "Avoid 0 and 26!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}
			
	
	private boolean isValidInput(String input) {
		int i = 0;
		
		do{
			if(input.isEmpty() || !Character.isUpperCase(input.charAt(i))) {
				JOptionPane.showMessageDialog(null, "Enter An Input Text In Uppercase Letters!", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			i++;
		}while(i<input.length());
		
		return true;
	}
		

	
	public void encryptButtonClicked() {
		
		if(isValidEncryptionKey(view.getEncryptionKey())) {
			int key = Integer.parseInt(view.getEncryptionKey());
			encryptionEngine.setEncryptionKey(key);
			
			if( isValidInput(view.getInputText()) ) {
				String encrypted = encryptionEngine.encrypt(view.getInputText());
				view.setOutputText(encrypted);
			}
		}
	}
	
	public void decryptButtonClicked() {
		
		if(isValidEncryptionKey(view.getEncryptionKey())) {
			int key = Integer.parseInt(view.getEncryptionKey());
			encryptionEngine.setEncryptionKey(key);
			
			if( isValidInput(view.getInputText()) ) {
				String decrypted = encryptionEngine.decrypt(view.getInputText());
				view.setOutputText(decrypted);
			}
		}
	}
}
