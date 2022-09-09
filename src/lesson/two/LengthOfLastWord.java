package lesson.two;

public class LengthOfLastWord {

    public static void getLengthOfLastWord(String sSentence) {
        int i = sSentence.trim().lastIndexOf(" ");
        int result = sSentence.trim().length() - i - 1;


        if (i == -1) {
            System.out.println("The last word is " + "\"" + sSentence.trim() + "\"" + " with length " + sSentence.trim().length());
        } else if (i >= 1) {
            System.out.println("The last word is " + "\"" + sSentence.trim().substring(i+1) + "\"" + " with length " + result);
        }
    }

    public static void main(String[] args) {

        getLengthOfLastWord("   there   ");
        getLengthOfLastWord("Hello World");
        getLengthOfLastWord("   fly me   to   the moon  ");
        getLengthOfLastWord("luffy is still joyboy");
    }


}


