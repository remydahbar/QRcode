package main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.JTextField;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class Main {
		static String actualday="Friday";
		static String actualHour="15";
		static JTextField textField = null;
		static String qrCodeData;
		static String filePath;
		static char jour;
		static QR qr;
		static Room room = new Room();
		static Directions directions = new Directions();

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public static void main(String[] args) throws WriterException, IOException, NotFoundException {
			// Initial hardcoded data for test program 
			qrCodeData = ":Day:Tuesday:\n:Time:09:00 to 11:00\n:Subject:Software Engineering\n:Room:E2004:";
			filePath="myQRCode.png";
			
			qr = new QR(qrCodeData, filePath);
			
			Map hintMap = new HashMap();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			
			// create the QR barcode
			qr.createQRCode(qrCodeData, filePath, hintMap, 200, 200);
			System.out.println("QR Code image created successfully!");
			

	        			// read the barcode
			String QRdata = qr.readQRCode(filePath, hintMap);
			System.out.println("The barcode reads : " + QRdata);
	       
			// Find the room
	        //try {
			String theRoom = room.get(QRdata);
			System.out.println("The room is " + theRoom);
			String theDate = Room.getdate(QRdata);
			System.out.println("the day of the class is "+theDate);
			String theHour=Room.gethour(QRdata);
			System.out.println("the start of the class is "+theHour+"h");
	        
			// get directions
			if (directions.validate(theRoom) == false) {
				System.out.println("The directions to this room are unknown");
			}
			if(directions.validateDate(actualday, theDate)==false) {
				System.out.println("This class already occurred this week");
			}			
			else {
				System.out.println("DIRECTIONS");
				System.out.println(directions.toBuilding());
				System.out.println(directions.toFloor());
				System.out.println(directions.toLocation());
			}
			if(directions.validateHour(actualday, theHour)==false) {
				System.out.println("You are late");
			}
	        //}catch (Exception g) {
	          //    System.out.println("Caught exception " + g+ " at runtime");
			
			
			
		}

		}


