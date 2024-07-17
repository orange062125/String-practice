package test;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

    public static void main(String[] args) {
        System.out.println(getDecimal("csdo1242.12"));
    }

    public static String getDecimal(String anyString){
        String decimalStr = "inValidParameter!";
        String letterNumRegex = "[A-Za-z]+[\\d]+(\\.\\d+)?";
        String decimalRegex = "[\\d]+(\\.\\d{1,2})?";
        Pattern letterNumPattern = Pattern.compile(letterNumRegex);
        Matcher letterNumMatcher = letterNumPattern.matcher(anyString);
        if(letterNumMatcher.matches()){
            Pattern decimalPattern = Pattern.compile(decimalRegex);
            Matcher decimalMatcher = decimalPattern.matcher(anyString);
            if(decimalMatcher.find()){
                decimalStr = decimalMatcher.group();
            }
            DecimalFormat df = new DecimalFormat("0.00");
            double doubleValue = Double.parseDouble(decimalStr);
            decimalStr = df.format(doubleValue);
        }
        return decimalStr;
    }
}
