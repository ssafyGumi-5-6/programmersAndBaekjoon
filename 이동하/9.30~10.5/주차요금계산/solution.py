from collections import defaultdict
def solution(fees, records):
    car = defaultdict(list)
    answer = defaultdict(int)
    rv = []
    for i in records:
        i = i.split()
        if car[i[1]] == []:
            car[i[1]] = i[0].split(":")
        else:
            temp = i[0].split(":")
            sigan = (int(temp[0]) - int(car[i[1]][0])) * 60 + int(temp[1]) - int(car[i[1]][1])
            car[i[1]] = []
            answer[i[1]] += sigan
    for i in car.keys():
        if car[i] != []:
            sigan = (23 - int(car[i][0])) * 60 + 59 - int(car[i][1])
            answer[i] += sigan
    for i in sorted(answer.keys()):
        if answer[i] <= fees[0]:
            rv.append(fees[1])
        else:
            rv.append(fees[1] + ((answer[i] - fees[0] - 1) // fees[2] + 1) * fees[3])
    return rv
    
    
#             if sigan <= fees[0]:
#                 # answer[i[1]] += fees[1]
#                 # answer[i[1]].append(fees[1])
                
#             else:
#                 # answer[i[1]] += fees[1] + ((sigan - fees[0] - 1) // fees[2] + 1) * fees[3]
#                 # answer[i[1]].append(fees[1] + ((sigan - fees[0] - 1) // fees[2] + 1) * fees[3])
#                 answer[i[1]].append(sigan)