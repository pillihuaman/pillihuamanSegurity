package pillihuaman.com.Service.Implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import pillihuaman.com.BusinessEntity.model.Color;
import pillihuaman.com.BusinessEntity.model.User;
import pillihuaman.com.Help.ConvertClass;
import pillihuaman.com.Help.RegisterStatus;
import pillihuaman.com.Repository.UserRepository;
import pillihuaman.com.Service.ColorService;
import pillihuaman.com.Service.UserService;
import pillihuaman.com.model.response.RespBase;
import pillihuaman.com.model.response.RespColor;
import pillihuaman.com.model.response.RespUser;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ColorService colorService;

	@Override
	public RespBase<RespUser> getUserByMail(String mail) {

		RespBase<RespUser> respo = new RespBase<RespUser>();
		User filtro = new User();

		filtro.setMail(mail);
		filtro.setStatus(RegisterStatus.ACTIVE.getCode());
		Example<User> example = Example.of(filtro);
		List<User> lista = userRepository.findAll(example);
		if (lista != null) {

		}
		return respo;
	}

	@Override
	public RespBase<RespUser> getUserByUserName(String username) {
		// RespBase<RespColor> listacolor= colorService.getColorbyName("rojo");

		// List<User> lstUser = userRepository.ListAllUser();
		// User use = userRepository.ListUserByIdUser(2L);
		

		RespBase<RespUser> respo = new RespBase<RespUser>();

		try {
			User filtro = new User();

			filtro.setUsername(username);
			filtro.setStatus(RegisterStatus.ACTIVE.getCode());
			Example<User> example = Example.of(filtro);
			List<User> lista = new ArrayList<>();
			lista = userRepository.findAll(example);
			if (lista != null && lista.size() > 0) {
				respo.setPayload(ConvertClass.UserTblToUserDTO(lista.get(0)));
			}
			respo.getStatus().setSuccess(Boolean.TRUE);
		} catch (Exception e) {
			respo.getStatus().setSuccess(Boolean.FALSE);
			respo.getStatus().getError().getMessages().add(e.getMessage());
			// throw e;
		}
		return respo;
	}

}
