import java.util.ArrayList;
import java.util.List;

public class Network {

    List nodeList;

    public Network() {
        nodeList = new ArrayList<Node>();
    }

    /**
     * Function that adds a node to the nodeList
     * @param node the node to be added
     */
    void addNote(Node node)
    {
        nodeList.add(node);
    }

    public List getNodeList() {
        return nodeList;
    }
}
