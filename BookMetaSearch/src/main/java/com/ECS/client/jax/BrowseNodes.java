
package com.ECS.client.jax;

import java.util.ArrayList;
import java.util.List;

public class BrowseNodes {
    protected List<BrowseNode> browseNode;

    /**
     * Gets the value of the browseNode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the browseNode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBrowseNode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BrowseNode }
     * 
     * 
     */
    public List<BrowseNode> getBrowseNode() {
        if (browseNode == null) {
            browseNode = new ArrayList<BrowseNode>();
        }
        return this.browseNode;
    }

}
