package contest.reminder.entities;

import java.util.List;

public class CodeChefAPIResponse {

	public class CodechefAPIResponseResult{
		public class CodechefAPIResponseResultData{
			public class CodechefAPIResponseResultDataContent{
				String currentTime;
				List<Contest> contestList;
				public CodechefAPIResponseResultDataContent() {
					super();
					// TODO Auto-generated constructor stub
				}
				public CodechefAPIResponseResultDataContent(
						String currentTime, List<Contest> contestList) {
					this.currentTime = currentTime;
					this.contestList = contestList;
				}
				public String getCurrentTime() {
					return currentTime;
				}
				public void setCurrentTime(String currentTime) {
					this.currentTime = currentTime;
				}
				public List<Contest> getContestList() {
					return contestList;
				}
				public void setContestList(List<Contest> contestList) {
					this.contestList = contestList;
				}
			}
			CodechefAPIResponseResultDataContent content;
			String access_token;
			long expires_in;
			String token_type;
			String scope;
			String refresh_token;
			public String getAccess_token() {
				return access_token;
			}
			public void setAccess_token(String access_token) {
				this.access_token = access_token;
			}
			public long getExpires_in() {
				return expires_in;
			}
			public void setExpires_in(long expires_in) {
				this.expires_in = expires_in;
			}
			public String getToken_type() {
				return token_type;
			}
			public void setToken_type(String token_type) {
				this.token_type = token_type;
			}
			public String getScope() {
				return scope;
			}
			public void setScope(String scope) {
				this.scope = scope;
			}
			public String getRefresh_token() {
				return refresh_token;
			}
			public void setRefresh_token(String refresh_token) {
				this.refresh_token = refresh_token;
			}
			public CodechefAPIResponseResultDataContent getContent() {
				return content;
			}
			public void setContent(CodechefAPIResponseResultDataContent content) {
				this.content = content;
			}
			public CodechefAPIResponseResultData() {
				super();
				// TODO Auto-generated constructor stub
			}
			public CodechefAPIResponseResultData(
					CodechefAPIResponseResultDataContent content, String access_token,
					long expires_in, String token_type, String scope, String refresh_token) {
				this.content = content;
				this.access_token = access_token;
				this.expires_in = expires_in;
				this.token_type = token_type;
				this.scope = scope;
				this.refresh_token = refresh_token;
			}
			
		}
		
		CodechefAPIResponseResultData data;
		String code;
		public CodechefAPIResponseResult() {
			super();
			// TODO Auto-generated constructor stub
		}
		public CodechefAPIResponseResult(CodechefAPIResponseResultData data, 
				String code, String message) {
			super();
			this.data = data;
			this.code = code;
			this.message = message;
		}
		public CodechefAPIResponseResultData getData() {
			return data;
		}
		public void setData(CodechefAPIResponseResultData data) {
			this.data = data;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		String message;
	}
	
	String status;
	CodechefAPIResponseResult result;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CodechefAPIResponseResult getResult() {
		return result;
	}
	public void setResult(CodechefAPIResponseResult result) {
		this.result = result;
	}
	public CodeChefAPIResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CodeChefAPIResponse(String status, CodechefAPIResponseResult result) {
		super();
		this.status = status;
		this.result = result;
	}
}
