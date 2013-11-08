
package com.ECS.client.jax;

import java.math.BigInteger;

public class OfferListing {

        protected String offerListingId;
        protected Price price;
        protected Price salePrice;
        protected Price amountSaved;
    protected BigInteger percentageSaved;
        protected String availability;
        protected OfferListing.AvailabilityAttributes availabilityAttributes;
        protected Boolean isEligibleForSuperSaverShipping;
        protected Boolean isEligibleForPrime;

    /**
     * Gets the value of the offerListingId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfferListingId() {
        return offerListingId;
    }

    /**
     * Sets the value of the offerListingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfferListingId(String value) {
        this.offerListingId = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setPrice(Price value) {
        this.price = value;
    }

    /**
     * Gets the value of the salePrice property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getSalePrice() {
        return salePrice;
    }

    /**
     * Sets the value of the salePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setSalePrice(Price value) {
        this.salePrice = value;
    }

    /**
     * Gets the value of the amountSaved property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getAmountSaved() {
        return amountSaved;
    }

    /**
     * Sets the value of the amountSaved property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setAmountSaved(Price value) {
        this.amountSaved = value;
    }

    /**
     * Gets the value of the percentageSaved property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPercentageSaved() {
        return percentageSaved;
    }

    /**
     * Sets the value of the percentageSaved property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPercentageSaved(BigInteger value) {
        this.percentageSaved = value;
    }

    /**
     * Gets the value of the availability property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvailability() {
        return availability;
    }

    /**
     * Sets the value of the availability property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvailability(String value) {
        this.availability = value;
    }

    /**
     * Gets the value of the availabilityAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link OfferListing.AvailabilityAttributes }
     *     
     */
    public OfferListing.AvailabilityAttributes getAvailabilityAttributes() {
        return availabilityAttributes;
    }

    /**
     * Sets the value of the availabilityAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link OfferListing.AvailabilityAttributes }
     *     
     */
    public void setAvailabilityAttributes(OfferListing.AvailabilityAttributes value) {
        this.availabilityAttributes = value;
    }

    /**
     * Gets the value of the isEligibleForSuperSaverShipping property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsEligibleForSuperSaverShipping() {
        return isEligibleForSuperSaverShipping;
    }

    /**
     * Sets the value of the isEligibleForSuperSaverShipping property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsEligibleForSuperSaverShipping(Boolean value) {
        this.isEligibleForSuperSaverShipping = value;
    }

    /**
     * Gets the value of the isEligibleForPrime property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsEligibleForPrime() {
        return isEligibleForPrime;
    }

    /**
     * Sets the value of the isEligibleForPrime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsEligibleForPrime(Boolean value) {
        this.isEligibleForPrime = value;
    }


    public static class AvailabilityAttributes {

                protected String availabilityType;
                protected Boolean isPreorder;
                protected BigInteger minimumHours;
                protected BigInteger maximumHours;

        /**
         * Gets the value of the availabilityType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAvailabilityType() {
            return availabilityType;
        }

        /**
         * Sets the value of the availabilityType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAvailabilityType(String value) {
            this.availabilityType = value;
        }

        /**
         * Gets the value of the isPreorder property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isIsPreorder() {
            return isPreorder;
        }

        /**
         * Sets the value of the isPreorder property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsPreorder(Boolean value) {
            this.isPreorder = value;
        }

        /**
         * Gets the value of the minimumHours property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMinimumHours() {
            return minimumHours;
        }

        /**
         * Sets the value of the minimumHours property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMinimumHours(BigInteger value) {
            this.minimumHours = value;
        }

        /**
         * Gets the value of the maximumHours property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMaximumHours() {
            return maximumHours;
        }

        /**
         * Sets the value of the maximumHours property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMaximumHours(BigInteger value) {
            this.maximumHours = value;
        }

    }

}
