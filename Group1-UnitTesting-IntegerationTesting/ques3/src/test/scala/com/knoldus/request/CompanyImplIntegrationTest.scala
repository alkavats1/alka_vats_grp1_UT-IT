package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import org.scalatest.flatspec.AnyFlatSpec

/*In the below class, we're performing Integration testing for CompanyImplUnit,
where we're creating an object for CompanyReadDto and EmailValidator Class,
then we're creating an object for CompanyValidator class where we're passing above two objects as parameter,
And, then we're making an object for CompanyUnitImpl class passing above object created as parameter,
Finally, we're accessing createCompany,
In it's parameter we're passing the value defined in each test cases
 */
class CompanyImplIntegrationTest extends AnyFlatSpec {
  val companyReadDto = new CompanyReadDto
  val emailValidator = new EmailValidator
  val companyValidator = new CompanyValidator(companyReadDto, emailValidator)
  val companyImpl = new CompanyImpl(companyValidator)


  "Company" should "be valid" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
    val result =  companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  "Company" should "be invalid as it already exists in DB" in {
    val amazonCompany: Company = Company("Amazon", "amazon@gmail.com", "US")
    val result =  companyImpl.createCompany(amazonCompany)
    assert(!result.isEmpty)
  }

  "Company" should "be invalid as email id is invalid" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldusgmail.com", "Noida")
    val result =  companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  "Company" should "be invalid as email id is invalid and company already exists in DB" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldusgmail.com", "Noida")
    val result =  companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }


}
