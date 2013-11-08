
package com.ECS.client.jax;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Tracks {
    protected List<Tracks.Disc> disc;

    /**
     * Gets the value of the disc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tracks.Disc }
     * 
     * 
     */
    public List<Tracks.Disc> getDisc() {
        if (disc == null) {
            disc = new ArrayList<Tracks.Disc>();
        }
        return this.disc;
    }

    public static class Disc {

        protected List<Tracks.Disc.Track> track;
        protected BigInteger number;

        /**
         * Gets the value of the track property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the track property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTrack().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Tracks.Disc.Track }
         * 
         * 
         */
        public List<Tracks.Disc.Track> getTrack() {
            if (track == null) {
                track = new ArrayList<Tracks.Disc.Track>();
            }
            return this.track;
        }

        /**
         * Gets the value of the number property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getNumber() {
            return number;
        }

        /**
         * Sets the value of the number property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setNumber(BigInteger value) {
            this.number = value;
        }

        public static class Track {
            protected String value;
            protected BigInteger number;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the number property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getNumber() {
                return number;
            }

            /**
             * Sets the value of the number property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setNumber(BigInteger value) {
                this.number = value;
            }

        }

    }

}
