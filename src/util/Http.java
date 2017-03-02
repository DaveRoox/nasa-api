package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http {

	private static boolean print = false;

	public static void sendGet(String url, GenericResponse result) throws IOException {

		URL furl = new URL(url);
		HttpURLConnection con = (HttpURLConnection) furl.openConnection();

		con.setRequestMethod("GET");

		result.setResponseCode(con.getResponseCode());
		if(print) {
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + result.getResponseCode());
		}

		if(result.getResponseCode() == 200) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			result.setRawResponse(response.toString());
			
			if(print)
				System.out.println(result);
		}
	}
}
