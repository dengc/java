# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(L):
    # write your code in Python 3.6

    list = []
    for e in L :
        email = ""
        flag = False
        plus = False
        for ch in e:
            if flag:
                email += ch
            elif ch == '@':
                flag = True
                email += ch
            elif ch == '.' or plus:
                continue
            elif ch == '+':
                plus = True
            else:
                email += ch
        list.append(email)

    curSet = set()
    oldSet = set()
    for e in list:
        if e not in curSet:
            curSet.add(e)
        else:
            oldSet.add(e)

    return len(oldSet)
    pass

// aa = ['a.b.+c@163.com', 'ab...c@163.com', 'abc+....b@163.com', 'x@abc.com', 'x+b@163.com', 'z.xc@abc.com', 'z.+xc@163.com', 'q.w.e@abc.com', 'g@dfg.com', 'z@163.com', 'a.s.d@ty.com', 'a.sd@ty.com', 'abc@a.sd.com', 'abc@as.d.com', 'ab.c@as.d.com', 'q.w_e@abc.com’, ‘q.w.._e+48.3q@abc.com’]
