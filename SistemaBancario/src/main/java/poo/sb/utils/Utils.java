package poo.sb.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Utils {
    public static String numToBrl(Double num) {        
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(num);
    }
    
    public static Double brlToNum(String brl) {                
        brl = brl.replace("R$", "").replace(".", "").replace(",", ".");
        return Double.parseDouble(brl);
    }
}
