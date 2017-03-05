package neo.browse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import neo.Links;
import neo.NearEarthObject;
import util.Http;

public class NEOBrowseResponseCollector {

	private List<NEOBrowseResponse> responses;
	private List<NearEarthObject> neoObjects;

	public List<NEOBrowseResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<NEOBrowseResponse> responses) {
		this.responses = responses;
	}

	public List<NearEarthObject> getNeoObjects() {
		return neoObjects;
	}

	public void setNeoObjects(List<NearEarthObject> neoObjects) {
		this.neoObjects = neoObjects;
	}

	public NEOBrowseResponseCollector(NEOBrowseResponse firstResponse) {
		responses = new ArrayList<>();
		neoObjects = new ArrayList<>();
		responses.add(firstResponse);
		for(NearEarthObject neo : firstResponse.getNearEarthObjects())
			neoObjects.add(neo);
	}
	
	public void collectAllPages() {
		collect(responses.get(0).getPage().getTotalPages());
	}
	
	public void collectTillPage(int index) {
		collect(index);
	}
	
	public int updateNext() {
		
		NEOBrowseResponse nextResponse = next(responses.get(responses.size() - 1));
		if(nextResponse != null) {
			for(NearEarthObject neo : nextResponse.getNearEarthObjects())
				neoObjects.add(neo);
			responses.add(nextResponse);
		}
		else
			; // TODO: lanciare un'eccezione di indice superiore al massimo
		return responses.size();
		
	}

	private void collect(int index) {
		
		if(index < responses.size())
			return;
		
		for(int i = responses.size() - 1; i < index; i++)
			updateNext();
	}

	private NEOBrowseResponse next(NEOBrowseResponse from) {

		Links links = from.getLinks();
		String next = links.getNext();

		if(!next.equals(""))
			try {
				NEOBrowseResponse to = new NEOBrowseResponse();
				Http.sendGet(next, to);
				return to;
			} catch (IOException | JSONException e) {
				e.printStackTrace();
			}

		return null;
	}

}
