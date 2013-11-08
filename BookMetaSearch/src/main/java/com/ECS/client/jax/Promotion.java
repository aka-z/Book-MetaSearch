
package com.ECS.client.jax;

public class Promotion {
    protected Promotion.Summary summary;

    /**
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link Promotion.Summary }
     *     
     */
    public Promotion.Summary getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link Promotion.Summary }
     *     
     */
    public void setSummary(Promotion.Summary value) {
        this.summary = value;
    }

    public static class Summary {
        protected String promotionId;
        protected String category;
        protected String startDate;
        protected String endDate;
        protected String eligibilityRequirementDescription;
        protected String benefitDescription;
        protected String termsAndConditions;

        /**
         * Gets the value of the promotionId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPromotionId() {
            return promotionId;
        }

        /**
         * Sets the value of the promotionId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPromotionId(String value) {
            this.promotionId = value;
        }

        /**
         * Gets the value of the category property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCategory() {
            return category;
        }

        /**
         * Sets the value of the category property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCategory(String value) {
            this.category = value;
        }

        /**
         * Gets the value of the startDate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStartDate() {
            return startDate;
        }

        /**
         * Sets the value of the startDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStartDate(String value) {
            this.startDate = value;
        }

        /**
         * Gets the value of the endDate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEndDate() {
            return endDate;
        }

        /**
         * Sets the value of the endDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEndDate(String value) {
            this.endDate = value;
        }

        /**
         * Gets the value of the eligibilityRequirementDescription property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEligibilityRequirementDescription() {
            return eligibilityRequirementDescription;
        }

        /**
         * Sets the value of the eligibilityRequirementDescription property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEligibilityRequirementDescription(String value) {
            this.eligibilityRequirementDescription = value;
        }

        /**
         * Gets the value of the benefitDescription property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBenefitDescription() {
            return benefitDescription;
        }

        /**
         * Sets the value of the benefitDescription property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBenefitDescription(String value) {
            this.benefitDescription = value;
        }

        /**
         * Gets the value of the termsAndConditions property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTermsAndConditions() {
            return termsAndConditions;
        }

        /**
         * Sets the value of the termsAndConditions property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTermsAndConditions(String value) {
            this.termsAndConditions = value;
        }

    }

}
