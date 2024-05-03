package HMS;
import javax.swing.*;
public class Main {
    public static void main(String[]args){

    HomePage homePage = new HomePage();
    SwingUtilities.invokeLater(() -> new Patient());
    }
}
