word1 = "Palindrome"
word2 = "racecar"
word3 = "tacocat"


def checkPalindrome(word):
    if word == word[::-1]:
        return True

    return False


print(checkPalindrome(word1))
print(checkPalindrome(word2))
print(checkPalindrome(word3))
