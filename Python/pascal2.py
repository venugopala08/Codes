
# Pascal's Triangle Calculation
# this code help to print the n th row of Pascal's Triangle . print full row
# it is a different approach than pascal1.py
# using the formula " ansr*(row-col) / col "

def pascal2(n):
    res = 1 
    print(res)
    for i in range(1,n):
        res = res * (n-i)
        res = res / i
        print(res)

print(pascal2(int(input("Enter n: "))))