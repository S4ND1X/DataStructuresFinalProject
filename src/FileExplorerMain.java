import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExplorerMain {

    public static MainFolderComponent mainFolder;
    public static  Folder discoD;

    public static void main(String[] args) {
        discoD = new Folder("D:","");
        mainFolder = new MainFolderComponent(discoD);
        mainFolder.getFileList();
        Window wd = new Window(mainFolder);


    }

}
