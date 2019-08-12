package com.retail.dao.impl;

import com.retail.dao.UserDao;
import com.retail.dto.User;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Implementation of UserDao
 */
@Component
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findItemByEmail(String emailId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.where(builder.equal(root.get("emailId"), emailId));
        List<User> list = entityManager.createQuery(criteria).getResultList();
        return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}
