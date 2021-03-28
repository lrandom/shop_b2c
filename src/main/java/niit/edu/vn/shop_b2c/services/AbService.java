package niit.edu.vn.shop_b2c.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;

public class AbService<T, R extends PagingAndSortingRepository> {
    protected R repo;

    public AbService(R repo) {
        this.repo = repo;
    }

    public T getById(Long id) {
        return (T) repo.findById(id).get();
    }

    public boolean save(T role) {
        try {
            repo.save(role);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public ArrayList<T> getPaginate(int page) {
        ArrayList list = new ArrayList<T>();
        Iterable it = repo.findAll(PageRequest.of(page - 1, 10));
        for (Object role : it
        ) {
            list.add((T) role);
        }
        return list;
    }
}
