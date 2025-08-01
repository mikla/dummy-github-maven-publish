package io.mikla.rstring

import scala.util.Random

/**
 * A simple library for generating random strings in Scala 3.
 * 
 * This library provides various methods to generate random strings
 * with different characteristics like length, character sets, etc.
 */
object RString {
  
  private val random = new Random()
  
  // Character sets for different types of strings
  private val lowercase = ('a' to 'z').toSet
  private val uppercase = ('A' to 'Z').toSet
  private val digits = ('0' to '9').toSet
  private val alphanumeric = lowercase ++ uppercase ++ digits
  private val specialChars = Set('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '[', ']', '{', '}', '|', '\\', ':', ';', '"', '\'', '<', '>', ',', '.', '?', '/')
  private val allChars = alphanumeric ++ specialChars
  
  /**
   * Generates a random string of specified length using alphanumeric characters.
   * 
   * @param length the length of the string to generate
   * @return a random alphanumeric string
   */
  def randomString(length: Int): String = {
    require(length >= 0, "Length must be non-negative")
    if (length == 0) return ""
    
    val chars = alphanumeric.toArray
    (1 to length).map(_ => chars(random.nextInt(chars.length))).mkString
  }
  
  /**
   * Generates a random string of specified length using only lowercase letters.
   * 
   * @param length the length of the string to generate
   * @return a random lowercase string
   */
  def randomLowercase(length: Int): String = {
    require(length >= 0, "Length must be non-negative")
    if (length == 0) return ""
    
    val chars = lowercase.toArray
    (1 to length).map(_ => chars(random.nextInt(chars.length))).mkString
  }
  
  /**
   * Generates a random string of specified length using only uppercase letters.
   * 
   * @param length the length of the string to generate
   * @return a random uppercase string
   */
  def randomUppercase(length: Int): String = {
    require(length >= 0, "Length must be non-negative")
    if (length == 0) return ""
    
    val chars = uppercase.toArray
    (1 to length).map(_ => chars(random.nextInt(chars.length))).mkString
  }
  
  /**
   * Generates a random string of specified length using only digits.
   * 
   * @param length the length of the string to generate
   * @return a random numeric string
   */
  def randomDigits(length: Int): String = {
    require(length >= 0, "Length must be non-negative")
    if (length == 0) return ""
    
    val chars = digits.toArray
    (1 to length).map(_ => chars(random.nextInt(chars.length))).mkString
  }
  
  /**
   * Generates a random string of specified length using all available characters.
   * 
   * @param length the length of the string to generate
   * @return a random string with all character types
   */
  def randomMixed(length: Int): String = {
    require(length >= 0, "Length must be non-negative")
    if (length == 0) return ""
    
    val chars = allChars.toArray
    (1 to length).map(_ => chars(random.nextInt(chars.length))).mkString
  }
  
  /**
   * Generates a random string with a length between min and max (inclusive).
   * 
   * @param minLength the minimum length of the string
   * @param maxLength the maximum length of the string
   * @return a random alphanumeric string with length between min and max
   */
  def randomStringRange(minLength: Int, maxLength: Int): String = {
    require(minLength >= 0, "Minimum length must be non-negative")
    require(maxLength >= minLength, "Maximum length must be greater than or equal to minimum length")
    
    val length = if (minLength == maxLength) minLength else random.between(minLength, maxLength + 1)
    randomString(length)
  }
  
  /**
   * Generates a random UUID-like string (32 hexadecimal characters).
   * 
   * @return a random UUID-like string
   */
  def randomUUID(): String = {
    val hexChars = "0123456789abcdef".toArray
    (1 to 32).map(_ => hexChars(random.nextInt(hexChars.length))).mkString
  }
  
  /**
   * Generates a random string using a custom character set.
   * 
   * @param length the length of the string to generate
   * @param chars the character set to use
   * @return a random string using the specified characters
   */
  def randomCustom(length: Int, chars: Set[Char]): String = {
    require(length >= 0, "Length must be non-negative")
    require(chars.nonEmpty, "Character set must not be empty")
    if (length == 0) return ""
    
    val charArray = chars.toArray
    (1 to length).map(_ => charArray(random.nextInt(charArray.length))).mkString
  }
} 