# RString - Random String Generator for Scala 3

A simple and efficient Scala 3 library for generating random strings with various characteristics.

## Features

- Generate random strings with different character sets (alphanumeric, lowercase, uppercase, digits, mixed)
- Custom character set support
- UUID-like string generation
- Range-based length generation
- Thread-safe implementation
- Comprehensive test coverage

## Installation

### SBT

Add the following dependency to your `build.sbt`:

```scala
libraryDependencies += "io.github.mikla" %% "rstring" % "0.1.0"
```

### Maven

```xml
<dependency>
    <groupId>io.github.mikla</groupId>
    <artifactId>rstring_3</artifactId>
    <version>0.1.0</version>
</dependency>
```

## Usage

```scala
import io.mikla.rstring.RString

// Generate a random alphanumeric string of length 10
val randomStr = RString.randomString(10)
// Result: "aB3k9mN2pQ"

// Generate a random lowercase string
val lowercase = RString.randomLowercase(8)
// Result: "abcdefgh"

// Generate a random uppercase string
val uppercase = RString.randomUppercase(8)
// Result: "ABCDEFGH"

// Generate a random numeric string
val digits = RString.randomDigits(6)
// Result: "123456"

// Generate a random string with all character types
val mixed = RString.randomMixed(12)
// Result: "aB3!@#$%^&*()"

// Generate a random string with length between 5 and 15
val rangeStr = RString.randomStringRange(5, 15)
// Result: "aB3k9mN2pQ"

// Generate a UUID-like string (32 hex characters)
val uuid = RString.randomUUID()
// Result: "a1b2c3d4e5f678901234567890123456"

// Generate a string with custom characters
val custom = RString.randomCustom(10, Set('x', 'y', 'z'))
// Result: "xyzxyzxyzx"
```

## API Reference

### `randomString(length: Int): String`
Generates a random alphanumeric string of the specified length.

### `randomLowercase(length: Int): String`
Generates a random string of lowercase letters.

### `randomUppercase(length: Int): String`
Generates a random string of uppercase letters.

### `randomDigits(length: Int): String`
Generates a random string of digits.

### `randomMixed(length: Int): String`
Generates a random string using all available characters (letters, digits, and special characters).

### `randomStringRange(minLength: Int, maxLength: Int): String`
Generates a random alphanumeric string with length between minLength and maxLength (inclusive).

### `randomUUID(): String`
Generates a random 32-character hexadecimal string (UUID-like).

### `randomCustom(length: Int, chars: Set[Char]): String`
Generates a random string using the specified character set.

## Requirements

- Scala 3.3.1+
- Java 8+

## Building from Source

```bash
# Clone the repository
git clone https://github.com/mikla/dummy-github-maven-publish.git
cd dummy-github-maven-publish

# Build the project
sbt compile

# Run tests
sbt test

# Generate documentation
sbt doc
```

## Publishing

This library is automatically published to GitHub Packages when a new tag is pushed. The publishing process is handled by GitHub Actions.

To publish a new version:

1. Update the version in `build.sbt`
2. Create and push a new tag:
   ```bash
   git tag v0.1.1
   git push origin v0.1.1
   ```

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Changelog

### 0.1.0
- Initial release
- Basic random string generation functionality
- Support for different character sets
- UUID-like string generation
- Custom character set support 