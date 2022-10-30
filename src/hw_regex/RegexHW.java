package hw_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHW {
    private String email;
    private String phoneNumber;
    private String bookISBN;
    private String dateInFormat;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Pattern p = Pattern.compile("\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}\\b", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);
        if (m.find()) {
            this.email = email;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        Pattern p = Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$");
        Matcher m = p.matcher(phoneNumber);
        if (m.find()) {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        Pattern p = Pattern.compile("^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$");
        Matcher m = p.matcher(bookISBN);
        if (m.find()) {
            this.bookISBN = bookISBN;
        }
    }

    public String getDateInFormat() {
        return dateInFormat;
    }

    public void setDateInFormat(String dateInFormat) {
        Pattern p = Pattern.compile("^\\d{4}-[a-zA-Z]{3}-\\d{2}$");
        Matcher m = p.matcher(dateInFormat);
        if (m.find()) {
            this.dateInFormat = dateInFormat;
        }
    }
}

class TestRegex {
    public static void main(String[] args) {
        RegexHW reg = new RegexHW();
        reg.setEmail("gmail+1@gmail.com");
        System.out.println(reg.getEmail());
        reg.setDateInFormat("2022-Oct-17");
        System.out.println(reg.getDateInFormat());
    }


}