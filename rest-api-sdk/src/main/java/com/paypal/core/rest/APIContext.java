package com.paypal.core.rest;

import java.util.UUID;

/**
 * <code>APIContext</code> holds wire-level parameters for the API call.
 * AccessToken is treated as a mandatory parameter. RequestId is generated if
 * not supplied
 * 
 * @author kjayakumar
 * 
 */
public class APIContext {

	/**
	 * Access Token
	 */
	private String accessToken;

	/**
	 * Request Id
	 */
	private String requestId;

	/**
	 * APIContext
	 * 
	 * @param accessToken
	 *            AccessToken required for the call.
	 */
	public APIContext(String accessToken) {
		if (accessToken == null || accessToken.length() <= 0) {
			throw new IllegalArgumentException("AccessToken cannot be null");
		}
		this.accessToken = accessToken;
	}

	/**
	 * APIContext
	 * 
	 * @param accessToken
	 *            AccessToken required for the call.
	 * @param requestId
	 *            Unique requestId required for the call.
	 */
	public APIContext(String accessToken, String requestId) {
		this(accessToken);
		if (requestId == null || requestId.length() <= 0) {
			throw new IllegalArgumentException("RequestId cannot be null");
		}
		this.requestId = requestId;
	}

	/**
	 * Returns the Access Token
	 * 
	 * @return Access Token
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * Returns the unique requestId set during creation, if not available
	 * returns a generated one
	 * 
	 * @return requestId
	 */
	public String getRequestId() {
		if (requestId == null || requestId.length() <= 0) {
			requestId = UUID.randomUUID().toString();
		}
		return requestId;
	}

}
