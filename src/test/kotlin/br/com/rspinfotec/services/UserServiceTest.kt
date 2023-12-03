package br.com.rspinfotec.services

import br.com.rspinfotec.constants.UsersContants.USERS
import br.com.rspinfotec.constants.UsersContants.USER_1
import br.com.rspinfotec.constants.UsersContants.USER_PAYLOAD
import br.com.rspinfotec.domain.user.UserServicePort
import br.com.rspinfotec.repository.UserRepository
import br.com.rspinfotec.shared.exceptions.ApiException
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@MicronautTest(startApplication = false)
class UserServiceTest(
    private val userService: UserServicePort,
    private val userRepository: UserRepository
) {

    @MockBean(UserRepository::class)
    fun userRepository(): UserRepository =
        mock(UserRepository::class.java)

    @Test
    fun testGetAllUserReturnSuccess() {
        `when`(userRepository.findAll()).thenReturn(USERS)
        val sut = userService.getAllUsers()
        assertThat(sut.size).isEqualTo(1)
    }

    @Test
    fun testGetByUserNameExistingReturnSuccess() {
        `when`(userRepository.findByUserName(USER_1.userName)).thenReturn(USER_1)
        val sut = userService.getUserByUserName(USER_1.userName)
        assertThat(sut.id).isEqualTo(USER_1.id)
    }

    @Test
    fun testGetByUserNameInsistingReturnApiException() {
        `when`(userRepository.findByUserName(USER_1.userName)).thenReturn(null)
        assertThatThrownBy { userService.getUserByUserName("john do") }.isInstanceOf(ApiException::class.java)
    }

    @Test
    fun testCreateUserReturnSuccess() {
        `when`(userRepository.save(USER_1)).thenReturn(USER_1)
        val sut = userService.createUser(USER_PAYLOAD)
        assertThat(sut.userName).isEqualTo(USER_1.userName)
    }

    @Test
    fun testCreateUserReturnApiException() {
        `when`(userRepository.findByUserName(USER_1.userName)).thenReturn(USER_1)
        assertThatThrownBy { userService.createUser(USER_PAYLOAD) }.isInstanceOf(ApiException::class.java)
    }


}