package com.knoldus.validator
import org.scalatest.flatspec.AnyFlatSpec


/*In the below class, we're testing that the if the email is valid or not
by using the method emailIsValid and in this we're passing the tests in it
 */
class EmailValidatorTest extends AnyFlatSpec {
  val emailValidator = new EmailValidator
  "email" should "have alphanumeric username in lowercase and uppercase " in {
    var result: Boolean = emailValidator.emailIdIsValid("alka@knoldus.com")
    assert(result == true)
  }

  "email" should "valid when with starting numbers" in {
    var result: Boolean = emailValidator.emailIdIsValid("1239alka@knoldus.com")
    assert(result == true)
  }

  "email" should "valid when recipient name has dot and underscore" in {
    var result: Boolean = emailValidator.emailIdIsValid("6710203.alka-vats@knoldus.com")
    assert(result == true)
  }
  "email" should "invalid with missing @" in {
    var result: Boolean = emailValidator.emailIdIsValid("alkaknoldus.com")
    assert(result == false)
  }

  "email" should "invalid with starting with special symbols except dot and underscore" in {
    var result: Boolean = emailValidator.emailIdIsValid("*/alkaknoldus.com")
    assert(result == false)
  }

  "email" should "invalid with space in between" in {
    var result: Boolean = emailValidator.emailIdIsValid("alka @knoldus.com")
    assert(result == false)
  }

  "email" should "invalid with missing top level domain" in {
    var result: Boolean = emailValidator.emailIdIsValid("alka@knoldus")
    assert(result == false)
  }

  "email" should "invalid with missing domain main" in {
    var result: Boolean = emailValidator.emailIdIsValid("alka@.com")
    assert(result == false)
  }

  "email" should "invalid when wrong top level domain except .com/.org/.net" in {
    var result: Boolean = emailValidator.emailIdIsValid("alka@knoldus.xyz")
    assert(result == false)
  }

  "email" should "invalid with more than one top level domain" in {
    var result: Boolean = emailValidator.emailIdIsValid("alka@knoldus.com.net")
    assert(result == false)
  }

  "email" should "invalid with double dots after domain name" in {
    var result: Boolean = emailValidator.emailIdIsValid("alka@knoldus..com")
    assert(result == false)
  }
}
