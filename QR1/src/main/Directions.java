package main;

public class Directions {
	private final int ROOM_LENGTH = 5; // size of the room string
	private char building ;
	private char floor;
	private String locaationOnFloor = null;
	

	public Directions() {

	}

	
	public char getBuilding() {
		return building;
	}


	public void setBuilding(char building) {
		this.building = building;
	}


	public char getFloor() {
		return floor;
	}


	public void setFloor(char floor) {
		this.floor = floor;
	}


	public String getLocaationOnFloor() {
		return locaationOnFloor;
	}

	public void setLocaationOnFloor(String locaationOnFloor) {
		this.locaationOnFloor = locaationOnFloor;
	}

	/*
	 * This method takes in a room eg E2004 and splits up into the correct block
	 * (Engineering, Science, Business, etc) The correct floor The correct room
	 * number
	 */
	public boolean validate(String room) {
		
		if (room.length() != ROOM_LENGTH) {			
			return false;
		}
		if (Character.isLetter(room.charAt(0)) == false) {
			return false; // room must start with a letter
		}
		for (int i = 1; i < ROOM_LENGTH; i++) {			
			if (Character.isDigit(room.charAt(i)) == false) {
				return false; // room must start with a letter
			}
		}
		
		// all ok - store the info
		building = room.charAt(0);
		floor = room.charAt(1);
		locaationOnFloor = room.substring(2);
		
		return true;
	}
	public boolean validateDate(String actualday,String classday)
	{
		String days=",Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,";
		String delims = "[,]";
		String[] day = days.split(delims);
		for(int i=0;i<6;i++)
		{
			if(day[i].equals(actualday) && day[i].equals(classday))
				return true;
			if(!day[i].equals(actualday) && day[i].equals(classday))
				return true;
			if(day[i].equals(actualday) && !day[i].equals(classday))
				return false;
		}
		return false;
	}
	public boolean validateHour(String actualhour,String classhour)
	{
		String days=",9,10,11,12,13,14,15,16,17,18";
		String delims = "[,]";
		String[] day = days.split(delims);
		for(int i=0;i<10;i++)
		{
			if(day[i].equals(actualhour) && day[i].equals(classhour))
				return true;
			if(!day[i].equals(actualhour) && day[i].equals(classhour))
				return true;
			if(day[i].equals(actualhour) && !day[i].equals(classhour))
				return false;
		}
		return false;
	}
	
	
	
	/*
	 * Get directions to building
	 */
	public String toBuilding() {
		String directions = null;
		switch (this.building) {
		case 'A':
			QRSound.playit(QRSound.QUOTE1);
			QRSound.delayfor(4);
			directions = "From reception, walk straight ahead and then turn to your right";
			break;
		case 'B':
			QRSound.playit(QRSound.QUOTE2);
			QRSound.delayfor(9);
			// TODO play the sound here for this here
			directions = "From reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest";
			break;
		case 'C':
			QRSound.playit(QRSound.QUOTE3_4);
			QRSound.delayfor(13);
			// TODO play the sound here for this here
			directions = "From reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest, then turn left and conrinute through long corridor";
			break;
		case 'D':
			QRSound.playit(QRSound.QUOTE3_4);
			QRSound.delayfor(13);
			// TODO play the sound here for this here
			directions = "rom reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest, then turn left and conrinute through long corridor";
			break;
		case 'E':
			QRSound.playit(QRSound.QUOTE5);
			QRSound.delayfor(6);
			// TODO play the sound here for this here
			directions = "From reception, move the the centre of reception and turn left into the engineering building";
			break;
		case 'F':
			QRSound.playit(QRSound.QUOTE6);
			QRSound.delayfor(8);
			// TODO play the sound here for this here
			directions = "From reception, walk outside and turn to your right.  Walk past the engineering building and the F block is straigt in front";
			break;
		default:
			directions = "Sorry, that building is not recognised";
			break;
			
		}
		return(directions);
	}
	
	/*
	 * Get directions to floor
	 */
	public String toFloor() {
		String directions = null;
		switch (this.floor) {
		case '0':
			QRSound.playit(QRSound.QUOTE7);
			QRSound.delayfor(2);
			// TODO play the sound here for this here
			directions = "Stay on this floor";
			break;
		case '1':
			QRSound.playit(QRSound.QUOTE8);
			QRSound.delayfor(4);
			// TODO play the sound here for this here
			directions = "Ascend the stairs or take the lift to the first floor";			
			break;
		case '2':
			QRSound.playit(QRSound.QUOTE9);
			QRSound.delayfor(4);
			// TODO play the sound here for this here
			directions = "Ascend two flight of stairs or take the lift to the second floor";			
			break;
		default:
			directions = "Sorry, floor " + this.floor + " is not recognised";
			break;
			
		}
		return(directions);
	}

	/*
	 * Get directions to floor
	 */
	public String toLocation() {
		String directions = null;
		switch (this.locaationOnFloor) {
		case "006":
			QRSound.playit(QRSound.QUOTE10_11);
			QRSound.delayfor(3);
			// TODO play the sound here for this here
			directions = "This is a room to the right on this level";
			break;
		case "007":
			QRSound.playit(QRSound.QUOTE10_11);
			QRSound.delayfor(3);
			// TODO play the sound here for this here
			directions = "This is a room to the righ on this level";			
			break;
		case "003":
			QRSound.playit(QRSound.QUOTE12);
			QRSound.delayfor(3);
			// TODO play the sound here for this here
			directions = "This is the last room to the right on this level";			
			break;
		case "004":
			QRSound.playit(QRSound.QUOTE13);
			QRSound.delayfor(4);
			// TODO play the sound here for this here
			directions = "This is the second last room to the right on this level";			
			break;
		default:
			directions = "Sorry, that room in not recognised";
			break;
			
		}
		return(directions);
	}

}
