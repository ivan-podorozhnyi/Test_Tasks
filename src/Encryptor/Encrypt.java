package Encryptor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Encrypt
{
    private static String main;
    private static String ticket;
    private static String danger;
    private static String fragile;
    private static String driver;
    private static String temperature;
    private static String cargo;

    //using regexp to encrypt the code
    static Code encryptCode(String encode)
    {
        Code code;
        String ticketPart1 = "", ticketPart2 = "", ticketPart3 = "";
        String regExp = "([a-zA-Z]{4})+.*((R|r)+?([\\w]{4})([a-zA-Z]{4})?((\\+|-)[0-9]{3})?([0-9]*))";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(encode);

        if (matcher.find())
        {
            main = encode;

            driver = matcher.group(1);

            ticketPart1 = matcher.group(3);

            if (matcher.group(4) != null)
            {
                ticketPart2 = matcher.group(4);

                if (ticketPart2.contains("d"))
                {
                    danger = "true";
                } else
                {
                    danger = "false";
                }

                if (ticketPart2.contains("f"))
                {
                    fragile = "true";
                } else
                {
                    fragile = "false";
                }
            }

            if (matcher.group(5) != null)
            {
                ticketPart3 = matcher.group(5);
            }

            if (matcher.group(6) != null)
            {
                temperature = matcher.group(6);

                if (matcher.group(7) != null)
                {
                    cargo = matcher.group(7);
                }
            } else
            {
                temperature = "";
            }

            if (matcher.group(8) != null)
            {
                cargo = octalToString(matcher.group(8));
            }
        }
        ticket = ticketPart1 + ticketPart2 + ticketPart3;

        code = new Code(main, driver, ticket, danger, fragile, temperature, cargo);
        return code;
    }

    //method is encrypting ANSII value to a word
    private static String octalToString(String string)
    {
        String result = "";
        String[] array = string.split("(?<=\\G...)");

        for (String x : array)
        {
            int decimal = Integer.valueOf(x, 8);
            char tempChar = (char) decimal;
            result += tempChar;
        }
        return result;
    }
}
