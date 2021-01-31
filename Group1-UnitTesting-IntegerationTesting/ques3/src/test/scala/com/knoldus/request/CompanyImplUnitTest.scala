package com.knoldus.request
//import com.knoldus.request.CompanyImpl
import org.mockito.MockitoSugar.{mock, when}
import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator
import org.scalatest.flatspec.AnyFlatSpec

/*In the below class, we're performing Unit testing for CompanyImplUnit,
Here, we're mocking the CompanyValidator class and we're  matching our arguments
combination by using stub methods (when,thenReturn) using Mockito functions.
Finally,we're creating a variable in which we're accessing the createCompany method
* with the help of object created, then in the parameters we're passing KnoldusCompany
and then testing the test cases
 */
class CompanyImplUnitTest extends AnyFlatSpec {

  val mockedCompanyValidate = mock[CompanyValidator]
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val amazonCompany: Company = Company("Amazon", "amazon@gmail.com", "US")

  "Company" should "be created" in {
    val companyImpl = new CompanyImpl(mockedCompanyValidate)
    when(mockedCompanyValidate.companyIsValid(knoldusCompany)) thenReturn (true)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(!result.isEmpty)
  }

  "Company" should "not be created" in {
    val companyImpl = new CompanyImpl(mockedCompanyValidate)
    when(mockedCompanyValidate.companyIsValid(amazonCompany)) thenReturn (false)
    val result = companyImpl.createCompany(amazonCompany)
    assert(result.isEmpty)
  }

}
