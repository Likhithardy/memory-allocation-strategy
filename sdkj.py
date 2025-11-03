def target_search(arr, target):
    left = 0
    right = len(arr) - 1

    while left <= right:
        mid = left + (right - left) // 2  # integer division
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    return -1


# main part
arr = [10, 20, 30, 40, 50, 60, 70, 80, 90]
target = 50
result = target_search(arr, target)

print("Element found at index:", result)
