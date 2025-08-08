import java.util.Scanner;

// VIGENERE CIPHER USING NUMBER ARRAY                    
public class VigenereCipherNumberArray {

    public static int charToNum(char ch) {
        return ch - 'A';
    }

    public static char numToChar(int num) {
        return (char) (num + 'A');
    }

    public static String encrypt(String plaintext, String keyword) {
        plaintext = plaintext.toUpperCase();
        keyword = keyword.toUpperCase();

        int letterCount = 0;
        for (char ch : plaintext.toCharArray()) {
            if (Character.isLetter(ch)) {
                letterCount++;
            }
        }

    
        int[] p = new int[letterCount];  
        int[] k = new int[letterCount];  
        int[] c = new int[letterCount];  

        int pIndex = 0;
        for (char ch : plaintext.toCharArray()) {
            if (Character.isLetter(ch)) {
                p[pIndex++] = charToNum(ch);
            }
        }

    
        for (int i = 0; i < letterCount; i++) {
            k[i] = charToNum(keyword.charAt(i % keyword.length()));
        }

       
        for (int i = 0; i < letterCount; i++) {
            c[i] = (p[i] + k[i]) % 26;
        }

        StringBuilder ciphertext = new StringBuilder();
        int cIndex = 0;

        for (char ch : plaintext.toCharArray()) {
            if (Character.isLetter(ch)) {
                ciphertext.append(numToChar(c[cIndex++]));
            } else {
                ciphertext.append(ch); 
            }
        }

        return ciphertext.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter plaintext: ");
        String plaintext = sc.nextLine();

        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine();

        String result = encrypt(plaintext, keyword);
        System.out.println("Ciphertext: " + result);

        sc.close();
    }
}
