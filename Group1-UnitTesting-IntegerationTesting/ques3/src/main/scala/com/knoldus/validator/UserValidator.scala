package com.knoldus.validator

import com.knoldus.models.User

import com.knoldus.db.CompanyReadDto

/*In the below class, we're defining the function userIsValid .
In this, we're checking the company name by using getCompanyByName method
and simultaneously validating the email and returning true if condition is true else false
*/
class UserValidator (companyName: CompanyReadDto, validateEmail: EmailValidator){

  def userIsValid(user: User): Boolean = {
    if (!companyName.getCompanyByName(user.companyName).isEmpty &&
      validateEmail.emailIdIsValid(user.emailId))
      true
    else
      false
  }
}
