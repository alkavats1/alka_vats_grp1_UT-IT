package com.knoldus.request
import com.knoldus.db.{CompanyReadDto, UserReadDto}
import com.knoldus.models.Company
import com.knoldus.validator.{EmailValidator, CompanyValidator}

/*In the below object Application, we're defining the function main to companyValidation to
 check company should not be in the DB.
Here, we're creating the object of companyReadDto and EmailValidator depends on companyValidator.
Then , we're creating object of companyValidator in which we're passing two parameters
then object of companyImpl is created which is depend on companyValidator.
company values were defined which is used companyImpl, this creating the company Values and
assigning to variable result.
*/
object Application {
  def main(args: Array[String]) = {
    val companyReadDto = new CompanyReadDto
    val emailValidator = new EmailValidator
    val companyValidator = new CompanyValidator(companyReadDto, emailValidator)
    val companyImpl = new CompanyImpl(companyValidator)
    val company: Company = Company("TTN", "knoldus@gmail.com", "Noida")
    val result =  companyImpl.createCompany(company)
    println(result)
  }
}