package whatevator;

import java.util.ArrayList;

public class Letrator {
	public ArrayList<Integer> getIndiceMaisculas(String palavra){
		ArrayList<Integer> aux = new ArrayList<>();
		for(int i=0;i<palavra.length();i++){
			if(Character.isUpperCase(palavra.charAt(i))){
				aux.add(i);
			}
		}
		return aux;
	}
}
