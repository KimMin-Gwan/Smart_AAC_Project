temp = [{'key':'a'}, {'key':'b'}, {'key':'c'}, {'key':'d'}]

for arg in temp:
    if arg['key'] == 'd':
        temp.remove(arg)

print(temp)