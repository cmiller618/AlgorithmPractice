word1 = "Palindrome"
word2 = "racecar"
word3 = "tacocat"


def checkPalindrome(word):
    return word == word[::-1]


print(checkPalindrome(word1))
print(checkPalindrome(word2))
print(checkPalindrome(word3))
