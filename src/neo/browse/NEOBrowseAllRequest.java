package neo.browse;

import util.GenericResponse;

public class NEOBrowseAllRequest extends NEOBrowseRequest {

	public NEOBrowseAllRequest(String apiKey) {
		super(apiKey);
	}

	@Override
	public GenericResponse newResponse() {
		return new NEOBrowseAllResponse();
	}

}
