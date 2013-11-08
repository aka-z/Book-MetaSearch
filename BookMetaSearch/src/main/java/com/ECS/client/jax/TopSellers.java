
package com.ECS.client.jax;

import java.util.ArrayList;
import java.util.List;

public class TopSellers {
    protected List<TopSellers.TopSeller> topSeller;

    /**
     * Gets the value of the topSeller property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the topSeller property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTopSeller().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TopSellers.TopSeller }
     * 
     * 
     */
    public List<TopSellers.TopSeller> getTopSeller() {
        if (topSeller == null) {
            topSeller = new ArrayList<TopSellers.TopSeller>();
        }
        return this.topSeller;
    }

    public static class TopSeller {
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
