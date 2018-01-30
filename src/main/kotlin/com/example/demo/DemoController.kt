package com.example.demo

import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotEmpty
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/demo")
class DemoController(val personRepository: PersonRepository) {
    @GetMapping
    fun list(): Iterable<Person> {
        return personRepository.findAll()
    }

    @PostMapping
    fun create(@RequestBody @Valid personRequest: CreatePersonRequest): Person {
        return personRepository.save(personRequest.toPerson())
    }

    data class CreatePersonRequest(
            @NotEmpty @Email val email: String,
            @NotEmpty val password: String
    ) {
        fun toPerson(): Person {
            return Person(email = email, password = password)
        }
    }
}




