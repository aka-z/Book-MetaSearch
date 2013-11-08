
package com.ECS.client.jax;

import java.util.ArrayList;
import java.util.List;

public class BrowseNode {

        protected String browseNodeId;
        protected String name;
        protected Boolean isCategoryRoot;
        protected BrowseNode.Properties properties;
        protected BrowseNode.Children children;
        protected BrowseNode.Ancestors ancestors;
        protected TopSellers topSellers;
        protected NewReleases newReleases;
        protected List<TopItemSet> topItemSet;

    /**
     * Gets the value of the browseNodeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrowseNodeId() {
        return browseNodeId;
    }

    /**
     * Sets the value of the browseNodeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrowseNodeId(String value) {
        this.browseNodeId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the isCategoryRoot property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsCategoryRoot() {
        return isCategoryRoot;
    }

    /**
     * Sets the value of the isCategoryRoot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCategoryRoot(Boolean value) {
        this.isCategoryRoot = value;
    }

    /**
     * Gets the value of the properties property.
     * 
     * @return
     *     possible object is
     *     {@link BrowseNode.Properties }
     *     
     */
    public BrowseNode.Properties getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     * 
     * @param value
     *     allowed object is
     *     {@link BrowseNode.Properties }
     *     
     */
    public void setProperties(BrowseNode.Properties value) {
        this.properties = value;
    }

    /**
     * Gets the value of the children property.
     * 
     * @return
     *     possible object is
     *     {@link BrowseNode.Children }
     *     
     */
    public BrowseNode.Children getChildren() {
        return children;
    }

    /**
     * Sets the value of the children property.
     * 
     * @param value
     *     allowed object is
     *     {@link BrowseNode.Children }
     *     
     */
    public void setChildren(BrowseNode.Children value) {
        this.children = value;
    }

    /**
     * Gets the value of the ancestors property.
     * 
     * @return
     *     possible object is
     *     {@link BrowseNode.Ancestors }
     *     
     */
    public BrowseNode.Ancestors getAncestors() {
        return ancestors;
    }

    /**
     * Sets the value of the ancestors property.
     * 
     * @param value
     *     allowed object is
     *     {@link BrowseNode.Ancestors }
     *     
     */
    public void setAncestors(BrowseNode.Ancestors value) {
        this.ancestors = value;
    }

    /**
     * Gets the value of the topSellers property.
     * 
     * @return
     *     possible object is
     *     {@link TopSellers }
     *     
     */
    public TopSellers getTopSellers() {
        return topSellers;
    }

    /**
     * Sets the value of the topSellers property.
     * 
     * @param value
     *     allowed object is
     *     {@link TopSellers }
     *     
     */
    public void setTopSellers(TopSellers value) {
        this.topSellers = value;
    }

    /**
     * Gets the value of the newReleases property.
     * 
     * @return
     *     possible object is
     *     {@link NewReleases }
     *     
     */
    public NewReleases getNewReleases() {
        return newReleases;
    }

    /**
     * Sets the value of the newReleases property.
     * 
     * @param value
     *     allowed object is
     *     {@link NewReleases }
     *     
     */
    public void setNewReleases(NewReleases value) {
        this.newReleases = value;
    }

    /**
     * Gets the value of the topItemSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the topItemSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTopItemSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TopItemSet }
     * 
     * 
     */
    public List<TopItemSet> getTopItemSet() {
        if (topItemSet == null) {
            topItemSet = new ArrayList<TopItemSet>();
        }
        return this.topItemSet;
    }

    public static class Ancestors {

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

    public static class Children {

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


    public static class Properties {

                protected List<Property> property;

        /**
         * Gets the value of the property property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the property property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProperty().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Property }
         * 
         * 
         */
        public List<Property> getProperty() {
            if (property == null) {
                property = new ArrayList<Property>();
            }
            return this.property;
        }

    }

}
