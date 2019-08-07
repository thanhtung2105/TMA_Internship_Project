import os
import time

def measure_temp():
        temp = os.popen("vcgencmd measure_temp").readline()
        return (temp.replace("CPU temperature: ",""))

def get_time():
        dtime = os.popen("date").readline()
        return (dtime.replace("Date time: ",""))

while True:
        print(get_time())
        print(measure_temp())
        time.sleep(1)


