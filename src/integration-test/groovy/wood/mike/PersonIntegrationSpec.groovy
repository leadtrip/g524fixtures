package wood.mike

import grails.gorm.transactions.Rollback
import grails.plugin.fixtures.FixtureLoader
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
@Rollback
class PersonIntegrationSpec extends Specification{

    FixtureLoader fixtureLoader

    void "test load people"() {
        when:
            def people = fixtureLoader.load('people')
        then:
            people.mike.forename == 'Mike'
            people.mike.pets[0].name == 'Dave'
        and:
            people.frank.forename == 'Frank'
            people.frank.addresses[0].addressLine1 == 'The moon'
        and:
            people.arnold.surname == 'Schwarzenegger'
            people.arnold.pets*.name.containsAll( 'Bugs', 'Mo' )
        and:
            Address.findByAddressLine1('The shire')
            people.bob.forename == 'Bob'
            people.bob.addresses[0].addressLine1 == 'The shire'
    }

    /**
     * Using the fixture loader in tandem with build-test-data plugin
     */
    void "test build on fixtureLoader"() {
        when:
            def fixture = fixtureLoader.build {
                nigel(Person, forename: 'Nigel')
            }
        then:
            fixture.nigel.forename == 'Nigel'
            fixture.nigel.surname != null
            fixture.nigel.dob != null
    }

    void "test pre and post processing"() {
        when:
            def pAndp = fixtureLoader.load( 'preAndPost' )
            def jeff = pAndp.jeff
        then:
            jeff.addresses[0].addressLine1 == 'The twilight zone'
    }
}
