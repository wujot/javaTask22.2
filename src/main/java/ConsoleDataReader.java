import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleDataReader {
    private Scanner sc;

    public ConsoleDataReader() {
        sc = new Scanner(System.in);
    }

    public void close() {
        sc.close();
    }

    public int getInt() {
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }

    public HomeBudget createHomeBudget() {
        System.out.println("Give a home budget record details: ");
        System.out.println("==================================");
        System.out.println("Type: ");
        String type = sc.nextLine();
        System.out.println("Description: ");
        String description = sc.nextLine();
        System.out.println("Amount: ");
        double amount = Double.parseDouble(sc.nextLine());
        LocalDate date = LocalDate.now();

        return new HomeBudget(type, description, amount, Date.valueOf(date));
    }
}
