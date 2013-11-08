
package com.ECS.client.jax;

import java.util.ArrayList;
import java.util.List;

public class Arguments {
    protected List<Arguments.Argument> argument;

    public List<Arguments.Argument> getArgument() {
        if (argument == null) {
            argument = new ArrayList<Arguments.Argument>();
        }
        return this.argument;
    }

    public static class Argument {
        protected String name;
        protected String value;

        public String getName() {
            return name;
        }

        public void setName(String value) {
            this.name = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }

}
