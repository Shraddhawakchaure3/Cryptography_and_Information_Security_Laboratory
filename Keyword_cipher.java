import java.util.*;

public class Keyword_cipher {

    // Generate substitution key from keyword
    public static String generateKey(String keyword) {
        keyword = keyword.toUpperCase();
        StringBuilder key = new StringBuilder();

        // Add unique letters from keyword
        for (char ch : keyword.toCharArray()) {
            if (key.indexOf(String.valueOf(ch)) == -1 && ch >= 'A' && ch <= 'Z') {
                key.append(ch);
            }
        }

        // Add remaining letters
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (key.indexOf(String.valueOf(ch)) == -1) {
                key.append(ch);
            }
        }

        return key.toString();
    }

    // Encrypt the plaintext using key
    public static String encrypt(String plaintext, String key) {
        StringBuilder result = new StringBuilder();

        for (char ch : plaintext.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(key.charAt(ch - 'A'));
            } else if (Character.isLowerCase(ch)) {
                char upper = Character.toUpperCase(ch);
                char cipherChar = key.charAt(upper - 'A');
                result.append(Character.toLowerCase(cipherChar));
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input keyword
        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine();

        // Generate key
        String key = generateKey(keyword);

        // Input plaintext
        System.out.print("Enter plaintext: ");
        String plaintext = sc.nextLine();

        // Encrypt
        String ciphertext = encrypt(plaintext, key);
        System.out.println("Encrypted: " + ciphertext);

        sc.close();
    }
}
 
