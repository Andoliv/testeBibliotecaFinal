package br.com.biblioteca.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DAO<T> {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (Exception e) {
			return sessionFactory.openSession();
		}
	}

	public DAO() {
	}

	public T save(T entity) {
		try {
			getSession().beginTransaction();
			getSession().save(entity);
			getSession().getTransaction().commit();
			getSession().close();
			return entity;
		} catch (Exception e) {
			getSession().getTransaction().rollback();
			getSession().close();
			return null;
		}
	}

	public T update(T entity) {
		try {
			getSession().beginTransaction();
			getSession().merge(entity);
			getSession().getTransaction().commit();
			getSession().close();
			return entity;
		} catch (Exception e) {
			getSession().getTransaction().rollback();
			getSession().close();
			return null;
		}
	}

	public void delete(T entity) {
		try {
			getSession().beginTransaction();
			getSession().delete(entity);
			getSession().getTransaction().commit();
		} catch (Exception e) {
			getSession().getTransaction().rollback();
		} finally {
			getSession().close();
		}
	}

	@SuppressWarnings("unchecked")
	public T searchModel(DetachedCriteria query) {
		T model = (T) query.getExecutableCriteria(getSession()).uniqueResult();
		return model;
	}

	@SuppressWarnings("unchecked")
	public List<T> searchModels(DetachedCriteria query) {
		List<T> models = query.getExecutableCriteria(getSession()).list();
		return models;
	}

}