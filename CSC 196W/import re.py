import re

def priorityFunc(str, list):
    
    num = 0
    x = []
    
    for i in range(0, 3):
        if str[i] == "H":
            x.append(list[num])
            num += 1
        else:
            x.append("null")
    
    for i in range(0,3):
        if x[i] == "null":
            x[i] = list[num]
            num += 1
    
    return x 

def priorityfunc2(nums, strs):
     
    x = []
    list=[]
    final = " "
    
    for i in range(0, nums):
        list.append(str(i))
    
    if nums <= 0:
        return "Wrong input: the number of packets must be greater than 0."
    elif nums != len(strs):
        return "Wrong input: the number of packets is wrong."
    else:
        pattern = re.compile('^[LH]+$')
        
        if not re.search(pattern, strs):
            return "Wrong input: the priority must be H or L."
        
        if nums == 3:
            x = priorityFunc(strs,list)
        elif nums > 3:
            x = priorityFunc(strs,list)
            num = 3
            
            for i in range(3, len(strs)):
                if strs[i] == 'H':
                    x.append(list[num])
                    num += 1
                else:
                    x.append('null')
            
            for i in range(3, len(strs)):
                if x[i] == 'null':
                    x[i] = list[num]
                    num += 1                  
        
        for i in x:
            final =  final + i + " "           
    
    return  final
                    
def main():
    user = input("Input:")
    inputList = user.split(" ")
    nums = int(inputList[0])
    str = inputList[1]
    print("Output:", priorityfunc2(nums, str))    

main()