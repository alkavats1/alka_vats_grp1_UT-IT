package com.knoldus.validator
import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.knoldus.models.Company
import org.scalatest.flatspec.AnyFlatSpec
import org.mockito.MockitoSugar.{mock, when}

/* In the below class, for each test case
* We're mocking companyReadDto and EmailValidator upon which UserValidator depends,
* Then, while creating an object for UserValidator class we passed on the mocked parameter.
* And, Then we're  matching our arguments combination by using stub methods (when,thenReturn) using Mockito functions.
* Finally,we're creating a variable in which we're accessing the userIsvalid method
* with the help of object created, then in the parameters we're passing ayushiUser
*/
class UserValidatorTest extends AnyFlatSpec {

  val amazonCompany: Company = Company("Amazon", "amazon@gmail.com", "US")
  val ayushiUser: User = User("Ayuhsi","Sharma","Amazon","ayushi@amazon.com")
  val mockedCompanyREadDto = mock[CompanyReadDto]
  val mockedEmailValidator = mock[EmailValidator]

  "User" should "be a valid user" in{
    when(mockedCompanyREadDto.getCompanyByName(ayushiUser.companyName)) thenReturn(Option(amazonCompany))
    when(mockedEmailValidator.emailIdIsValid(ayushiUser.emailId)) thenReturn(true)
    val userValidator= new UserValidator(mockedCompanyREadDto ,  mockedEmailValidator)
    val result=userValidator.userIsValid(ayushiUser)
    assert(result)
  }

  "User" should "be a invalid user as it already exists" in{
    when(mockedCompanyREadDto.getCompanyByName(ayushiUser.companyName)) thenReturn(None)
    when(mockedEmailValidator.emailIdIsValid(ayushiUser.emailId)) thenReturn(true)
    val userValidator= new UserValidator(mockedCompanyREadDto ,  mockedEmailValidator)
    val result=userValidator.userIsValid(ayushiUser)
    assert(!result)
  }

  "User" should "be a invalid user and email id is valid" in{
    when(mockedCompanyREadDto.getCompanyByName(ayushiUser.companyName)) thenReturn(Option(amazonCompany))
    when(mockedEmailValidator.emailIdIsValid(ayushiUser.emailId)) thenReturn(false)
    val UserValidator= new UserValidator(mockedCompanyREadDto ,  mockedEmailValidator)
    val result=UserValidator.userIsValid(ayushiUser)
    assert(!result)
  }

  "User" should "be a invalid user and as email id is invalid" in{
    when(mockedCompanyREadDto.getCompanyByName(ayushiUser.companyName)) thenReturn(None)
    when(mockedEmailValidator.emailIdIsValid(ayushiUser.emailId)) thenReturn(false)
    val userValidator= new UserValidator(mockedCompanyREadDto ,  mockedEmailValidator)
    val result=userValidator.userIsValid(ayushiUser)
    assert(!result)
  }

}
