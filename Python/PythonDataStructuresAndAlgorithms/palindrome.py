word1 = "Palindrome"
word2 = "racecar"
word3 = "tacocat"


def checkPalindrome(word):
    end_letter = len(word) - 1
    start_letter = 0

    while end_letter > start_letter:
        if word[end_letter] != word[start_letter]:
            return False
        end_letter -= 1
        start_letter += 1

    return True


print(checkPalindrome(word1))
print(checkPalindrome(word2))
print(checkPalindrome(word3))
