package wood.mike

class Pet {

    String name
    String type

    static constraints = {
        name nullable: false
        type nullable: false
    }
}
