/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.swing.AbstractButton;
import javax.swing.JLabel;

/**
 *
 * @author Adham
 */
public abstract class GLOBAL {

    protected static Locale currentLocale = new Locale("en"); // Default locale
    protected static ResourceBundle bundle;
    
    Properties newBundle = new Properties();

    
    public GLOBAL() {
        
    }
    
    abstract void switchLanguage();

    
     public static void updateTextFields(Object obj, String frame, java.util.ResourceBundle bundle) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true); // Allow access to private fields
                Object value = field.get(obj); // Get the field value

                if (value instanceof AbstractButton) { // For buttons like JButton, JToggleButton, etc.
                    ((AbstractButton) value).setText(bundle.getString(frame + "." + field.getName() + ".text"));
                } else if (value instanceof JLabel) { // For labels
                    ((JLabel) value).setText(bundle.getString(frame + "." + field.getName() + ".text"));
                }
            } catch (IllegalAccessException | NullPointerException | java.util.MissingResourceException e) {
                System.err.println("Could not set text for: " + field.getName());
            }
        }
    }
    
}
