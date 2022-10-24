package wood.mike

class Address {

    String addressLine1
    String addressLine2
    String addressLine3
    String addressLine4
    String addressLine5

    static constraints = {
        addressLine1 nullable: false
        addressLine2 nullable: true
        addressLine3 nullable: true
        addressLine4 nullable: true
        addressLine5 nullable: true
    }
}
