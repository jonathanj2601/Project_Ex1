# Ex1
This assignment focuses on building foundational skills in functional programming and testing, with an emphasis on working with strings, arrays, and numerical computations.

The goal of the assignment is to design a number formatting converter and calculator. Numbers will be represented as strings in various bases, ranging from binary (base 2) to hexadecimal (base 16). Bases from 10 to 16 use the characters A, B, ..., G to represent additional digits. The format for these string representations is as follows:
(number)(b)(base)

Examples of valid formats:
- "135" (base 10 by default)
- "135bA" (base 10, equivalent to "135")
- "100111b2" (binary)
- "12345b6" (base 6)
- "012b5" (base 5)
- "123bG" (base 16)
- "EFbG" (base 16)

Examples of invalid formats:
- "b2"
- "0b1"
- "123b"
- "1234b11"
- "3b3"
- "-3b5"
- "3 b4"
- "GbG"
- "" (empty string)
- null
## Features
I've got 6 functions that are necessary to do all the calculations:
- Converter
- number2Int
- isNumber
- int2Number
- equals
- maxIndex

I've explained each one's purpose before the functio and in the code itself i've put lines of explanations to better understand the code
## "Installation"
Link to my Repository: https://github.com/jonathanj2601/Project_Ex1.git
## Usage
#### run the 'Ex1Main' class. 
ignore the 'Main' class and the 'Ex1Sol.jar' file.

