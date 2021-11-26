package pillihuaman.com.Service;

import pillihuaman.com.model.response.RespBase;
import pillihuaman.com.model.response.RespUser;

public interface UserService {
	RespBase<RespUser> getUserByMail(String mail);
	RespBase<RespUser> getUserByUserName(String mail);


}
