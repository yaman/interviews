package problems;

public class AngleOfClock {

	public double getAngle(String time) {
		String[] timer = time.split(":");

		int hour = Integer.valueOf(timer[0]);
		int minutes = Integer.valueOf(timer[1]);
 

		double angle = -1;

		double hourPercentage = (double) minutes / (double) 60;

		double minuteAngle = minutes * 6;

		double hourAngle = hour * 30;
		double nextHourAngle = (hour + 1) * 30;
		hourAngle = hourAngle + ((nextHourAngle - hourAngle) * hourPercentage);
 
		int hourZone = (int) hourAngle / 90;
		int minuteZone = (int) minuteAngle / 90; 

		if (hourZone == minuteZone) {
			angle = minuteAngle - hourAngle;
			if (angle < 0)
				angle *= -1;
		} else if (hourZone > minuteZone) {
			angle = hourAngle - minuteAngle;
		} else if (hourZone < minuteZone) {
			angle = minuteAngle - hourAngle;
		}

		return angle;
	}

	public static void main(String[] args) {
		AngleOfClock clock = new AngleOfClock();

		String time = "11:30";
		double angle = clock.getAngle(time);

		System.out.println(angle);

	}

}
