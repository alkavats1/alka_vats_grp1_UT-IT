package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company

/*In the below class, we're defining the function companyIsValid .
In this, we're checking the company name by using getCompanyByName method
and simultaneously validating the email and returning true if condition is true else false
*/
class CompanyValidator(companyName: CompanyReadDto, validateEmail: EmailValidator) {

  def companyIsValid(company: Company): Boolean = {

    if (companyName.getCompanyByName(company.name).isEmpty &&
      validateEmail.emailIdIsValid(company.emailId))
      true
    else
      false
  }
}


