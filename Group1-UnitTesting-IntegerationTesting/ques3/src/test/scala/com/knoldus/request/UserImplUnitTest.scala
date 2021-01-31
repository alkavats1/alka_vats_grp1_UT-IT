package com.knoldus.request
import com.knoldus.models.{Company, User}
import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}


/*In the below class, we're performing Unit testing for UserImplUnit,
Here, we're mocking the UserValidator class and we're  matching our arguments
combination by using stub methods (when,thenReturn) using Mockito functions.
Finally,we're creating a variable in which we're accessing the createUser method
* with the help of object created, then in the parameters we're passing alkaUser
and then testing the test cases
 */
class UserImplUnitTest extends AnyFlatSpec {

  val mockedUserValidate = mock[UserValidator]
  val ayushiUser: User = User("Ayushi","Sharma","Amazon","ayushi@amazon.com")
  val alkaUser: User = User("Alka","Vats","Knoldus","alka.vats@knoldus.com")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  "User" should "be valid" in {
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(alkaUser)) thenReturn (true)
    val result = userImpl.createUser(alkaUser)
    assert(!result.isEmpty)
  }

  "User" should "be not valid" in {
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(ayushiUser)) thenReturn (false)
    val result = userImpl.createUser(ayushiUser)
    assert(result.isEmpty)
  }
}
