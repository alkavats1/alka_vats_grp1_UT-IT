package com.knoldus.ques1

//Compute class inherits trait
class CalculateImpl extends Calculate
{
  // function to  divide two numbers
  def divide(divident: Int,divisor: Int) :Double = {

    // throw exception if a number is divided by zero
    if(divisor == 0){
      throw new ArithmeticException("Not divisible by zero")
    }
    divident/divisor
  }

  // return fibonacci Sequence to a certain Number

  def fibonacci(num:Int):List[Int]={

    // throw exception if a number is negative
    if(num<0)
      throw new IllegalArgumentException("Negetive number not allowed")
    var FibonacciSeries = List.empty[Int]
    var firstTerm = 0
    var secondTerm = 1
    var nextTerm=0
    while(nextTerm<=num){

      // Append next term in the list
      FibonacciSeries=FibonacciSeries:+nextTerm
      firstTerm=secondTerm
      secondTerm=nextTerm
      nextTerm=firstTerm+secondTerm
    }
    FibonacciSeries
  }
}
