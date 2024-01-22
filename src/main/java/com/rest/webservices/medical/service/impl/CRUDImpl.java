package com.rest.webservices.medical.service.impl;

import com.rest.webservices.medical.exception.ModelNotFoundException;
import com.rest.webservices.medical.repository.GenericRepo;
import com.rest.webservices.medical.service.CRUD;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements CRUD<T, ID> {

    protected abstract GenericRepo<T, ID> getRepo();
    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NO EXIST" + id));
    }

    @Override
    public T update(T t, ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NO EXIST" + id));
        return getRepo().save(t);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NO EXIST" + id));
        getRepo().deleteById(id);
    }
}
