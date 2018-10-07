package io.rcw.examples;

public interface Entry {
    String getKey();

    int getValue();

    /**
     * The builder pattern
     */
    final class Builder {
        private String key;
        private int value;

        public Builder key(String key) {
            this.key = key;
            return this;
        }

        public Builder value(int value) {
            this.value = value;
            return this;
        }

        public Entry build() {
            return new Entry() {
                @Override
                public String getKey() {
                    return key;
                }

                @Override
                public int getValue() {
                    return value;
                }
            };
        }

    }
}
