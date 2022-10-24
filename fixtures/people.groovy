import wood.mike.Person
import wood.mike.Address

include 'addresses'
include 'pets'

build {
    // we don't need to use ref for the relationships here because the addresses and pets have already been built but we can if we want
    mike(Person, forename: 'Mike', surname: 'Wood', addresses: [ref('homeAddress')], pets: [ref('dave')])
    frank(Person, forename: 'Frank', surname: 'Drebin', addresses: [ref('theMoon')], pets: [ref('jaws')])
    arnold(Person, forename: 'Arnold', surname: 'Schwarzenegger', addresses: [theWhiteHouse], pets: [bugs, mo])

    // we must use ref for the address here because it's defined after
    bob(Person, forename: 'Bob', surname: 'Mortimer', 'addresses': [ref('bobsAddress')])
    bobsAddress(Address, addressLine1: 'The shire')
}