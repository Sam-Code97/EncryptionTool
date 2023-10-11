import java.util.Arrays;

import javax.swing.JOptionPane;

public class EncryptionEngine {
	private Controller controller;
	private int encryptionKey;
	
	EncryptionEngine(Controller _controller){
		
	}
	
	public void setEncryptionKey(int key){
		encryptionKey = key % 26;
	}
	
	public int getEncryptionKey(){
		return encryptionKey;
	}
	
	public String encrypt(String inputText) { //inputText should be bringed from view
		
		String output = "";
		char[] inCharArr = inputText.toCharArray();
		
		for(int i=0; i<inCharArr.length; i++) {
			inCharArr[i] -= 'A';
			inCharArr[i] += encryptionKey + 26;
			inCharArr[i] %= 26;
			inCharArr[i] += 'A';
			output += inCharArr[i]; 
		}
		return output;
	}
	
	public String decrypt(String inputText) { //inputText should be bringed from view
		String output = "";
		char[] inCharArr = inputText.toCharArray();
		for(int i=0; i<inCharArr.length; i++) {
			int letter = inCharArr[i];
			letter -= 'A';
			letter += 26;
			letter -= encryptionKey;
			letter = (letter + 26) % 26;
			letter += 'A';
			output += (char)letter; 
		}
		return output;
	}
}
