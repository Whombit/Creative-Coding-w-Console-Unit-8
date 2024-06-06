import java.io.IOException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        // Creating a new Scanner object to read user input from the console
        Scanner scan = new Scanner(System.in);
        
        // Prompting the user to pick a difficulty level
        System.out.println("Pick a difficulty:" + "\n-Hard" + "\n-Easy" + "\n-I don't care");
        
        // Creating an instance of the Words class to handle word operations
        Words word = new Words();

        // Initializing a boolean variable 'retry' to control retrying the input in case of errors
        boolean retry = true;
        
        // Looping until a valid difficulty is chosen
        do {
            try {
                // Reading the user input for difficulty
                String newDiff = scan.nextLine();
                
                // Setting the chosen difficulty in the Words object
                word.setDiff(newDiff);
                
                // Displaying the chosen difficulty to the user
                System.out.println("\nDifficulty chosen: " + word.getDiff());
                
                // Displaying the number of tries remaining
                System.out.println("Tries left: " + word.getTries());
                
                // Setting retry to false to exit the loop if no exception occurs
                retry = false;
            } catch (Exception e) {
                // Handling exception if the entered difficulty is invalid
                System.out.println("That's not a difficulty. Please try again.");
                
                // Setting retry to true to allow the user to try again
                retry = true;
            }
        } while (retry);

        // Checking the difficulty chosen by the user and setting the word accordingly
        if (word.getDiff().equals("hard")) {
            // Creating an instance of the hardWords class with words read from a file
            hardWords hw = new hardWords(FileReader.toStringArray("words.txt"));
            
            // Setting a random word from the list of hard words
            hw.setWord();
            
            // Displaying the length of the chosen word
            System.out.println("Chosen word length: " + hw.getWordLength());
            
            // Setting the word in the Words object
            word.setWord(hw.getWord());
        } else {
            // Creating an instance of the easyWords class with words read from a file
            easyWords ew = new easyWords(FileReader.toStringArray("words.txt"));
            
            // Setting a random word from the list of easy words
            ew.setWord();
            
            // Displaying the length of the chosen word
            System.out.println("Chosen word length: " + ew.getWordLength());
            
            // Setting the word in the Words object
            word.setWord(ew.getWord());
        }

        // Shuffling the characters of the word
        word.shuffleWord();
        
        // Displaying the shuffled word to the user
        System.out.println("Shuffled word: " + word.getGeneratedString());

        // Looping until the user guesses the word correctly or runs out of tries
        boolean correct = false;
        while (!correct && word.getTries() > 0) {
            System.out.println("Guess the word: ");
            String guess = scan.nextLine();
            if (guess.equals(word.getWord())) {
                // If the guess is correct, informing the user and ending the loop
                System.out.println("Congratulations! You guessed the word.");
                correct = true;
            } else {
                // If the guess is incorrect, decrementing the number of tries and informing the user
                word.setTries(word.getTries() - 1);
                System.out.println("Incorrect guess. Tries left: " + word.getTries());
            }
        }

        // If the user runs out of tries without guessing the word, informing the user of the correct word
        if (!correct) {
            System.out.println("Sorry, you've run out of tries. The word was: " + word.getWord());
        }

        // Closing the Scanner to release system resources
        scan.close();
    }
}
