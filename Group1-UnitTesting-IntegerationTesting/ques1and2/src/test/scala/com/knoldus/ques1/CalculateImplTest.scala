package com.knoldus.ques1
import org.scalatest.flatspec.AnyFlatSpec


// Test cases for Divide and fibonacci function

class CalculateImplTest extends AnyFlatSpec{
  val obj = new CalculateImpl
  "Divide" should "have 2 numbers" in {
    val result: Double= obj.divide(8,2)
    assert(result == 4.0)
  }

  it should "through ArithmaticException if attempted to divided by 0" in {
    assertThrows[ArithmeticException] {
      obj.divide(9,0)
    }
  }


  "Fibonacci" should "have a positive or zero number" in {
    var result: List[Int]= obj.fibonacci(10)
    assert(result==List(0, 1, 1, 2, 3, 5, 8))
  }
  it should "through IllegalArgumentException if negetive number provided" in {
    assertThrows[IllegalArgumentException] {
      obj.fibonacci(-2)
    }
  }
  it should "return 0 if 0 is provided" in {
    var result: List[Int]= obj.fibonacci(0)
    assert(result == List(0))
  }
}