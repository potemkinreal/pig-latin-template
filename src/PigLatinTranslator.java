import java.lang.*;

public class PigLatinTranslator
{
  public static Book translate(Book input)
  {
    Book translatedBook = new Book();

    


    return translatedBook;
  }

  public static String translate(String input) {
    // Makes sure words actually exists, returns empty sentences.
    if (input.trim().isEmpty()) {
        return input;
    }


    // Splits the sentence into words
    String[] words = input.split("\\s+");
    String result = "";

    for (String word : words) {
        // Early detection for hyphens
        if (word.contains("-")) {
            String[] parts = word.split("-");
            StringBuilder pigLatinWord = new StringBuilder();
            for (int i = 0; i < parts.length; i++) { 
                // Apply pig latin translations seperately
                String pigLatinPart = translatePart(parts[i]);

                // "Glues" finished parts back using a hyphen
                pigLatinWord.append(pigLatinPart);
                if (i < parts.length - 1) {
                    pigLatinWord.append("-");
                }
            }

            // Add word to result
            result += pigLatinWord + " ";
        } else {
            // Uses normal word translation if there is no hyphen.
            result += translatePart(word) + " ";
        }
    }

    return result.trim();
}

private static String translatePart(String word) {
    // Contains punctution at beginning or the end of a word (e.g: , . ! () ; etc)
    String punctuationStart = "";
    String punctuationEnd = "";
    int punctuationIndex;

    // Punctuation finder(beginning)
    punctuationIndex = 0;
    while (punctuationIndex <= word.length()-1 && !Character.isLetterOrDigit(word.charAt(punctuationIndex))) {
        punctuationStart = punctuationStart + word.charAt(punctuationIndex);
        punctuationIndex++;
    }

    // Removes puntuation from beginning of the word if necessary
    word = word.substring(punctuationIndex);

    // Punctuation finder (end)
    punctuationIndex = word.length()-1;
    while (punctuationIndex >= 0 && !Character.isLetterOrDigit(word.charAt(punctuationIndex))) {
        punctuationEnd = word.charAt(punctuationIndex) + punctuationEnd;
        punctuationIndex--;
    }

    // ditto, but back
    word = word.substring(0, punctuationIndex + 1);

    // pig latin translation factory
    if (word.trim().length() > 0) {
        
        // Retains original word for future reference
        String originalWord = word;
        
        // pigLatin sets up a reference to use for translation, does not makes first letter lowercase so it does not get jumbled in later
        String pigLatin = word.substring(0,1).toLowerCase() + word.substring(1);
        // finds if the first letter is a vowel
        boolean isVowel = "aeiou".indexOf(pigLatin.charAt(0)) != -1;

        // Pre-op process, skips if first letter is a vowel
        if (isVowel) {
            pigLatin += "ay";
        } else {

            // If first letter is a consonant, finds first vowel.
            int pigStart = -1;
            for (int i = 0; i < pigLatin.length(); i++) {
                if ("aeiouAEIOU".indexOf(pigLatin.charAt(i)) != -1) {
                    pigStart = i;

                    // Breaks when vowel is found
                    break;
                }
            }

            // if vowel is found, makes pig latin word as needed
            if (pigStart != -1) {
                pigLatin = pigLatin.substring(pigStart) + pigLatin.substring(0, pigStart) + "ay";
            }
        }


        //Used to Capitalize the word if needed (final step)
        if (Character.isUpperCase(originalWord.charAt(0))) {
            word = Character.toUpperCase(pigLatin.charAt(0)) + pigLatin.substring(1);
        } else {
            word = pigLatin;
        }


    }

    return punctuationStart + word + punctuationEnd;
}









  private static String translateWord(String input)
  {
    // System.out.println("translateWord: '" + input + "'");

    // Replace this code to correctly translate a single word.
    // Start here first!
    String result = input;
    
    return result;
  }

  // Add additonal private methods here.
  // For example, I had one like this:
  // private static String capitalizeFirstLetter(String input)

}
