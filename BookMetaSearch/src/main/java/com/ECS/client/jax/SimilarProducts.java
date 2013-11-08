
package com.ECS.client.jax;

import java.util.ArrayList;
import java.util.List;

public class SimilarProducts {

    protected List<SimilarProducts.SimilarProduct> similarProduct;

    /**
     * Gets the value of the similarProduct property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the similarProduct property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSimilarProduct().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimilarProducts.SimilarProduct }
     * 
     * 
     */
    public List<SimilarProducts.SimilarProduct> getSimilarProduct() {
        if (similarProduct == null) {
            similarProduct = new ArrayList<SimilarProducts.SimilarProduct>();
        }
        return this.similarProduct;
    }

    public static class SimilarProduct {
        protected String asin;
        protected String title;

        /**
         * Gets the value of the asin property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getASIN() {
            return asin;
        }

        /**
         * Sets the value of the asin property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setASIN(String value) {
            this.asin = value;
        }

        /**
         * Gets the value of the title property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTitle() {
            return title;
        }

        /**
         * Sets the value of the title property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTitle(String value) {
            this.title = value;
        }

    }

}
