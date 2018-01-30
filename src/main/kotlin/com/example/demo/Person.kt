package com.example.demo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "person")
data class Person(
        @Id @GeneratedValue val id: Long ?= null,
        val email: String,
        val password: String
)