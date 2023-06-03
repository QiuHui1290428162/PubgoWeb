package com.pubgo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//判断字符串是否为数字
public class NumberValidationUtil {  
    
    private static boolean isMatch(String regex, String orginal){  
//        if (orginal == null || orginal.trim().equals("")) {  
//            return false;  
//        } 
        if (orginal == null ) {  
            return false;  
        } 
        Pattern pattern = Pattern.compile(regex);  
        Matcher isNum = pattern.matcher(orginal);  
        return isNum.matches();  
    }  
    
  //验证无＋符号的正整数
    public static boolean isNumeric(String orginal) {  
        return isMatch("[0-9]*", orginal);  
    } 
    
    //验证正整数
    public static boolean isPositiveInteger(String orginal) {  
        return isMatch("^\\+{0,1}[1-9]\\d*", orginal);  
    }  
  
    // 验证负整数
    public static boolean isNegativeInteger(String orginal) {  
        return isMatch("^-[1-9]\\d*", orginal);  
    }  
  
    //验证数字
    public static boolean isWholeNumber(String orginal) {  
        return isMatch("[+-]{0,1}0", orginal) || isPositiveInteger(orginal) || isNegativeInteger(orginal);  
    }  
      
    //验证正小数
    public static boolean isPositiveDecimal(String orginal){  
        return isMatch("\\+{0,1}[0]\\.[1-9]*|\\+{0,1}[1-9]\\d*\\.\\d*", orginal);  
    }  
      
    //验证负小数
    public static boolean isNegativeDecimal(String orginal){  
        return isMatch("^-[0]\\.[1-9]*|^-[1-9]\\d*\\.\\d*", orginal);  
    }  
      
    //验证小数
    public static boolean isDecimal(String orginal){  
        return isMatch("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])", orginal);  
    }  
      
    //验证实数
    public static boolean isRealNumber(String orginal){  
        return isNumeric(orginal) || isDecimal(orginal);  
    }  
  
}  
