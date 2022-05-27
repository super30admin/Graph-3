class Solution:
    def alienOrder(self, words: List[str]) -> str:
        # construct a graph 
        adj_list = collections.defaultdict(int)
        indegree = collections.defaultdict(int)
        for word in words:
            for j in word:
                indegree[ j ] = 0 
                adj_list[j] = []
                
        for i in range(len(words)-1):
            for j in range( min( len(words[i]) , len(words[i+1]) )  ):
                if words[i][j] != words[i+1][j]:
                    indegree[words[i+1][j]] += 1
                    adj_list[words[i][j]].append( words[i+1][j] )
                    break
            else: 
                print(words[i], words[i+1]  )
                if len( words[i+1] ) < len(words[i] ):
                    return ""
        sorted_list = []
        q = []
        for i in indegree:
            if indegree[i] == 0 :
                q.append(i)
        while q:
            curr = q.pop(0)
            sorted_list.append(curr)
            for neighbor in adj_list[curr]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0 :
                    q.append(neighbor)
        return "".join(sorted_list) if len(sorted_list) == len(indegree) else ""
    
