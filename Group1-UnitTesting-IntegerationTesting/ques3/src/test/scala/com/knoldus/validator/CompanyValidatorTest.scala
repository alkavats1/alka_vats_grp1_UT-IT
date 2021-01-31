package com.knoldus.validator
import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

/* In the below class, for each test case
* We're mocking companyReadDto and EmailValidator upon which CompanyValidator depends,
* Then, while creating an object for CompanyValidator class we passed on the mocked parameter.
* And, Then we're  matching our arguments combination by using stub methods (when,thenReturn) using Mockito functions.
* Finally,we're creating a variable in which we're accessing the companyIsvalid method
* with the help of object created, then in the parameters we're passing KnoldusCompany
*/

class CompanyValidatorTest extends AnyFlatSpec {
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val mockedCompanyReadDto = mock[CompanyReadDto]
  val mockedEmailValidator = mock[EmailValidator]

  "Company" should "be valid because company does not exist in the DB and email is valid" in {
    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(None)
    when(mockedEmailValidator.emailIdIsValid(knoldusCompany.emailId)) thenReturn(true)
    val companyValidator = new CompanyValidator(mockedCompanyReadDto,mockedEmailValidator)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(result)
  }
  "Company" should "be invalid as company exist in DB and email is valid" in {
    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(Option(knoldusCompany))
    when(mockedEmailValidator.emailIdIsValid(knoldusCompany.emailId)) thenReturn(true)
    val companyValidator = new CompanyValidator(mockedCompanyReadDto,mockedEmailValidator)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }



  "Company" should "be valid as the email id is invalid" in {
    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(None)
    when(mockedEmailValidator.emailIdIsValid(knoldusCompany.emailId)) thenReturn(false)
    val companyValidator = new CompanyValidator(mockedCompanyReadDto,mockedEmailValidator)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }

  "Company" should "be invalid as the email id is not valid and it already exists in DB " in {
    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn((Option(knoldusCompany)))
    when(mockedEmailValidator.emailIdIsValid(knoldusCompany.emailId)) thenReturn(false)
    val companyValidator = new CompanyValidator(mockedCompanyReadDto,mockedEmailValidator)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }

}
