package crud.app.service;

import crud.app.data.Packet;
import crud.app.model.User;
import crud.app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private static int SIZE = 10;

    @Autowired
    private UserRepo userRepo;

    public Page<User> search(int page, String search) {
        Page<User> pageData;
        if (search != null && !search.trim().isEmpty()) {
            pageData = userRepo.findAllByNameIgnoreCaseContaining("%" + search + "%", new PageRequest(page, SIZE));
        } else {
            pageData = userRepo.findAll(new PageRequest(page, SIZE));
        }
        return pageData;
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public User user(Integer id) {
        return userRepo.getOne(id);
    }
}
