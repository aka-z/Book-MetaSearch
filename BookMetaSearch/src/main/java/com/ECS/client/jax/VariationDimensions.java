
package com.ECS.client.jax;

import java.util.ArrayList;
import java.util.List;

public class VariationDimensions {
    protected List<String> variationDimension;

    /**
     * Gets the value of the variationDimension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variationDimension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVariationDimension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVariationDimension() {
        if (variationDimension == null) {
            variationDimension = new ArrayList<String>();
        }
        return this.variationDimension;
    }

}
