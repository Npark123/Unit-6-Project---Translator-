import java.util.ArrayList;
import java.util.Scanner;

public class Translator {


  private ArrayList<String> englishWords; 
  private ArrayList<String> koreanWords;
  private ArrayList<String> spanishWords;

    /*
     * Constructor method; initializes word lists from text files.
     */
public Translator(){
  englishWords = FileReader.toStringList("englishWords.txt");
  koreanWords = FileReader.toStringList("koreanWords.txt");
  spanishWords = FileReader.toStringList("spanishWords.txt");
}

    /*
     * Gets the list of English words.
     * @return An ArrayList of English words.
     */
  public ArrayList<String> getEnglish(){
    return englishWords;
  }

   /*
    * Gets the list of Korean words.
   * @return An ArrayList of Korean words.
    */
  public ArrayList<String> getKorean(){
    return koreanWords;
  }

  /*
   * Gets the list of Spanish words.
   * @return An ArrayList of Spanish words.
   */
  public ArrayList<String> getSpanish(){
    return spanishWords;
  }

  /*
   * Method finds the index of a given English word in the list.
   * @param word The English word to search for that is given by the user
   * @return The index of the word in the list. if the given word is not in the list, returns negative one
   */
public int getIndexOfEnglishWords(String word){

  for(int i = 0; i < englishWords.size(); i++){
    if (word.equals(englishWords.get(i))){
    return i;
  }
   
  }
  return -1;
   }
  



  /*
     * Allows the user to input an English word and translate it into Korean or Spanish.
     * Method uses a scanner class to take the users input in and runs the getIndexOfEnlgishWords method to find the index
     * Then uses gets the Index from the Korean words or the Spanish words list either if Spanish or Korean word was chosen
     * If -1 is the index it prints out that the value was not found
     * The user can exit the program by typing "exit".
     */
  
public void checksEnglishWord() {
    Scanner scanner = new Scanner(System.in);

      String choice = "";
  
      while (!choice.equals("exit")) { 
        
        System.out.println("\n\nType exit to end program whenever");
        System.out.println("\nWould you like to translate an English word into Korean or Spanish?");
        
      
  String wantedLanguage = scanner.nextLine().toLowerCase();
     choice = wantedLanguage;
       
        if (choice.equals("exit")) {
System.out.println("\nEnding program");
      scanner.close();   
    }
        
       else if (wantedLanguage.equals("korean")) {
            System.out.println("\nWhat word would you like to translate: (Check Spelling)");
          
            String wantedWord = scanner.nextLine().toLowerCase();
         choice = wantedWord;
           
            String translatedWord = "";

            int indexOfEnglishWord = getIndexOfEnglishWords(wantedWord);
         if (choice.equals("exit")) {
System.out.println("\nEnding program");
      scanner.close();   
    }
           else if (indexOfEnglishWord == -1) {
                System.out.println("\nThe text given is not available in our program dictionary to translate.");
            } else {
                translatedWord = koreanWords.get(indexOfEnglishWord);
                System.out.println("Before: " + wantedWord + "\nTranslated: " + translatedWord);
            }

          
      
        } else if (wantedLanguage.equals("spanish")) {
            System.out.println("\nWhat word would you like to translate: (Check Spelling)");
    
            String wantedWord = scanner.nextLine().toLowerCase();
          choice = wantedWord;
       
            String translatedWord = "";
       
         int indexOfEnglishWord = getIndexOfEnglishWords(wantedWord);
         
    if (choice.equals("exit")) {
System.out.println("\nEnding program");
      scanner.close();   
    }
        else if (indexOfEnglishWord == -1) {
                System.out.println("\nThe word given is not available in our program dictionary to translate.");
            } else {
                translatedWord = spanishWords.get(indexOfEnglishWord);
            System.out.println("\nBefore: " + wantedWord + "\nTranslated: " + translatedWord);
            }

          
        } else {
            System.out.println("\nPlease give either if you want the word to be translated to Korean or Spanish");
        }
        
}
  
} 
}