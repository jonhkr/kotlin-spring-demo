package com.example.demo

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@RunWith(SpringRunner::class)
@WebMvcTest(controllers = [(DemoController::class)])
class DemoControllerTests {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var personRepository: PersonRepository

    @Test
    fun apiTest() {
        Mockito.`when`(personRepository.findAll()).thenReturn(ArrayList())

        mockMvc.perform(MockMvcRequestBuilders.get("/api/demo"))
                .andExpect(status().isOk)
    }

}