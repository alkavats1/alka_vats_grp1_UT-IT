package com.knoldus.db
import com.knoldus.models.Company
import org.scalatest.flatspec.AnyFlatSpec

/*In the below class, we're testing that the company is exist or not in the databse
by using the method getCompanyByName and in this we're passing the name of the company to test it
 */
class CompanyReadDtoTest extends AnyFlatSpec {

  "Company" should "exist" in {
    val companyReadDto = new CompanyReadDto
    val result = companyReadDto.getCompanyByName("Knoldus")
    assert(!result.isEmpty)
  }

  "Company" should "not exist" in {
    val companyReadDto = new CompanyReadDto
    val result = companyReadDto.getCompanyByName("Amazon")
    assert(result.isEmpty)
  }

}
