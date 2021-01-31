package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator

/*In the below class, we're defining the function userIsValid .
In this, we're checking this by using the method, userIsValid
and returning emailId if condition is true else None
*/
class UserImpl(userValidator: UserValidator) {


  def createUser(user: User): Option[String] = {
    if (userValidator.userIsValid(user)) Option(user.emailId)
    else None
  }
}
