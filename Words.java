import java.util.Random;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Words {
    // Declaring instance variables to store words, difficulty, tries, and shuffled word
    private String[] words;
    private int difficulty;
    private int tries;
    private String generatedString;
    private String currentWord;
    private Random random = new Random(); // Random number generator

    // Constructor initializing instance variables with default values
    public Words() {
        this.words = new String[0];
        this.difficulty = 3;
        this.tries = 5;
    }

    // Constructor initializing instance variables with words from a sentence
    public Words(String sentence) {
        this.words = sentence.split(" ");
        this.difficulty = 3;
        this.tries = 5; // Default tries
    }

    // Method to retrieve the current word
    public String getWord() {
        return currentWord;
    }

    // Method to retrieve the difficulty level in string format
    public String getDiff() {
        if (difficulty == 2) {
            return "hard";
        } else if (difficulty == 1) {
            return "easy";
        } else {
            return "unknown"; // For the default case or any other unexpected value
        }
    }

    // Method to set a new word
    public void setWord(String newWord) {
        words = new String[]{newWord};
        currentWord = newWord;
    }

    // Method to set the difficulty level
    public void setDiff(String newDiff) throws Exception {
        if (newDiff.equalsIgnoreCase("hard")) {
            this.difficulty = 2;
        } else if (newDiff.equalsIgnoreCase("i dont care")) {
            this.difficulty = random.nextBoolean() ? 1 : 2; // Randomly set difficulty to 1 or 2
        } else if (newDiff.equalsIgnoreCase("easy")) {
            this.difficulty = 1;
        } else {
            throw new Exception("Invalid difficulty level. Please enter 'easy', 'i dont care', or 'hard'.");
        }
        setTries(); // Set tries based on difficulty
    }

    // Method to retrieve the number of tries remaining
    public int getTries() {
        return tries;
    }

    // Method to manually set the number of tries
    public void setTries(int tries) {
        this.tries = tries;
    }

    // Method to set the number of tries based on the difficulty level
    private void setTries() {
        if (difficulty == 1) {
            this.tries = 10;
        } else {
            this.tries = 7;
        }
    }

    // Method to retrieve the length of the current word
    public int getWordLength() {
        return currentWord.length();
    }

    // Method to shuffle the characters of the current word
    public void shuffleWord() {
        if (currentWord == null) return;

        // Convert the word into a list of characters
        List<Character> characters = new ArrayList<>();
        for (char c : currentWord.toCharArray()) {
            characters.add(c);
        }
        
        // Shuffle the characters randomly
        Collections.shuffle(characters, random);
        
        // Reconstruct the shuffled word
        StringBuilder shuffledWord = new StringBuilder();
        for (char c : characters) {
            shuffledWord.append(c);
        }
        
        // Store the shuffled word
        generatedString = shuffledWord.toString();
    }

    // Method to retrieve the shuffled word
    public String getGeneratedString() {
        return generatedString;
    }
}
