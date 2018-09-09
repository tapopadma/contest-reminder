package contest.reminder.entities;

public class CodechefOAuthDetails {

	String grant_type;
	String code;
	String client_id;
	String client_secret;
	String redirect_uri;
	public String getgrant_type() {
		return grant_type;
	}
	public void setgrant_type(String grant_type) {
		this.grant_type = grant_type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getclient_id() {
		return client_id;
	}
	public void setclient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getclient_secret() {
		return client_secret;
	}
	public void setclient_secret(String client_secret) {
		this.client_secret = client_secret;
	}
	public String getredirect_uri() {
		return redirect_uri;
	}
	public void setredirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}
	public CodechefOAuthDetails(String grant_type, String code, 
			String client_id, String client_secret,
			String redirect_uri) {
		super();
		this.grant_type = grant_type;
		this.code = code;
		this.client_id = client_id;
		this.client_secret = client_secret;
		this.redirect_uri = redirect_uri;
	}
	public CodechefOAuthDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
