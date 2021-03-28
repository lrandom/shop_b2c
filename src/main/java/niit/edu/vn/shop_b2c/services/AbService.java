package niit.edu.vn.shop_b2c.services;


import lombok.Data;
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

    public PagingResult getPaginate(int page) {
        ArrayList list = new ArrayList<T>();
        Iterable it = repo.findAll(PageRequest.of(page - 1, 10));
        for (Object role : it
        ) {
            list.add((T) role);
        }

        long allRecord = repo.count();
        int totalPage = (int)Math.ceil(allRecord/10);

        PagingResult pagingResult = new PagingResult(totalPage,list,page);

        return pagingResult;
    }

    public ArrayList<T> getAll(){
        ArrayList list = new ArrayList<T>();
        Iterable it = repo.findAll();
        for (Object role : it
        ) {
            list.add((T) role);
        }
        return list;
    }


    @Data
    public class PagingResult{
        int totalPage;
        ArrayList<T> list;
        int activePage;

        public PagingResult(int totalPage, ArrayList<T> list, int activePage) {
            this.totalPage = totalPage;
            this.list = list;
            this.activePage = activePage;
        }


    }
}
