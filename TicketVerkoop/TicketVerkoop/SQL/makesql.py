# -*- coding: utf-8 -*-
"""
Created on Wed Nov  7 22:35:36 2018

@author: Jarrit
"""

f = open("insert.sql","w");

for i in range(0,150):
    #x = "insert into Plaatsen values(",i,15,i/10,i%15,");"
    x = (f'insert into Plaatsen values({i+1},{15},{(int)(i/15 +1)},{i%15+1});\n')
    f.write(x)
    
print("Klaar")
f.close()