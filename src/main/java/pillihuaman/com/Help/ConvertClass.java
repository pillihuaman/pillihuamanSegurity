package pillihuaman.com.Help;
import pillihuaman.com.BusinessEntity.model.User;
import pillihuaman.com.model.response.RespUser;

public class ConvertClass {

	

public static  RespUser	UserTblToUserDTO(User request){
	RespUser resp= new RespUser();
	resp.setMail(request.getMail());
	resp.setUsername(request.getUsername());
	resp.setIdUser(request.getIdUser());
	resp.setAlias(request.getAlias());
	resp.setApiPassword(request.getApiPassword());
	resp.setSalPassword(request.getSalPassword());
	resp.setPassword(request.getPassword());
	return resp;
	
}


}
