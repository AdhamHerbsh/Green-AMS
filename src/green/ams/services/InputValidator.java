package green.ams.services;

/**
 * InputValidator - Utility class for validating user input
 * Contains methods to validate various user input types
 */
public class InputValidator {
    // Regular expression patterns for validation
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String PHONE_PATTERN = "^5\\d{8}$"; // Saudi mobile numbers starting with 5 followed by 8 digits
    private static final String NAME_PATTERN = "^[\\p{L} .'-]+$"; // Allow letters, spaces, periods, apostrophes, and hyphens
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    
    /**
     * Validates full name
     * @param fullName the user's full name
     * @return error message or null if valid
     */
    public static String validateFullName(String fullName) {
        if (fullName == null || fullName.isEmpty()) {
            return "Full name cannot be empty";
        }
        
        if (fullName.length() < 3) {
            return "Full name must be at least 3 characters";
        }
        
        if (!fullName.matches(NAME_PATTERN)) {
            return "Full name contains invalid characters";
        }
        
        return null; // No error
    }
    
    /**
     * Validates email address
     * @param email the user's email
     * @return error message or null if valid
     */
    public static String validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return "Email cannot be empty";
        }
        
        if (!email.matches(EMAIL_PATTERN)) {
            return "Invalid email format";
        }
        
        return null; // No error
    }
    
    /**
     * Validates address
     * @param address the user's address
     * @return error message or null if valid
     */
    public static String validateAddress(String address) {
        if (address == null || address.isEmpty()) {
            return "Address cannot be empty";
        }
        
        if (address.length() < 5) {
            return "Address is too short";
        }
        
        return null; // No error
    }
    
    /**
     * Validates phone number (Saudi format)
     * @param phoneNumber the user's phone number (without country code)
     * @return error message or null if valid
     */
    public static String validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return "Phone number cannot be empty";
        }
        
        // Check if the phone number matches Saudi format (starting with 5 followed by 8 digits)
        if (!phoneNumber.matches(PHONE_PATTERN)) {
            return "Invalid phone number format. Must start with 5 followed by 8 digits";
        }
        
        return null; // No error
    }
    
    /**
     * Validates password
     * @param password the user's password
     * @return error message or null if valid
     */
    public static String validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return "Password cannot be empty";
        }
        
        if (password.length() < 8) {
            return "Password must be at least 8 characters";
        }
        
        // Check for strong password requirements
        if (!password.matches(PASSWORD_PATTERN)) {
            return "Password must contain at least one digit, one lowercase letter, " +
                   "one uppercase letter, one special character, and no whitespace";
        }
        
        return null; // No error
    }
    
    /**
     * Validates role
     * @param role the user's role
     * @return error message or null if valid
     */
    public static String validateRole(String role) {
        if (role == null || role.isEmpty()) {
            return "Role cannot be empty";
        }
        
        // You may want to add specific role validation logic here
        // For example, checking against a predefined list of valid roles
        
        return null; // No error
    }
}