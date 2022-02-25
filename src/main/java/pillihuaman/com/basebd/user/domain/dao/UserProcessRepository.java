package pillihuaman.com.basebd.user.domain.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import pillihuaman.com.basebd.user.domain.User;


@Repository
public interface  UserProcessRepository extends MongoRepository<User, String>  {
	
	 @Query("{ 'mail' : ?0 }")
	  List<User> findUserByMail(String mail);
<<<<<<< HEAD

=======
	 
	 @Query("{ 'username' : ?0 }")
	  List<User> findUserName(String mail);
>>>>>>> 62b9c0006d6dcd4cc7c651a55c0ce0c68c46e109
}
