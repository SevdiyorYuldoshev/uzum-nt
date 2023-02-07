package uz.nt.uzumnt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.nt.uzumnt.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

}
