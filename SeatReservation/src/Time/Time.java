package Time;

public class Time implements Comparable<Time> {

    private int hours;
    private int mins;
    private int secs;

    public Time() {
    }
    
    public Time(int hours) {
        if (hours >= 0 && hours < 24) {
            setHours(hours);
        } else {
            System.out.println("Invalid Hours");
        }
        setMinutes(0);
        setSeconds(0);
    }
    
    public Time(int hours, int mins) {
        if (hours >= 0 && hours < 24) {
            setHours(hours);
        } else {
            System.out.println("Invalid Hours");
        }
        if (mins >= 0 && mins < 60) {
            setMinutes(mins);
        } else {
            System.out.println("Invalid Mins");
        }
        setSeconds(0);
    }

    public Time(int hours, int mins, int secs) {
        if (hours >= 0 && hours < 24) {
            setHours(hours);
        } else {
            System.out.println("Invalid Hours");
        }
        if (mins >= 0 && mins < 60) {
            setMinutes(mins);
        } else {
            System.out.println("Invalid Mins");
        }
        if (secs >= 0 && secs < 60) {
            setSeconds(secs);
        } else {
            System.out.println("Invalid Secs");
        }
    }

    public void setSeconds(int secs) {
        this.secs = secs;
    }

    public void setMinutes(int mins) {
        this.mins = mins;

    }

    public void setHours(int hours) {
        this.hours = hours;
    }
    
    public int getSeconds() {
        return this.secs;
    }
    
    public int getMinutes() {
        return this.mins;
    }
    
    public int getHours(){
        return this.hours;
    }

    public boolean equals(Time otherTime) {
        return this.getHours() == otherTime.getHours() && 
           this.getMinutes() == otherTime.getMinutes() && 
           this.getSeconds() == otherTime.getSeconds();
    }

    @Override
    public int compareTo(Time otherTime) {
        System.out.println("Still needs implementing!");
        return 0;
    }

    public String toString() {
        if (this.getHours() > 12) {
            int convertedHour = this.getHours() - 12;
            return convertedHour + " " + this.getMinutes() + " " + this.getSeconds() + "PM";
        }
        return this.getHours() + " " + this.getMinutes() + " " + this.getSeconds() + "AM";
    }
}
