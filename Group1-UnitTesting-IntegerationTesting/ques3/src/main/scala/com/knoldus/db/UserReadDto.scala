package com.knoldus.db

import com.knoldus.models.User

import scala.collection.immutable.HashMap

// User database values
class UserReadDto {

  val alkaUser: User = User("Alka","Vats","knoldus","alka.vats@knoldus.com")
  val nitinUser: User= User("Nitin","Saini","Nagarro","nitin.saini@nagarro.com")
  val user:Map[String, User] = HashMap("Alka" -> alkaUser, "Nitin" -> nitinUser)

  def getUserByName(name: String): Option[User] = user.get(name)

}
