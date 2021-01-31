package com.knoldus.models

// model structure of employee

case class Employee(firstName: String,
                    lastName: String,
                    age: Int,
                    salary: Double,
                    designation: String,
                    companyName: String,
                    emailId: String)
