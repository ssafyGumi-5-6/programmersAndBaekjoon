def solution(citations):
    for i in range(len(citations),-1,-1):
        if len([x for x in citations if x >= i]) >= i:
            return i