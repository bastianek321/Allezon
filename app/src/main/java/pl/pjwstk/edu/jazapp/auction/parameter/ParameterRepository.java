package pl.pjwstk.edu.jazapp.auction.parameter;


import pl.pjwstk.edu.jazapp.auction.entities.Parameter;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class ParameterRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void addToDataBase(Parameter parameter){
        if(checkIfParameterExists(parameter.getName())){
            em.persist(parameter);
        }
    }

    @Transactional
    public void editParameter(Parameter parameter){
        if(checkIfParameterExists(parameter.getName())){
            em.merge(parameter);
        }
    }

    @Transactional
    public boolean checkIfParameterExists(String name){
        var list = em.createQuery("from Parameter where name= :name", Parameter.class)
                .setParameter("name", name)
                .getResultList();
        return list.isEmpty();
    }

    @Transactional
    public Parameter getParameterByName(String name){
        return em.createQuery("from Parameter where name= :name", Parameter.class).setParameter("name", name).getSingleResult();
    }

    @Transactional
    public Parameter getParameterById(Long id){
        return em.find(Parameter.class, id);
    }

}
