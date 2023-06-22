import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.GauPass.MainFrame;

public class Main {
    public static void main(String[] args) {
        // try (BufferedReader br = new BufferedReader(
        // new
        // InputStreamReader(Main.class.getResourceAsStream("/com/GauPass/assets/testing.txt"))))
        // {
        // String sCurrentLine;

        // while ((sCurrentLine = br.readLine()) != null) {
        // System.out.println(sCurrentLine);
        // }
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }
}