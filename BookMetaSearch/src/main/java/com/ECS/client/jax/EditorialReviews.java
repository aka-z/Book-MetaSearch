
package com.ECS.client.jax;

import java.util.ArrayList;
import java.util.List;

public class EditorialReviews {
    protected List<EditorialReview> editorialReview;

    public List<EditorialReview> getEditorialReview() {
        if (editorialReview == null) {
            editorialReview = new ArrayList<EditorialReview>();
        }
        return this.editorialReview;
    }

}
