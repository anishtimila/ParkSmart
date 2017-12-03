#!/usr/bin/env python

import MySQLdb
import time
import MySQLdb
import RPi.GPIO as GPIO
GPIO.setmode(GPIO.BCM)
db = MySQLdb.connect("localhost", "root", "password", "test")
curs=db.cursor()

TRIG1 = 23
ECHO1 = 24
TRIG2 = 22
ECHO2 = 25
GPIO.setup(ECHO1,GPIO.IN)
GPIO.setup(TRIG1,GPIO.OUT)
GPIO.setup(ECHO2,GPIO.IN)
GPIO.setup(TRIG2,GPIO.OUT)
end=0
start=0
flag1=0
flag2=0

def pingy1():
    GPIO.output(TRIG1, False)
    
    time.sleep(4)
    GPIO.output(TRIG1, True)
    time.sleep(0.00001)
    GPIO.output(TRIG1, False)
    while GPIO.input(ECHO1)==0:
        pulse_start = time.time()
    while GPIO.input(ECHO1)==1:
        pulse_end = time.time()
    pulse_duration = pulse_end - pulse_start
    distance = pulse_duration * 17150
    distance = round(distance, 2)
    print ("Distance:",distance,"cm")
    return distance
print ("Reading Distance \n")
def pingy2():
    GPIO.output(TRIG2, False)
    
    time.sleep(4)
    GPIO.output(TRIG2, True)
    time.sleep(0.00001)
    GPIO.output(TRIG2, False)
    while GPIO.input(ECHO2)==0:
        pulse_start = time.time()
    while GPIO.input(ECHO2)==1:
        pulse_end = time.time()
    pulse_duration = pulse_end - pulse_start
    distance = pulse_duration * 17150
    distance = round(distance, 2)
    print ("Distance:",distance,"cm")
    return distance
print ("Reading Distance \n")
try:
    while True:
        dist=pingy1()
        dist2=pingy2()
        print("Inside loop with distance",dist," ", dist2)
        if(dist < 10 and flag1==0):
            print("Car moving in")
            time.sleep(4)
            flag1=1
            try:
                
                curs.execute ("UPDATE lot1 set state=1 where sensorID=1001;")
                db.commit()
                          

            except:
                print ("Error updating database")
                db.rollback()
        elif (dist > 10 and flag1==1):
            print("Car moving out")
            time.sleep(4)
            flag1=0
            try:
                
                curs.execute ("UPDATE lot1 set state=0 where sensorID=1001;")
                db.commit()
                          

            except:
                print("Error updating database to 0 ")
                db.rollback()
        if(dist2 < 10 and flag2==0):
            print("Car2 moving in")
            time.sleep(4)
            flag2=1
            try:
                
                curs.execute ("UPDATE lot1 set state=1 where sensorID=1002;")
                db.commit()
                          

            except:
                print ("Error updating database")
                db.rollback()
        elif (dist2 > 10 and flag2==1):
            print("Car2 moving out")
            time.sleep(4)
            flag2=0
            try:
                
                curs.execute ("UPDATE lot1 set state=0 where sensorID=1002;")
                db.commit()
                          

            except:
                print("Error updating database to 0 ")
                db.rollback()
        
except KeyboardInteruppt:
    GPIO.cleanup()
    
db.close()



