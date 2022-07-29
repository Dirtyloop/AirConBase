public class Address {
    private final String city;
    private final String street;
    private final String houseNumber;
    private final String postalCode;
    private final String province;

    public static class Builder {
        private final String city;
        private final String street;
        private final String houseNumber;

        private String postalCode = "";
        private String province = "";

        public Builder(String city, String street, String houseNumber) {
            this.city = city;
            this.street = street;
            this.houseNumber = houseNumber;
        }

        public Builder postalCode(String val)
            { postalCode = val; return this; }
        public Builder province(String val)
            { province = val; return this; }

        public Address build() {
            if(city.isEmpty()) {
                throw new IllegalStateException("City cannot be empty!");
            }
            return new Address(this);
        }
    }

    private Address(Builder builder) {
        city = builder.city;
        street = builder.street;
        houseNumber = builder.houseNumber;
        postalCode = builder.postalCode;
        province = builder.province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
