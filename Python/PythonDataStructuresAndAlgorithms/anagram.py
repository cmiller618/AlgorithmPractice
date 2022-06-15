def anagram(word1, word2):
    word1 = ''.join(sorted(word1))
    word2 = ''.join(sorted(word2))

    return word1 == word2


print(anagram("angel", "angle"))
print(anagram("restful", "fluster"))
print(anagram("satan", "santa"))
print(anagram("fire", "truck"))

