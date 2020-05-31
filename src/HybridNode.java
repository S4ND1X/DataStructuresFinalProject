/**
 * @author Jorge Sánchez Díaz
 * @version v1.0
 */
import javax.swing.tree.DefaultMutableTreeNode;

public class HybridNode extends DefaultMutableTreeNode {
    private FileComponent fileComponentOfNode;
    //private String nodeName;

    public HybridNode(String nodeName){
        super(nodeName);
    }

    public void setFileComponentOfNode(FileComponent fileComponentOfNode){
        this.fileComponentOfNode = fileComponentOfNode;
    }

    public void setComponentName(String name){
        this.fileComponentOfNode.setComponentName(name);
    }


    public FileComponent getFileComponentOfNode(){
        return this.fileComponentOfNode;
    }

   /* public String toString(){
        return this.nodeName;
    }
    */

}
