
package com.ECS.client.jax;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Variations {
    protected BigInteger totalVariations;
    protected BigInteger totalVariationPages;
    protected VariationDimensions variationDimensions;
    protected List<Item> item;

    /**
     * Gets the value of the totalVariations property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalVariations() {
        return totalVariations;
    }

    /**
     * Sets the value of the totalVariations property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalVariations(BigInteger value) {
        this.totalVariations = value;
    }

    /**
     * Gets the value of the totalVariationPages property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalVariationPages() {
        return totalVariationPages;
    }

    /**
     * Sets the value of the totalVariationPages property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalVariationPages(BigInteger value) {
        this.totalVariationPages = value;
    }

    /**
     * Gets the value of the variationDimensions property.
     * 
     * @return
     *     possible object is
     *     {@link VariationDimensions }
     *     
     */
    public VariationDimensions getVariationDimensions() {
        return variationDimensions;
    }

    /**
     * Sets the value of the variationDimensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link VariationDimensions }
     *     
     */
    public void setVariationDimensions(VariationDimensions value) {
        this.variationDimensions = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Item }
     * 
     * 
     */
    public List<Item> getItem() {
        if (item == null) {
            item = new ArrayList<Item>();
        }
        return this.item;
    }

}
