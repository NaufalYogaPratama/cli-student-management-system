import service.StudentService;
import ui.MainMenu;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        MainMenu mainMenu = new MainMenu(studentService);
        mainMenu.start();
    }
}
