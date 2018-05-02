package main;
import java.util.StringTokenizer;

public class Room {
	
	

	public Room() {
		
	}
	
	public String get(String data)
	{
		String room="N";
		int count=0;
		String employee = data;
		String delims = "[:]";
		String[] words = employee.split(delims);
		while(room.equals("N")) {			
		if(words[count].equals("Room"))
			room=words[count+1];
		count++;
		}	
		 
		// TODO extract the room number eg E2004 from the data passed in
		// Here you write the code to parse the data string and extract the room
		
		/*StringTokenizer st = new StringTokenizer(data);
		
		while (st.hasMoreTokens()) {
			if(st.nextToken().startsWith("Room")){
				room = st.nextToken(":").trim();
			}
			
		}*/
		
		return(room);
	}
	public static String getdate(String data)
	{
		int count=0;
		String date ="N";
		String employee = data;
		String delims = "[:]";
		String[] words = employee.split(delims);
		while(date.equals("N")) {			
		if(words[count].equals("Day"))
			date=words[count+1];
		count++;
		}	
		return (date);
	}
	public static String gethour(String data)
	{
		int count=0;
		String hour ="N";
		String employee = data;
		String delims = "[:]";
		String[] words = employee.split(delims);
		while(hour.equals("N")) {			
		if(words[count].equals("Time"))
			hour=words[count+1];
		count++;
		}	
		return (hour);
	}

}
