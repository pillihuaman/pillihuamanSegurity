package pillihuaman.com.basebd.user.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import pillihuaman.com.BusinessEntity.model.AuditEntity;
@Document("user")
public class User  implements Serializable{
	private static final long serialVersionUID = 1L;

	 
	private int idUser;
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getApiPassword() {
		return apiPassword;
	}
	public void setApiPassword(String apiPassword) {
		this.apiPassword = apiPassword;
	}
	public int getIdSystem() {
		return idSystem;
	}
	public void setIdSystem(int idSystem) {
		this.idSystem = idSystem;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMobilPhone() {
		return mobilPhone;
	}
	public void setMobilPhone(String mobilPhone) {
		this.mobilPhone = mobilPhone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalPassword() {
		return salPassword;
	}
	public void setSalPassword(String salPassword) {
		this.salPassword = salPassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public User(@NotNull int idUser, String alias, String apiPassword, int idSystem, String mail,
			String mobilPhone, String password, String salPassword, String username) {
		super();
		this.idUser = idUser;
		this.alias = alias;
		this.apiPassword = apiPassword;
		this.idSystem = idSystem;
		this.mail = mail;
		this.mobilPhone = mobilPhone;
		this.password = password;
		this.salPassword = salPassword;
		this.username = username;

	}
	public User() {}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public AuditEntity getAuditEntity() {
		return AuditEntity;
	}
	public void setAuditEntity(AuditEntity auditEntity) {
		AuditEntity = auditEntity;
	}
	@BsonId
	@JsonSerialize(using = ToStringSerializer.class)
	private ObjectId id;
	private AuditEntity AuditEntity;
	private String alias;
	private String apiPassword;
	private int idSystem;
	private String mail;
	private String mobilPhone;
	private String password;
	private String salPassword;
	private String username;



}