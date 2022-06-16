def dutch_problem(array, middle):
    i = 0
    j = 0
    k = len(array) - 1

    while j <= k:
        if array[j] < middle:
            array[i], array[j] = array[j], array[i]
            i += 1
            j += 1
        elif array[j] > middle:
            array[j], array[k] = array[k], array[j]
            k -= 1
        else:
            j += 1

    return array


array = [2, 1, 2, 0, 2, 1, 0, 0, 2, 1, 0, 2]
print(dutch_problem(array, 1))


