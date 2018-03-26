public class ApplicationController {

    // variables to control app
    public final int exit = 0;
    public final int addHomeBudgetIncome = 1;
    public final int addHomeBudgetExpense = 2;
    public final int displayAllIncomes = 3;
    public final int displayAllExpenses = 4;

    // variable to communicate with user
    private ConsoleDataReader consoleDataReader;

    // variable to communicate with database
    private  HomeBudgetDao dao;

    public ApplicationController() {
        consoleDataReader = new ConsoleDataReader();
        dao = new HomeBudgetDao();
    }

    private void printOptions() {
        System.out.println();
        System.out.println("=====================================");
        System.out.println("=  MENU OF Home Budget Desktop App  =");
        System.out.println("=====================================");
        System.out.println("         1. Add Income");
        System.out.println("         2. Add Expense");
        System.out.println("         3. Display All Incomes");
        System.out.println("         4. Display All Expenses");
        System.out.println("         0. Quit");
        System.out.println("======================================");
    }

    /*
     * Main loop of the app to control flow of the program
     */
    public void mainLoop() {
        int option;
        printOptions();
        while ((option = consoleDataReader.getInt()) != exit) {
            switch (option) {
                case addHomeBudgetIncome:
                    addHomeBudgetIncome();
                    break;
                case addHomeBudgetExpense:
                    addHomeBudgetExpense();
                    break;
                case displayAllIncomes:
                    displayAllIncomes();
                    break;
                case displayAllExpenses:
                    displayAllExpenses();
                    break;
                default:
                    System.out.println("Wrong choice. Let's try again: ");
            }
            printOptions();
        }

        // close
        consoleDataReader.close();
        dao.close();
        System.out.println("You quit from the app");
    }

    private void addHomeBudgetIncome() {
        HomeBudget homeBudget = consoleDataReader.createHomeBudget();
        dao.save(homeBudget);
    }

    private void addHomeBudgetExpense() {
        HomeBudget homeBudget = consoleDataReader.createHomeBudget();
        dao.save(homeBudget);
    }

    private void displayAllIncomes() {
        String type = "Income";
        dao.read(type);
    }

    private void displayAllExpenses() {
        String type = "Expense";
        dao.read(type);
    }
}

