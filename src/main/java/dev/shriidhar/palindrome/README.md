## Scatter-Palindrome

A palindrome is a string which reads the same forward and backwards, for example, 'tacocat' and 'mom'.
A string is a scatter-palindrome if its letters can be rearranged to form a palindrome.
Given an array consisting of 'n' strings, for each string,
determine how many of its substrings are scatter-palindromes.
A substring is a contiguous range of characters within the string.

Example:
`strToEvaluate = ['aabb']`

The scatter-palindromes are `a, aa, aab, aabb, a, abb, b, bb, b`
There are '9' substrings that are scatter-palindromes.

---
#### Function Description:

Complete the 'scatterPalindrome' function in the editor below.

scatterPalindrome has one parameter:
string strToEvaluate[n]: the 'n' strings to be evaluated

Returns
int[n]: each element 'i' represents the number of substrings of strToEvaluate[i],  which are scatter-palindromes.

---
#### Constraints:
- 1 ≤ n ≤ 100
- 1 ≤ size of strToEvaluate[i] ≤ 1000
- all characters of strToEvaluate[i] ∈ ascii[a-z]

Sample Input For Custom Testing:
strToEvaluate = [ "abc" ]

Sample Output:
3

Explanation

The substrings that are scatter-palindromes of the string 'abc' are:
- a
- b
- c

Sample Case 1:
strToEvaluate = [ "bbrrg" ]

Sample Output
12

Explanation

The substrings that are scatter-palindromes of the string 'bbrrg' are:

- b
  -bb
  -bbr
  -bbrr
  -bbrrg
  -b
  -brr
  -r
  -rr
  -rrg
  -r
  -g

---
One of solutions I come up is to check each substring of each string,
and count in a set/array [a-z] letters that are odd
- knowing size of substring :
    - if it is even : set should be empty to be scattered palindrome
    - if it is odd : set should have exactly one element to be scattered palindrome
      
Checking set size is O(1)

What about updating set?

If we update set based on one new character - it is O(1) time for hashset:
- check if it is present in set :
    - if yes - remove
    - if no - add

What about the whole algo:

`let m - strings count`

`let n - max string size`

We need to go through each string : `m`
and for each string we need to form each substring : there are n starting points and n end points for string :
n^2
and we will be updating set in O(1) time by 1 character, so

---
#### Complexity:

Time Complexity : O(m x n^2)
Space Complexity : O(1) actually, cause need to hold max all [a-z] 26 characters.

Maybe it is not the optimal solution if we can reuse some space complexity to
hold scattered palindromes... But can not come up with algo.