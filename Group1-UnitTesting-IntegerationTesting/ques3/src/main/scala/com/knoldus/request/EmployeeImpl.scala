package com.knoldus.request

import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator

/*In the below class, we're defining the function employeeIsValid .
In this, we're checking this by using the method, employeeIsValid
and returning emailId if condition is true else None
*/
class EmployeeImpl(employeeValidator: EmployeeValidator) {

  def createEmployee(employee: Employee): Option[String] = {
    if (employeeValidator.employeeIsValid(employee)) Option(employee.emailId)
    else None
  }
}
