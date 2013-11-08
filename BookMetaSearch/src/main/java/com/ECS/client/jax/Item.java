
package com.ECS.client.jax;

import java.util.ArrayList;
import java.util.List;

public class Item {
    protected String asin;
    protected String parentASIN;
    protected Errors errors;
    protected String detailPageURL;
    protected ItemLinks itemLinks;
    protected String salesRank;
    protected Image smallImage;
    protected Image mediumImage;
    protected Image largeImage;
    protected List<Item.ImageSets> imageSets;
    protected ItemAttributes itemAttributes;
    protected Item.VariationAttributes variationAttributes;
    protected List<RelatedItems> relatedItems;
    protected Collections collections;
    protected Item.Subjects subjects;
    protected OfferSummary offerSummary;
    protected Offers offers;
    protected VariationSummary variationSummary;
    protected Variations variations;
    protected CustomerReviews customerReviews;
    protected EditorialReviews editorialReviews;
    protected SimilarProducts similarProducts;
    protected Accessories accessories;
    protected Tracks tracks;
    protected BrowseNodes browseNodes;
    protected Item.AlternateVersions alternateVersions;

    public String getASIN() {
        return asin;
    }

    public void setASIN(String value) {
        this.asin = value;
    }

    public String getParentASIN() {
        return parentASIN;
    }

    public void setParentASIN(String value) {
        this.parentASIN = value;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors value) {
        this.errors = value;
    }

    public String getDetailPageURL() {
        return detailPageURL;
    }

    public void setDetailPageURL(String value) {
        this.detailPageURL = value;
    }

    public ItemLinks getItemLinks() {
        return itemLinks;
    }

    public void setItemLinks(ItemLinks value) {
        this.itemLinks = value;
    }

    public String getSalesRank() {
        return salesRank;
    }

    public void setSalesRank(String value) {
        this.salesRank = value;
    }

    public Image getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(Image value) {
        this.smallImage = value;
    }

    public Image getMediumImage() {
        return mediumImage;
    }

    public void setMediumImage(Image value) {
        this.mediumImage = value;
    }

    public Image getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(Image value) {
        this.largeImage = value;
    }

    public List<Item.ImageSets> getImageSets() {
        if (imageSets == null) {
            imageSets = new ArrayList<Item.ImageSets>();
        }
        return this.imageSets;
    }

    public ItemAttributes getItemAttributes() {
        return itemAttributes;
    }

    public void setItemAttributes(ItemAttributes value) {
        this.itemAttributes = value;
    }

    public Item.VariationAttributes getVariationAttributes() {
        return variationAttributes;
    }

    public void setVariationAttributes(Item.VariationAttributes value) {
        this.variationAttributes = value;
    }

    public List<RelatedItems> getRelatedItems() {
        if (relatedItems == null) {
            relatedItems = new ArrayList<RelatedItems>();
        }
        return this.relatedItems;
    }

    public Collections getCollections() {
        return collections;
    }

    public void setCollections(Collections value) {
        this.collections = value;
    }

    public Item.Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Item.Subjects value) {
        this.subjects = value;
    }

    public OfferSummary getOfferSummary() {
        return offerSummary;
    }

    public void setOfferSummary(OfferSummary value) {
        this.offerSummary = value;
    }

    public Offers getOffers() {
        return offers;
    }

    public void setOffers(Offers value) {
        this.offers = value;
    }

    public VariationSummary getVariationSummary() {
        return variationSummary;
    }

    public void setVariationSummary(VariationSummary value) {
        this.variationSummary = value;
    }

    public Variations getVariations() {
        return variations;
    }

    public void setVariations(Variations value) {
        this.variations = value;
    }

    public CustomerReviews getCustomerReviews() {
        return customerReviews;
    }

    public void setCustomerReviews(CustomerReviews value) {
        this.customerReviews = value;
    }

    public EditorialReviews getEditorialReviews() {
        return editorialReviews;
    }

    public void setEditorialReviews(EditorialReviews value) {
        this.editorialReviews = value;
    }

    public SimilarProducts getSimilarProducts() {
        return similarProducts;
    }

    public void setSimilarProducts(SimilarProducts value) {
        this.similarProducts = value;
    }

    public Accessories getAccessories() {
        return accessories;
    }

    public void setAccessories(Accessories value) {
        this.accessories = value;
    }

    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks value) {
        this.tracks = value;
    }

    public BrowseNodes getBrowseNodes() {
        return browseNodes;
    }

    public void setBrowseNodes(BrowseNodes value) {
        this.browseNodes = value;
    }

    public Item.AlternateVersions getAlternateVersions() {
        return alternateVersions;
    }

    public void setAlternateVersions(Item.AlternateVersions value) {
        this.alternateVersions = value;
    }

    public static class AlternateVersions {
        protected List<Item.AlternateVersions.AlternateVersion> alternateVersion;

        public List<Item.AlternateVersions.AlternateVersion> getAlternateVersion() {
            if (alternateVersion == null) {
                alternateVersion = new ArrayList<Item.AlternateVersions.AlternateVersion>();
            }
            return this.alternateVersion;
        }

        public static class AlternateVersion {

            protected String asin;
            protected String title;
            protected String binding;

            public String getASIN() {
                return asin;
            }

            public void setASIN(String value) {
                this.asin = value;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String value) {
                this.title = value;
            }

            public String getBinding() {
                return binding;
            }

            public void setBinding(String value) {
                this.binding = value;
            }
        }
    }

    public static class ImageSets {
        protected List<ImageSet> imageSet;

        public List<ImageSet> getImageSet() {
            if (imageSet == null) {
                imageSet = new ArrayList<ImageSet>();
            }
            return this.imageSet;
        }
    }

    public static class Subjects {

        protected List<String> subject;

        public List<String> getSubject() {
            if (subject == null) {
                subject = new ArrayList<String>();
            }
            return this.subject;
        }
    }

    public static class VariationAttributes {
        protected List<VariationAttribute> variationAttribute;

        public List<VariationAttribute> getVariationAttribute() {
            if (variationAttribute == null) {
                variationAttribute = new ArrayList<VariationAttribute>();
            }
            return this.variationAttribute;
        }
    }
}
