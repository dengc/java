
def solution(A):
    # write your code in Python 3.6

    l = len(A)
    count = 0
    if l == 1:
        return 1
    if l == 2:
        return 2;
    start_point = 0
    while start_point < l-1:
        res = set()
        j = start_point + 1
        for i in range(start_point, l):
            if A[i] not in res:
                res.add(A[i])
            else:
                if A[i] != A[i-1]:
                    j = i
            if len(res) > 2:
                count = max(count, (i - start_point))
                start_point = j
                break
            if i == l - 1:
                count = max(count, (i - start_point + 1))
                return count
    return count

#
# t = [1,2,1,2,1,2,1]
# t2 = [2,3,2,2,2,4,5,7]
# t3 = [3,4,3,1,2,1,6]
# print(solution(t3))
