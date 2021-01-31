package com.knoldus.db
import org.scalatest.flatspec.AnyFlatSpec

/*In the below class, we're testing that the if the user  exist or not in the databse
by using the method getUserByName and in this we're passing the name of the user to test it
 */

class UserReadDtoTest extends AnyFlatSpec {
  "User" should "exist" in {
    val UserReadDto = new UserReadDto
    val result = UserReadDto.getUserByName("Alka")
    assert(!result.isEmpty)
  }

  "User" should "not exist" in {
    val UserReadDto = new UserReadDto
    val result = UserReadDto.getUserByName("Ayushi")
    assert(result.isEmpty)
  }

}
