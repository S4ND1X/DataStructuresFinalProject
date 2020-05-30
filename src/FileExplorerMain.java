import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExplorerMain {

    public static MainFolderComponent mainFolder;
    public static  Folder discoD;

    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        discoD = new Folder("D:/", dateFormat.format(date), "D:/");

        Folder folder1 = new Folder("Folder 1/", dateFormat.format(date), "D:");
        Folder folder2 = new Folder("Folder 2/", dateFormat.format(date), "D:");
        Folder folder3 = new Folder("Folder 3/", dateFormat.format(date), "D:");




        File file1 = new File("File 1", dateFormat.format(date), "D:/Folder 1");
        File file2 = new File("File 2", dateFormat.format(date), "D:/Folder 2");
        File file3 = new File("File 3", dateFormat.format(date), "D:/Folder 3");


        folder1.add(file1);
        folder2.add(file2);
        folder3.add(file3);

        discoD.add(folder1);
        discoD.add(folder2);
        discoD.add(folder3);


        mainFolder = new MainFolderComponent(discoD);
        mainFolder.getFileList();
        Window wd = new Window(mainFolder);


    }

}
