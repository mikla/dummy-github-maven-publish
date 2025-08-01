package io.mikla.rstring

/**
 * Example usage of the RString library.
 * 
 * This file demonstrates various ways to use the RString object
 * to generate random strings for different purposes.
 */
object Example {
  
  def main(args: Array[String]): Unit = {
    println("=== RString Library Examples ===\n")
    
    // Basic random string generation
    println("1. Basic random strings:")
    println(s"   Alphanumeric (10 chars): ${RString.randomString(10)}")
    println(s"   Lowercase (8 chars): ${RString.randomLowercase(8)}")
    println(s"   Uppercase (8 chars): ${RString.randomUppercase(8)}")
    println(s"   Digits (6 chars): ${RString.randomDigits(6)}")
    println(s"   Mixed (12 chars): ${RString.randomMixed(12)}")
    println()
    
    // Range-based generation
    println("2. Range-based generation:")
    println(s"   Length 5-15: ${RString.randomStringRange(5, 15)}")
    println(s"   Length 5-15: ${RString.randomStringRange(5, 15)}")
    println(s"   Length 5-15: ${RString.randomStringRange(5, 15)}")
    println()
    
    // UUID-like generation
    println("3. UUID-like strings:")
    println(s"   UUID: ${RString.randomUUID()}")
    println(s"   UUID: ${RString.randomUUID()}")
    println()
    
    // Custom character sets
    println("4. Custom character sets:")
    println(s"   Only vowels: ${RString.randomCustom(10, Set('a', 'e', 'i', 'o', 'u'))}")
    println(s"   Only symbols: ${RString.randomCustom(8, Set('!', '@', '#', '$', '%', '^', '&', '*'))}")
    println(s"   Binary: ${RString.randomCustom(16, Set('0', '1'))}")
    println()
    
    // Multiple generations
    println("5. Multiple generations (all should be different):")
    val strings = (1 to 5).map(_ => RString.randomString(8))
    strings.zipWithIndex.foreach { case (str, i) =>
      println(s"   String ${i + 1}: $str")
    }
    println()
    
    println("=== End of Examples ===")
  }
} 