import tempy as tempy

array1 = [1, 2, 3, 4, 5]

high = len(array1) - 1

low = 0

while low < high:
    temp = array1[high]
    array1[high] = array1[low]
    array1[low] = temp
    low += 1
    high -= 1


print(array1)