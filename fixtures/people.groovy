import wood.mike.Person

include 'addresses'
include 'pets'

build {
    mike(Person, forename: 'Mike', surname: 'Wood', addresses: [ref('homeAddress')], pets: [ref('dave')])
    frank(Person, forename: 'Frank', surname: 'Drebin', addresses: [ref('theMoon')], pets: [ref('jaws')])
}