#it is help to print the nCr value of Pascal's Triangle
# Pascal's Triangle Calculation using formula 
# using the formula " n! / (r! * (n-r)!) " modified version where  " ansr * col-row / row+1"

def pascal1(n,r):
    res = 1
    for i in range(r):
        res = res * (n-r)
        res = res / (i+1)
    return res

print(pascal1(int(input("Enter n: ")), int(input("Enter r: "))))