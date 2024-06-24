import java.io.*;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Instant minDate = null;
        Instant maxDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ");

        try (BufferedReader reader = new BufferedReader(new FileReader("dates.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Instant date = Instant.from(formatter.parse(line));
                if (date.isBefore(minDate)) {
                    minDate = date;
                }
                if (date.isAfter(maxDate)) {
                    maxDate = date;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!minDate.equals(maxDate)) {
            DateTimeFormatter output = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.println("Самая ранняя дата: " + output.format(minDate));
            System.out.println("Самая поздняя дата: " + output.format(maxDate));
        } else {
            System.out.println("Даты совпадают");
        }
    }
}