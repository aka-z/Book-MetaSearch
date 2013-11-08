
package com.ECS.client.jax;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Offers {
    protected BigInteger totalOffers;
    protected BigInteger totalOfferPages;
    protected String moreOffersUrl;
    protected List<Offer> offer;

    /**
     * Gets the value of the totalOffers property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalOffers() {
        return totalOffers;
    }

    /**
     * Sets the value of the totalOffers property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalOffers(BigInteger value) {
        this.totalOffers = value;
    }

    /**
     * Gets the value of the totalOfferPages property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalOfferPages() {
        return totalOfferPages;
    }

    /**
     * Sets the value of the totalOfferPages property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalOfferPages(BigInteger value) {
        this.totalOfferPages = value;
    }

    /**
     * Gets the value of the moreOffersUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoreOffersUrl() {
        return moreOffersUrl;
    }

    /**
     * Sets the value of the moreOffersUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoreOffersUrl(String value) {
        this.moreOffersUrl = value;
    }

    /**
     * Gets the value of the offer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Offer }
     * 
     * 
     */
    public List<Offer> getOffer() {
        if (offer == null) {
            offer = new ArrayList<Offer>();
        }
        return this.offer;
    }

}
