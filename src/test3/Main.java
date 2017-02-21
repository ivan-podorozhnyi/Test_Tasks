package test3;

import java.io.FileWriter;
import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {

        String[] anArray = {"RMuiRdf01160141151156164", "lims8r3860lims1631411561441", "GZQRyr6870GZQR+0041431501451451631455A",
                "qkMfPjrd0561411551551651561511641511571567", "EOcTkerf3891511431450551431621451411550"};
        ArrayList<Code> codeList = new ArrayList<Code>();

        try
        {
            //encrypting all codes from anArray and adding to codeList
            for (String x : anArray)
            {
                codeList.add(Encrypt.encryptCode(x));
            }

            String csvFile = "encrypt.csv";
            FileWriter writer = new FileWriter(csvFile);

            //for header, separator and coma delimiter
            final String FILE_HEADER = "шифр, код водителя, код путевого листа, опасный, хрупкий, температура, наименование";
            final String NEW_LINE_SEPARATOR = "\n";
            final String COMMA_DELIMITER = ",";

            //Writing the CSV file header
            writer.append(FILE_HEADER);

            //Adding a new line separator after the header
            writer.append(NEW_LINE_SEPARATOR);

            //writing all data from codeList to CSV file
            for (Code d : codeList)
            {
                writer.append(String.valueOf(d.getCode()));
                writer.append(COMMA_DELIMITER);
                writer.append(d.getDriver());
                writer.append(COMMA_DELIMITER);
                writer.append(d.getTripTicket());
                writer.append(COMMA_DELIMITER);
                writer.append(d.getDangerous());
                writer.append(COMMA_DELIMITER);
                writer.append(d.getFragile());
                writer.append(COMMA_DELIMITER);
                writer.append(d.getTemperature());
                writer.append(COMMA_DELIMITER);
                writer.append(d.getCargo());
                writer.append(NEW_LINE_SEPARATOR);
            }
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            System.out.println("Exception occurred:");
            e.printStackTrace();
        }
    }
}
