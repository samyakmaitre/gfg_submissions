
from typing import List

class Solution:
    def constructList(self, q : int, queries : List[List[int]]) -> List[int]:
        # code here
        s = [0]
        xor_offset = 0  # This will keep track of the cumulative XOR offset
        
        for query in queries:
            if query[0] == 0:
                # Insert the number into the list
                s.append(query[1] ^ xor_offset)  # Adjust the insertion with current offset
            elif query[0] == 1:
                # Update the XOR offset
                xor_offset ^= query[1]
        
        # Adjust the list with the final XOR offset
        adjusted_list = [num ^ xor_offset for num in s]
        
        # Return the sorted list
        return sorted(adjusted_list)
        



#{ 
 # Driver Code Starts
class IntMatrix:

    def __init__(self) -> None:
        pass

    def Input(self, n, m):
        matrix = []
        #matrix input
        for _ in range(n):
            matrix.append([int(i) for i in input().strip().split()])
        return matrix

    def Print(self, arr):
        for i in arr:
            for j in i:
                print(j, end=" ")
            print()


class IntArray:

    def __init__(self) -> None:
        pass

    def Input(self, n):
        arr = [int(i) for i in input().strip().split()]  #array input
        return arr

    def Print(self, arr):
        for i in arr:
            print(i, end=" ")
        print()


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):

        q = int(input())

        queries = IntMatrix().Input(q, 2)

        obj = Solution()
        res = obj.constructList(q, queries)

        IntArray().Print(res)

# } Driver Code Ends