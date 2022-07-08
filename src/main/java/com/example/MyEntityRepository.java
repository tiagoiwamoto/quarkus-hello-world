package com.example;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class MyEntityRepository implements PanacheRepository<MyEntity> {

    public MyEntity gravar(MyEntity myEntity){
        persist(myEntity);
        return myEntity;
    }

    public List<MyEntity> recoveryEntities() {
        return listAll();
    }

    public Boolean deleteMyEntity(Long id){
        try{
            deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
