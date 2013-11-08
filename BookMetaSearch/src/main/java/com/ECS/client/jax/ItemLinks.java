
package com.ECS.client.jax;

import java.util.ArrayList;
import java.util.List;

public class ItemLinks {
    protected List<ItemLink> itemLink;

    /**
     * Gets the value of the itemLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemLink }
     * 
     * 
     */
    public List<ItemLink> getItemLink() {
        if (itemLink == null) {
            itemLink = new ArrayList<ItemLink>();
        }
        return this.itemLink;
    }

}
