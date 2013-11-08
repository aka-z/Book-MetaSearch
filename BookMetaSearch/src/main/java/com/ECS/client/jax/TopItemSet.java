
package com.ECS.client.jax;

import java.util.ArrayList;
import java.util.List;

public class TopItemSet {
    protected String type;
    protected List<TopItemSet.TopItem> topItem;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the topItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the topItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTopItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TopItemSet.TopItem }
     * 
     * 
     */
    public List<TopItemSet.TopItem> getTopItem() {
        if (topItem == null) {
            topItem = new ArrayList<TopItemSet.TopItem>();
        }
        return this.topItem;
    }

    public static class TopItem {
        protected String asin;
        protected String title;
        protected String detailPageURL;
        protected String productGroup;
        protected List<String> author;
        protected List<String> artist;
        protected List<String> actor;

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

        /**
         * Gets the value of the detailPageURL property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDetailPageURL() {
            return detailPageURL;
        }

        /**
         * Sets the value of the detailPageURL property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDetailPageURL(String value) {
            this.detailPageURL = value;
        }

        /**
         * Gets the value of the productGroup property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProductGroup() {
            return productGroup;
        }

        /**
         * Sets the value of the productGroup property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProductGroup(String value) {
            this.productGroup = value;
        }

        /**
         * Gets the value of the author property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the author property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAuthor().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getAuthor() {
            if (author == null) {
                author = new ArrayList<String>();
            }
            return this.author;
        }

        /**
         * Gets the value of the artist property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the artist property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getArtist().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getArtist() {
            if (artist == null) {
                artist = new ArrayList<String>();
            }
            return this.artist;
        }

        /**
         * Gets the value of the actor property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the actor property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getActor().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getActor() {
            if (actor == null) {
                actor = new ArrayList<String>();
            }
            return this.actor;
        }

    }

}
