number1 = 1234
number2 = 47839
number3 = 432452
number4 = 6543


def reverse_number(number):
    reverse = 0
    while number != 0:
        digit = number % 10
        reverse = reverse * 10 + digit
        number //= 10

    return reverse


print(reverse_number(number1))
print(reverse_number(number2))
print(reverse_number(number3))
print(reverse_number(number4))