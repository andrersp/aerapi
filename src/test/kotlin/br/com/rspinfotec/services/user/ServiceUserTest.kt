package br.com.rspinfotec.services.user

import br.com.rspinfotec.repository.UserRepository
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.mockito.Mockito.mock
import br.com.rspinfotec.constants.UsersContants.USERS
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.assertj.core.api.Assertions.assertThat

@MicronautTest
class ServiceUserTest(
    private val uerService: UserService,
    private val userRepository: UserRepository
) {

    @MockBean(UserRepository::class)
    fun userRepository(): UserRepository =
        mock(UserRepository::class.java)

    @Test
    fun testGetAllUserReturnSuccess(){
        `when`(userRepository.findAll()).thenReturn(USERS)
        val sut = uerService.getAllUsers()
        assertThat(sut.size).isEqualTo(1)
    }

}