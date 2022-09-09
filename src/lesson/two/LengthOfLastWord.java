package lesson.two;

public class LengthOfLastWord {

    public static void getLengthOfLastWord(String sSentence) {
        int indexOfLastSpace = sSentence.trim().lastIndexOf(" ");
        int result = sSentence.trim().length() - indexOfLastSpace - 1;


        if (indexOfLastSpace == -1) {
            System.out.println("The last word is " + "\"" + sSentence.trim() + "\"" + " with length " + sSentence.trim().length());
        } else if (indexOfLastSpace >= 1) {
            System.out.println("The last word is " + "\"" + sSentence.trim().substring(indexOfLastSpace+1) + "\"" + " with length " + result);
        }
    }

    public static void main(String[] args) {

        getLengthOfLastWord("   there   ");
        getLengthOfLastWord("Hello World");
        getLengthOfLastWord("   fly me   to   the moon  ");
        getLengthOfLastWord("luffy is still joyboy");
        getLengthOfLastWord("Dusya is a dog");
        getLengthOfLastWord( "Who is Gaechka?");
    }


}


