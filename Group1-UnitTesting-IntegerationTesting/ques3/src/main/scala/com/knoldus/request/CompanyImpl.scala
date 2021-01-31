package com.knoldus.request

import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator

/*In the below class, we're defining the function companyIsValid .
In this, we're checking this by using the method, companyIsValid
and returning company.name if condition is true else none
*/
class CompanyImpl(companyValidator: CompanyValidator) {

  def createCompany(company: Company): Option[String] = {
    if (companyValidator.companyIsValid(company)) Option(company.name)
    else None
  }
}
