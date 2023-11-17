package br.com.rspinfotec.services.user

import br.com.rspinfotec.constants.UsersContants.USERS
import br.com.rspinfotec.constants.UsersContants.USER_1
import br.com.rspinfotec.repository.UserRepository
import br.com.rspinfotec.controller.user.dto.UserRequestDTO
import br.com.rspinfotec.shared.security.exceptions.ApiException
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@MicronautTest
class UserServiceTest(
    private val userService: UserService,
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
        val sut = userService.createUser(USER_1)
        assertThat(sut).isEqualTo(USER_1)
    }

    @Test
    fun testCreateUserReturnApiException(){
        `when`(userRepository.findByUserName(USER_1.userName)).thenReturn(USER_1)
        assertThatThrownBy {userService.createUser(USER_1) }.isInstanceOf(ApiException::class.java)
    }


}