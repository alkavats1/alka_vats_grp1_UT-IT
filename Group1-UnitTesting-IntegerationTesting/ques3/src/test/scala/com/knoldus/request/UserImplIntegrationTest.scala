package com.knoldus.request
import com.knoldus.db.{CompanyReadDto, UserReadDto}
import com.knoldus.models.User
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.flatspec.AnyFlatSpec

/*In the below class, we're performing Integration testing for UserUnitImpl,
where we're creating an object for CompanyReadDto and EmailValidator Class,
then we're creating an object for UserValidator class where we're passing above two objects as parameter,
And, then we're making an object for userUnitImpl class passing above object created as parameter,
Finally, we're accessing createUser,
In it's parameter we're passing the value defined in each test cases
*/
class UserImplIntegrationTest extends AnyFlatSpec {
  val companyReadDto = new CompanyReadDto
  val emailValidator = new EmailValidator
  val userValidator = new UserValidator(companyReadDto, emailValidator)
  val userImpl = new UserImpl(userValidator)



  "User" should "be valid" in {
    val alkaUser: User = User("Alka","Vats","Knoldus","alka.vats@knoldus.com")
    val result =  userImpl.createUser(alkaUser)
    assert(!result.isEmpty)
  }

  "User" should "be invalid as it company doesnot exists in DB" in {
    val ayushiUser: User = User("Ayushi","Sharma","Amazon","ayushi@amazon.com")
    val result =  userImpl.createUser(ayushiUser)
    assert(result.isEmpty)
  }

  "User" should "be invalid as email id is invalid" in {
    val alkaUser: User = User("Alka","Vats","Knoldus","alka.vatsknoldus.com")
    val result = userImpl.createUser(alkaUser)
    assert(result.isEmpty)
  }

  "User" should "be invalid as email id is invalid and company does not exists in DB" in {
    val alkaUser: User= User("Alka","Vats","knoldus","alka.vatsknoldus.com")
    val result =  userImpl.createUser(alkaUser)
    assert(result.isEmpty)
  }
}
