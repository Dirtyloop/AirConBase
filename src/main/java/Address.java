import java.util.regex.Pattern;

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

    public static boolean validateCity(String city) {
        if(city.isBlank() || city.length()<3) return false;
        return true;
    }

    public static boolean validateStreet(String street) {
        if(street.isBlank() || street.length()<3) return false;
        return true;
    }

    public static boolean validateHouseNumber(String houseNumber) {
        return true;
    }

    public static boolean validatePostalCode(String postalCode) {
        if(!postalCode.isEmpty() && !Pattern.matches("[0-9]{2}-[0-9]{3}", postalCode)) return false;
        return true;
    }

    public static boolean validateProvince(String province) {
        return true;
    }
}
