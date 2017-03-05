package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;

public class Http {

	private static boolean print = false;

	public static void sendGet(String url, GenericResponse result) throws IOException, JSONException {

		URL furl = new URL(url);
		HttpURLConnection con = (HttpURLConnection) furl.openConnection();

		con.setRequestMethod("GET");

		if(print) {
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + con.getResponseCode());
		}
		
		result.setResponseCode(con.getResponseCode());
		
		InputStream _is;
		if (con.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST)
		    _is = con.getInputStream();
		else
		    _is = con.getErrorStream();
		
		if(_is == null) {
			result.setRawResponse(null);
			return;
		}
		
		BufferedReader in = new BufferedReader(new InputStreamReader(_is));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		result.setRawResponse(response.toString());
		result.parse();

		if(print)
			System.out.println(result);
	}
}
