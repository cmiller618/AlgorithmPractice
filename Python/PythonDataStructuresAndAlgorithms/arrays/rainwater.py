import math



def trapping_water(heights):

    if len(heights) < 3:
        return 0

    max = 0
    max_left_value = []
    for nums in heights:
        max_left_value.append(max)
        if max < nums:
            max = nums
    print(max_left_value)
    max_right_value = []
    max = 0
    heights.reverse()
    for nums in heights:
        max_right_value.append(max)
        if max < nums:
            max = nums

    max_right_value.reverse()
    heights.reverse()
    print(max_right_value)
    trapped_water = []
    for i in range(0, len(max_right_value) - 1):
        trapped = min(max_right_value[i], max_left_value[i]) - heights[i]
        if trapped < 0:
            trapped = 0
        trapped_water.append(trapped)

    return sum(trapped_water)


heights = [1, 0, 2, 1, 3, 1, 2, 0, 3]

print(trapping_water(heights))