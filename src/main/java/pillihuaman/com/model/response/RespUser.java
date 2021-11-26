package pillihuaman.com.model.response;
import java.math.BigInteger;

import com.googlecode.jmapper.annotations.JGlobalMap;

import lombok.Getter;
import lombok.Setter;


@JGlobalMap
@Getter
@Setter
public class RespUser {
	
	private BigInteger idUser;
	private String alias;
	private BigInteger id_System;
	private String mail;
	private String mobilPhone;
	private String user;
	private String username;
	private String apiPassword;
	private String password;
	private String salPassword;


	
}


