package com.knoldus.validator

/*In the below class, we're defining the function emailIsValid .
In this, we're checking the emailId is valid or not by using emailIsValid method
*/
class EmailValidator {

  def emailIdIsValid(emailId: String): Boolean = {
    var regex= """^([_|a-zA-Z\d\.-]+)@([a-zA-Z\d-]+)\.(com|net|org)$"""
    return emailId.matches(regex);
  }
}
