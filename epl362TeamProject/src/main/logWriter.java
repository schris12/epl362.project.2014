package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import webservices.AddLogStub.Add_log;

public class logWriter {
	public void logWriterOut(String s) {
		// // Creating the Request
		// webservices.AddLogStub.Add_log request;
		// request = new Add_log();
		// request.setTo_write(s);
		// try {
		// webservices.AddLogStub stub = new webservices.AddLogStub();
		// webservices.AddLogStub.Add_logResponse response;
		// response = stub.add_log(request);
		// System.out.println("Response: " + response.get_return());
		//
		// } catch (RemoteException ea) {
		// // TODO Auto-generated catch block
		// ea.printStackTrace();
		// }
		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar
				.getInstance().getTime());
		File file = new File("logs/" + timeStamp);

		FileWriter fileWritter = null;
		try {
			fileWritter = new FileWriter(file.getAbsolutePath(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
		try {
			bufferWritter.write(s+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bufferWritter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
