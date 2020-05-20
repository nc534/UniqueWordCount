import java.util.Scanner;

public class UniqueWords {

	private static String[] words; //so all methods in the class can access this

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter some repeated words: \n");
		
			String input = sc.nextLine().toLowerCase();
			
			System.out.println();

				words = input.split(" "); //split String to String array
				
				wordCounter(words);
				
		sc.close();
				
	}
	
	public static String[] sortAlphabetically(String[] words) {
		
		String temp = null;
		
		for(int i = 0; i < words.length -1; i++) {
		
			for(int j = i + 1; j < words.length; j++) {
				
				if(words[i].compareTo(words[j]) > 0) {
					
					temp = words[i];
					words[i] = words[j];
					words[j] = temp;
					
				}
			}
		}
		
		return words;
	
	}
	
	public static void wordCounter(String[] uniqueWord) {
		
		int count = 1;
		uniqueWord = sortAlphabetically(words);
			
		for(int i = 0; i < uniqueWord.length; i++) {
				
			for(int j = i + 1; j < uniqueWord.length; j++) {
					
				if(uniqueWord[i].equals(uniqueWord[j])) {
					
					count += 1;
					uniqueWord[j] = "0"; //Replace repeated words with zero
				
				}
					
			}
			
			if(uniqueWord[i] != "0") { //in order to not print the repeated words
				
				System.out.println(uniqueWord[i] + ": " + count);
				
				count = 1; //reset back to 1 so it won't keep counting
			}
		}
		
	}

}
