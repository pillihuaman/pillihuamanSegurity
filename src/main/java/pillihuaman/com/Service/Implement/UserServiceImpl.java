package pillihuaman.com.Service.Implement;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import pillihuaman.com.BusinessEntity.model.AuditEntity;
import pillihuaman.com.BusinessEntity.model.User;
import pillihuaman.com.Repository.UserRepository;
import pillihuaman.com.Service.UserService;
import pillihuaman.com.basebd.user.domain.dao.UserProcessRepository;
import pillihuaman.com.model.request.ReqUser;
import pillihuaman.com.model.response.RespBase;
import pillihuaman.com.model.response.RespUser;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired(required = false)
	private UserProcessRepository userProcessRepository;

	@Override
	public RespBase<RespUser> getUserByMail(String mail) {

		RespBase<RespUser> respo = new RespBase<RespUser>();
		User filtro = new User();

		filtro.setMail(mail);
		Example<User> example = Example.of(filtro);
		List<User> lista = userRepository.findAll(example);
		if (lista != null) {

		}
		return respo;
	}

	@Override
	public RespBase<RespUser> getUserByUserName(String username) {
		RespBase<RespUser> respo = new RespBase<RespUser>();

		try {
			List<pillihuaman.com.basebd.user.domain.User> lis = userProcessRepository.findUserName(username);
			RespUser obj= new RespUser();
			for (pillihuaman.com.basebd.user.domain.User user : lis) {
				obj.setAlias(user.getAlias());
				obj.setApi_Password(user.getApiPassword());
				
				obj.setMail(user.getMail());
				obj.setPassword(user.getPassword());
				obj.setSal_Password(user.getSalPassword());
				obj.setUsername(user.getUsername());
				
			}
			respo.setPayload(obj);

		} catch (Exception e) {
			respo.getStatus().setSuccess(Boolean.FALSE);
			respo.getStatus().getError().getMessages().add(e.getMessage());
		}
		return respo;
	}

	@Override
	public RespBase<RespUser> registerUser(ReqUser request) {
		MongoClient clin = MongoClients.create("mongodb://localhost:27017");
		MongoTemplate template = new MongoTemplate(clin, "gamachicas");
		/*
		 * public @Bean MongoClient mongoClient() { return
		 * MongoClients.create("mongodb://localhost:27017"); }
		 * 
		 * public @Bean MongoTemplate mongoTemplate() { return new
		 * MongoTemplate(mongoClient(), "gamachicas"); }
		 */

		try {
			RespBase<RespUser> respo = new RespBase<RespUser>();
			pillihuaman.com.basebd.user.domain.User filtro = new pillihuaman.com.basebd.user.domain.User();
			filtro.setId(new ObjectId());
			filtro.setAlias("");
			filtro.setApiPassword("");
			filtro.setIdSystem(1);
			filtro.setIdUser(2);
			filtro.setMail(request.getMail());
			filtro.setMobilPhone("933418411");
			filtro.setPassword("933418411");
			filtro.setSalPassword("933418411");
			filtro.setUsername("zarmir");
			AuditEntity auditEntity = new AuditEntity();
			auditEntity.setCodUsuModif("o1Zarmir");
			auditEntity.setCodUsuRegis("o1Zarmir");
			auditEntity.setFecModif(new Date());
			auditEntity.setFecRegis(new Date());
			filtro.setAuditEntity(auditEntity);
			userProcessRepository.insert(filtro);
			List<pillihuaman.com.basebd.user.domain.User> lis = userProcessRepository
					.findUserByMail("pillihuamanhz@gmail.com");
			pillihuaman.com.basebd.user.domain.User filtroM = new pillihuaman.com.basebd.user.domain.User();

			// Query query = new Query();
			// query.addCriteria(Criteria.where("id").is("pillihuamanhz@gmail.com"));
			// query.

			// List<pillihuaman.com.basebd.user.domain.User> users = template.find(query,
			// pillihuaman.com.basebd.user.domain.User.class);

			filtroM.setMail("pillihuamanhz@gmail.com");
			Example<pillihuaman.com.basebd.user.domain.User> example = Example.of(filtroM);
			// userProcessRepository.findAll(sort);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
