public class SearchWordInSentences {
    public static void main(String[] args) {
        // Example array of sentences
        String[] sentences = {
            "I love programming in Java.",
            "Linear search is simple to implement.",
            "Data structures are very important.",
            "Learning algorithms improves problem-solving skills."
        };

        // Word to search for
        String wordToFind = "important";

        // Call the method to search for the word
        String result = findSentenceWithWord(sentences, wordToFind);

        // Print the result
        System.out.println(result);
    }

    // Method to perform linear search for a word in sentences
    public static String findSentenceWithWord(String[] sentences, String word) {
        // Iterate through each sentence
        for (String sentence : sentences) {
            // Check if the sentence contains the word
            if (sentence.contains(word)) {
                // Word found, return the sentence
                return sentence;
            }
        }
        // Word not found in any sentence
        return "Not Found";
    }
}
