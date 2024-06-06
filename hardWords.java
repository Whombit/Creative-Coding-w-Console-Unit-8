public class hardWords extends Words {
    // Declaring an instance variable to store an array of words
    private String[] wordsData;

    // Constructor that takes an array of words as input
    public hardWords(String[] wordsFile) {
        // Calling the constructor of the superclass with the concatenated string of words
        super(String.join(" ", wordsFile));
        
        // Initializing the instance variable with the array of words
        this.wordsData = wordsFile;
    }

    // Method to set a word randomly from the array if its length is greater than 5
    public void setWord() {
        int num;
        
        // Looping until a word with length greater than 5 is found
        do {
            // Generating a random index within the bounds of the array
            num = (int) (Math.random() * wordsData.length);
        } while (wordsData[num].length() <= 5); // Checking if the length of the word at the index is less than or equal to 5

        // Setting the chosen word using the method from the superclass
        super.setWord(wordsData[num]);
    }
}
