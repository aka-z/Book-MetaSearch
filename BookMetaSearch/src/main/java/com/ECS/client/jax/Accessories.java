
package com.ECS.client.jax;

import java.util.ArrayList;
import java.util.List;

public class Accessories {

    protected List<Accessories.Accessory> accessory;

    public List<Accessories.Accessory> getAccessory() {
        if (accessory == null) {
            accessory = new ArrayList<Accessories.Accessory>();
        }
        return this.accessory;
    }

    public static class Accessory {

        protected String asin;
        protected String title;

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
    }
}
