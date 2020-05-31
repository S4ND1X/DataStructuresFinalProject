import javax.swing.tree.DefaultMutableTreeNode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Folder extends FileComponent {

    private ArrayList fileComponents;
    private String folderName;
    private String folderCreationDate;
    private String folderAbsolutePath;
    private HybridNode folderNode;
    private int childCount;

    public Folder(String folderName, String parentAbsolutePath){
        this.fileComponents = new ArrayList();
        setComponentName(folderName);
        setAbsolutPath(parentAbsolutePath);
        setCreationDate();
        this.folderNode = new HybridNode(folderName);
        this.folderNode.setFileComponentOfNode(this);
        this.childCount = 0;
    }

    @Override
    public void setComponentName(String folderName){
        this.folderName = folderName;
    }//Set folder's name
    @Override
    public void setCreationDate(){
        this.folderCreationDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
    }//Get the the system date and assign to folder
    @Override
    public void setAbsolutPath(String parentAbsolutPath){
        this.folderAbsolutePath = parentAbsolutPath + "/" +this.folderName+"/";
    }

    @Override
    public HybridNode getFileComponentNode() { return this.folderNode; }
    @Override
    public void add(FileComponent newFileComponent){
        this.fileComponents.add(newFileComponent);//Add to array list the FileComponent
        this.folderNode.add(newFileComponent.getFileComponentNode()); //Add node of the component to JTree
        this.childCount++;
    }
    @Override
    public void remove(FileComponent newFileComponent){
        this.fileComponents.remove(newFileComponent);
    }
    @Override
    public void displayFileInfo(){

        Iterator fileIterator = fileComponents.iterator();

        while(fileIterator.hasNext()){

            FileComponent fileInfo = (FileComponent) fileIterator.next();
            fileInfo.displayFileInfo();//Imprimir info del hijo de este folder
        }
    }
    public int subFoldersCount(){

        Iterator fileIterator = fileComponents.iterator();
        int cont = 0;
        while(fileIterator.hasNext()){

            FileComponent fileInfo = (FileComponent) fileIterator.next();
            cont+=fileInfo.getFileComponentNode().getChildCount();
        }
        return cont;
    }

    public HybridNode getFolderNode(){
        return this.folderNode;
    }

    //- -  - - - - - - - - - Getters - - - - - - - - - - -

    @Override
    public String getFileName(){ return this.folderName; }
    @Override
    public String getCreationDate(){ return this.folderCreationDate; }
    @Override
    public String getAbsolutePath(){ return this.folderAbsolutePath; }
    public int getDirectChildCount(){ return this.childCount; }
    public int getAllChildCount(){ return  this.childCount + subFoldersCount();}





}
