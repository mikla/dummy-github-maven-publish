package io.mikla.rstring

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class RStringSpec extends AnyFunSuite with Matchers {
  
  test("randomString should generate string of correct length") {
    val length = 10
    val result = RString.randomString(length)
    result should have length length
  }
  
  test("randomString should generate alphanumeric characters only") {
    val result = RString.randomString(100)
    result should fullyMatch regex "[a-zA-Z0-9]+"
  }
  
  test("randomString with length 0 should return empty string") {
    RString.randomString(0) shouldBe ""
  }
  
  test("randomString should throw exception for negative length") {
    an [IllegalArgumentException] should be thrownBy RString.randomString(-1)
  }
  
  test("randomLowercase should generate only lowercase letters") {
    val result = RString.randomLowercase(50)
    result should fullyMatch regex "[a-z]+"
    result should have length 50
  }
  
  test("randomUppercase should generate only uppercase letters") {
    val result = RString.randomUppercase(50)
    result should fullyMatch regex "[A-Z]+"
    result should have length 50
  }
  
  test("randomDigits should generate only digits") {
    val result = RString.randomDigits(50)
    result should fullyMatch regex "[0-9]+"
    result should have length 50
  }
  
  test("randomMixed should generate strings with various characters") {
    val result = RString.randomMixed(100)
    result should have length 100
    // Should contain at least some special characters
    result.exists(c => "!@#$%^&*()".contains(c)) shouldBe true
  }
  
  test("randomStringRange should generate string within specified range") {
    val minLength = 5
    val maxLength = 15
    val result = RString.randomStringRange(minLength, maxLength)
    result.length should be >= minLength
    result.length should be <= maxLength
  }
  
  test("randomStringRange with same min and max should generate exact length") {
    val length = 8
    val result = RString.randomStringRange(length, length)
    result should have length length
  }
  
  test("randomStringRange should throw exception for invalid range") {
    an [IllegalArgumentException] should be thrownBy RString.randomStringRange(10, 5)
  }
  
  test("randomUUID should generate 32 character hex string") {
    val result = RString.randomUUID()
    result should have length 32
    result should fullyMatch regex "[0-9a-f]+"
  }
  
  test("randomCustom should generate string with custom characters") {
    val customChars = Set('x', 'y', 'z')
    val result = RString.randomCustom(20, customChars)
    result should have length 20
    result should fullyMatch regex "[xyz]+"
  }
  
  test("randomCustom should throw exception for empty character set") {
    an [IllegalArgumentException] should be thrownBy RString.randomCustom(10, Set.empty[Char])
  }
  
  test("randomCustom should throw exception for negative length") {
    an [IllegalArgumentException] should be thrownBy RString.randomCustom(-1, Set('a', 'b'))
  }
  
  test("multiple calls should generate different strings") {
    val results = (1 to 10).map(_ => RString.randomString(10))
    results.toSet should have size 10 // All should be different
  }
  
  test("randomString should handle edge cases") {
    RString.randomString(1) should have length 1
    RString.randomString(1000) should have length 1000
  }
} 