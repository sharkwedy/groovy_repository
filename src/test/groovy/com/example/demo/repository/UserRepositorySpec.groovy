package com.example.demo.repository

import com.example.demo.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import spock.lang.Specification

import java.util.UUID

@DataJpaTest
class UserRepositorySpec extends Specification {
    @Autowired
    UserRepository userRepository

    def "test save and find user"() {
        given:
        def user = new User(name: "John Doe", age: 30, team: null)

        when:
        userRepository.save(user)
        def foundUser = userRepository.findById(user.id)

        then:
        foundUser.isPresent()
        foundUser.get().name == "John Doe"
    }
}