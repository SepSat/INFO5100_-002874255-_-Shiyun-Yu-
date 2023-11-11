import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        // Pattern 1: Email Validation
        printRegexResult("Email Validation", "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b",
                new String[]{"test@example.com", "invalid-email.com"});

        // Pattern 2: Phone Number Validation (US Format)
        printRegexResult("Phone Number Validation", "\\d{3}-\\d{3}-\\d{4}",
                new String[]{"123-456-7890", "1234567890"});

        // Pattern 3: Password Strength (At least one digit, one lower case, one upper case, no whitespace, at least 8 characters)
        printRegexResult("Password Strength", "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$",
                new String[]{"Password123", "password"});

        // Pattern 4: Social security number (US)
        printRegexResult("Social security number", "\\b[0-9]{3}-[0-9]{2}-[0-9]{4}\\b",
                new String[]{"023-23-3009", "J20-3990"});

        // Pattern 5: Date Format Check (YYYY-MM-DD)
        printRegexResult("Date Format Check", "\\d{4}-\\d{2}-\\d{2}",
                new String[]{"2023-11-10", "10-11-2023"});
    }
    private static void printRegexResult(String testName, String pattern, String[] testStrings) {
        System.out.println("Testing: " + testName);
        Pattern compiledPattern = Pattern.compile(pattern);
        for (String testString : testStrings) {
            Matcher matcher = compiledPattern.matcher(testString);
            System.out.println("Test String: " + testString + " - " + (matcher.matches() ? "Pass" : "Fail"));
        }
        System.out.println();
    }
}