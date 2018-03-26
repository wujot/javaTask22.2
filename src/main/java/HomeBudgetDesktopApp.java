public class HomeBudgetDesktopApp {

    public static void main(String[] args) {
        final String appName = "Home Budget Desktop App v0.1";
        System.out.println(appName);
        ApplicationController appControl = new ApplicationController();
        appControl.mainLoop();
    }
}
