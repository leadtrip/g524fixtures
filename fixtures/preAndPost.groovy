import wood.mike.Person
import wood.mike.Address

import java.time.LocalDate
import java.time.Month

def personName

pre{
    personName = 'Jeff'
}

fixture{
    theTwilightZone(Address, addressLine1: 'The twilight zone')
    jeff(Person, forename: personName, surname: 'Potato', dob: LocalDate.of(2001, Month.APRIL, 2))
}

post{
    jeff.addToAddresses(theTwilightZone)
}