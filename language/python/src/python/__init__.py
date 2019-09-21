score = 85

if score>=90:
    print 'excellent'
elif  score>=80:
    print 'good'
elif  score>=60:
    print 'passed'
else:
    print 'failed'



L = [75, 92, 59, 68]
sum = 0.0
for score in L:
    sum = sum + score
print sum / 4


sum = 0
x = 1
n = 0
while True:
    x = 2**n
    n = n+1
    sum =sum+x
    if n>=20:
        break
print sum



d = {
    'Adam': 95,
    'Lisa': 85,
    'Bart': 59
}
print "Adam:" , d['Adam']
print "Lisa:" , d.get('Lisa')
print "Bart:" , d['Bart']


import math
def move(x, y, step, angle):
    nx = x + step * math.cos(angle)
    ny = y - step * math.sin(angle)
    return nx, ny