package pillihuaman.com.Service.Implement;

import java.util.Date;
import java.util.List;
<<<<<<< HEAD
import java.util.Objects;
=======
>>>>>>> 62b9c0006d6dcd4cc7c651a55c0ce0c68c46e109

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
<<<<<<< HEAD
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.mongodb.MongoException;
=======
import org.springframework.stereotype.Component;

>>>>>>> 62b9c0006d6dcd4cc7c651a55c0ce0c68c46e109
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
<<<<<<< HEAD
import pillihuaman.com.security.PasswordUtils;
=======
>>>>>>> 62b9c0006d6dcd4cc7c651a55c0ce0c68c46e109

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired(required = false)
	private UserProcessRepository userProcessRepository;
<<<<<<< HEAD
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
=======
>>>>>>> 62b9c0006d6dcd4cc7c651a55c0ce0c68c46e109

	@Override
	public RespBase<RespUser> getUserByMail(String mail) {

		RespBase<RespUser> respo = new RespBase<RespUser>();
		User filtro = new User();

		filtro.setMail(mail);
<<<<<<< HEAD
		// filtro.setStatus(RegisterStatus.ACTIVE.getCode());
=======
>>>>>>> 62b9c0006d6dcd4cc7c651a55c0ce0c68c46e109
		Example<User> example = Example.of(filtro);
		List<User> lista = userRepository.findAll(example);
		if (lista != null) {

		}
		return respo;
	}

	@Override
	public RespBase<RespUser> getUserByUserName(String username) {
<<<<<<< HEAD
		// RespBase<RespColor> listacolor= colorService.getColorbyName("rojo");

		// List<User> lstUser = userRepository.ListAllUser();
		// User use = userRepository.ListUserByIdUser(2L);

		RespBase<RespUser> respo = new RespBase<RespUser>();

		try {
			User filtro = new User();

			filtro.setUsername(username);
			// filtro.setStatus(RegisterStatus.ACTIVE.getCode());
			Example<User> example = Example.of(filtro);
			List<User> lista = new ArrayList<>();
			lista = userRepository.findAll(example);
			if (lista != null && lista.size() > 0) {
				respo.setPayload(ConvertClass.UserTblToUserDTO(lista.get(0)));
=======
		RespBase<RespUser> respo = new RespBase<RespUser>();

		try {
			List<pillihuaman.com.basebd.user.domain.User> lis = userProcessRepository.findUserName(username);
			RespUser obj= new RespUser();
			for (pillihuaman.com.basebd.user.domain.User user : lis) {
				obj.setAlias(user.getAlias());
				obj.setApi_Password(user.getApiPassword());
				obj.setId_system(user.getIdSystem());
				obj.setMail(user.getMail());
				obj.setPassword(user.getPassword());
				obj.setSal_Password(user.getSalPassword());
				obj.setUsername(user.getUsername());
				
>>>>>>> 62b9c0006d6dcd4cc7c651a55c0ce0c68c46e109
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
<<<<<<< HEAD
		try {
			RespBase<RespUser> respo = new RespBase<RespUser>();
			pillihuaman.com.basebd.user.domain.User filtro = new pillihuaman.com.basebd.user.domain.User();
			//String salt = PasswordUtils.getSalt(30);
			//String  apiPassword = PasswordUtils.generateSecurePassword(request.getPassword(), salt);
			//String password = bCryptPasswordEncoder.encode(request.getPassword());
			
			String salt = PasswordUtils.getSalt(30);
			String apiPasword = PasswordUtils.generateSecurePassword(request.getPassword(), salt);
			String Password = bCryptPasswordEncoder.encode(request.getPassword());

			//System.out.println("salt   "+salt);
			//System.out.println("Api Password   "+mySecurePassword);
			//System.out.println("Password   "+codeString);

			filtro.setId(new ObjectId());
			filtro.setAlias("");
			filtro.setApiPassword(apiPasword);
			filtro.setIdSystem(1);
			int idUser = getLastIdUser();
			filtro.setIdUser(idUser == 0 ? 1 : idUser + 1);
			filtro.setMail(request.getMail());
			filtro.setMobilPhone(request.getMobilPhone());
			filtro.setPassword(Password);
			filtro.setSalPassword(salt);
			filtro.setUsername(request.getUsername());
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
			Query query = new Query();
			Document fd = new Document();
			Example<pillihuaman.com.basebd.user.domain.User> example = Example.of(filtroM);
=======
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
>>>>>>> 62b9c0006d6dcd4cc7c651a55c0ce0c68c46e109
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

<<<<<<< HEAD
	public int getLastIdUser() {
		int id = 0;
		try {
			MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
			MongoDatabase database = mongoClient.getDatabase("gamachicas");
			MongoCollection<Document> collection = database.getCollection("user");
			Document sort = new Document().append("_id", -1);
			Document lis = collection.find().sort(sort).first();
			if (Objects.nonNull(lis)) {
				id = (int) lis.get("idUser");
			}
			mongoClient.close();
		} catch (MongoException e) {
			id = 0;
		}
		return id;
	}

=======
>>>>>>> 62b9c0006d6dcd4cc7c651a55c0ce0c68c46e109
}
