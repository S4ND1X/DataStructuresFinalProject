/**
 * @author Jorge Sánchez Díaz
 * @version v1.0
 */
import javax.swing.tree.DefaultMutableTreeNode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class File extends FileComponent{

    private String fileName;
    private String fileCreationDate;
    private String fileAbsolutePath;
    private HybridNode fileNode;

    public File(String fileName, String parentAbsolutePath){
        this.fileName = fileName;
        setCreationDate();
        setAbsolutPath(parentAbsolutePath);
        this.fileNode = new HybridNode(fileName);
        this.fileNode.setFileComponentOfNode(this);

    }

    @Override
    public void setCreationDate(){
        this.fileCreationDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
    }
    @Override
    public void setAbsolutPath(String absolutPath) {
        this.fileAbsolutePath = absolutPath + "/" + this.fileName +"/";
    }

    @Override
    public void setComponentName(String fileComponentName) {
        this.fileName = fileComponentName;
    }

    @Override
    public void displayFileInfo(){
        System.out.println(getFileName() +  " creado el " + getCreationDate() +  " en " + getAbsolutePath());
    }

    //- -  - - - - - - - - - Getters - - - - - - - - - - -
    @Override
    public HybridNode getFileComponentNode() { return this.fileNode; }
    @Override
    public String getCreationDate() { return fileCreationDate; }
    @Override
    public String getAbsolutePath() { return fileAbsolutePath; }
    @Override
    public String getFileName() { return fileName; }

}
