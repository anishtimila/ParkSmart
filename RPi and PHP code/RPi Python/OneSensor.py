#!/usr/bin/env python

import MySQLdb
import time
import MySQLdb
import RPi.GPIO as GPIO
GPIO.setmode(GPIO.BCM)
db = MySQLdb.connect("localhost", "root", "password", "test")
curs=db.cursor()

TRIG = 23
ECHO = 24
GPIO.setup(ECHO,GPIO.IN)
GPIO.setup(TRIG,GPIO.OUT)
end=0
start=0
flag1=0

def pingy():
    GPIO.output(TRIG, False)
    
    time.sleep(4)
    GPIO.output(TRIG, True)
    time.sleep(0.00001)
    GPIO.output(TRIG, False)
    while GPIO.input(ECHO)==0:
        pulse_start = time.time()
    while GPIO.input(ECHO)==1:
        pulse_end = time.time()
    pulse_duration = pulse_end - pulse_start
    distance = pulse_duration * 17150
    distance = round(distance, 2)
    print ("Distance:",distance,"cm")
    return distance
print ("Reading Distance \n")
try:
    while True:
        dist=pingy()
        print("Inside loop with distance",dist)
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
except KeyboardInteruppt:
    GPIO.cleanup()
    
db.close()


