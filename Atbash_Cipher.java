
import java.util.Scanner;

public class Atbash_Cipher {

    public static String atbashCipher(String text) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append((char) ('A' + ('Z' - ch)));
            } else if (Character.isLowerCase(ch)) {
                result.append((char) ('a' + ('z' - ch)));
            } else {
                result.append(ch); 
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        System.out.print("Enter text to encrypt using Atbash Cipher: ");
        String input = scanner.nextLine(); 
        String output = atbashCipher(input);

        System.out.println("Encrypted (Atbash) text: " + output);

        scanner.close(); 
    }
}

