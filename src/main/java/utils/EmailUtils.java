package utils;

//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
import java.util.Properties;

public class EmailUtils {
   /* private static final String HOST = "https://mail.google.com/"; // SMTP host
    private static final String USER = "datanchrotest@gmail.com"; // Your email address
    private static final String PASSWORD = "TestPassword123"; // Your email password
    private static final String EMAIL_SUBJECT = "Your Anchor account One Time Passcode"; // Subject of the email containing OTP

    public static String fetchOTP() {
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.imap.host", HOST);
        properties.put("mail.imap.port", "993");
        properties.put("mail.imap.ssl.enable", "true");

        Session session = Session.getInstance(properties);
        try {
            Store store = session.getStore("imaps");
            store.connect(HOST, USER, PASSWORD);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();
            for (Message message : messages) {
                if (message.getSubject().contains(EMAIL_SUBJECT)) {
                    String content = (String) message.getContent();
                    // Extract OTP from the email content
                    // Assuming OTP is in a specific format or pattern
                    String otp = extractOTP(content);
                    return otp;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String extractOTP(String content) {
        // Implement the logic to extract OTP from the email content
        // For example, use regex to find the OTP
        return "123456"; // Example static OTP; replace with actual extraction logic
    }*/
}
