package com.knoldus.ques2


class EmailValid{

  // function to check the email is valid or not
  def emailIdIsValid(emailId: String): Boolean = {
    val regex= """^([_|a-zA-Z\d\.-]+)@([a-zA-Z\d-]+)\.(com|net|org)$"""
    return emailId.matches(regex)
  }

 // main function
  def main(args:Array[String]): Unit ={
    val ch= emailIdIsValid("example@gmail.com")
    println(ch)
  }

}
