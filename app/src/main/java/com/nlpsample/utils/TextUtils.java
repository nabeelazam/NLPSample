package com.nlpsample.utils;

import android.text.Html;
import android.text.Spanned;
import android.text.format.DateFormat;

import com.nlplibrary.utils.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtils {


    public static String EMPTY_SERVER_DATE = "0000-00-00";
    public static String EMPTY_SERVER_DATETIME = "0000-00-00 00:00";
    public static String EMPTY_SERVER_DATETIME_SS = "0000-00-00 00:00:00";

    /**
     * @param text
     * @return
     */
    public static String getFormatText(String text) {
        text = "" + text;
        text = text.trim();
        if (!text.isEmpty() && !text.equalsIgnoreCase("null")) {
            return text;
        }
        return "";
    }

//    /**
//     * @param input
//     * @return
//     */
//    public static String formatGroupTitle(String input) {
//        input = input.replaceAll("_", " ");
//        String[] strArray = input.split(" ");
//        StringBuilder builder = new StringBuilder();
//        for (String s : strArray) {
//            if(s.length() > 1){
//                String cap = s.substring(0, 1).toUpperCase() + s.substring(1);
//                builder.append(cap + " ");
//            }
//        }
//        return builder.toString();
//    }
//

    /**
     * Capitalize first letter of each word in sentence.
     *
     * @param inputString
     * @return
     */
    public static String capitalizeFirstLetterOfEachWord(String inputString) {
        // Removing _ from input String
        inputString = inputString.replaceAll("_", " ");
        StringBuffer capBuffer = new StringBuffer();
        // if capString is empty or null
        inputString = getFormatText(inputString);
        if (inputString.isEmpty()) {
            return inputString;
        }

        Matcher capMatcher = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(inputString);
        while (capMatcher.find()) {
            capMatcher.appendReplacement(capBuffer, capMatcher.group(1).toUpperCase() + capMatcher.group(2).toLowerCase());
        }

        return capMatcher.appendTail(capBuffer).toString();
    }


    /**
     * @param text
     * @return
     */
    public static String getValidText(String text) {
        text = "" + text;
        text = text.trim();
        if (!text.isEmpty() && !text.equalsIgnoreCase("null")) {
            return text;
        }
        return "";
    }


    /**
     * @param leftText
     * @param rightText
     * @return
     */
    public static Spanned getDifferentFontText(String leftText, String rightText) {
        return Html.fromHtml("<font color='#000000'> " + leftText + " </font> <font color='#707070'> " + getFormatTextNA(rightText) + " </font>");
    }


    /**
     * @param text
     * @returnf
     */
    public static String getFormatTextNA(String text) {
        text = "" + text;
        text = text.trim();
        if (!text.isEmpty() && !text.equalsIgnoreCase("null")) {
            return text;
        }
        return Constants.NA;
    }


    /**
     * @param inputFormat
     * @param outputFormat
     * @param inputDate
     * @return
     */
    public static String getFormattedDate(String inputFormat, String outputFormat, String inputDate) {
        SimpleDateFormat format = new SimpleDateFormat(inputFormat);
        String formattedStringDate = Constants.NONE;
        inputDate = TextUtils.getFormatText(inputDate);
        if (inputDate.isEmpty() || inputDate.equalsIgnoreCase(EMPTY_SERVER_DATE) ||
                inputDate.equalsIgnoreCase(EMPTY_SERVER_DATETIME) ||
                inputDate.equalsIgnoreCase(EMPTY_SERVER_DATETIME_SS)) {
            return formattedStringDate;
        }
        try {
            String strInput = "" + inputDate;
            if (!strInput.equalsIgnoreCase("null") && !strInput.equalsIgnoreCase("false") && !strInput.equalsIgnoreCase("") &&
                    (strInput.contains("/") || strInput.contains("-"))) {
                Date date = format.parse(inputDate);
                formattedStringDate = (String) DateFormat.format(outputFormat, date);
            }
        } catch (ParseException e) {
            Logger.logException(e);
        }
        return formattedStringDate;
    }

}
