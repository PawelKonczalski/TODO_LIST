package pl.babel.lang;

import pl.babel.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class LangRepository {
    public Optional<Lang> findById(Integer id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = Optional.ofNullable(session.get(Lang.class, id));
        transaction.commit();
        session.close();
        return result;
    }

    List<Lang> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = session.createQuery("from Lang", Lang.class).list();
        transaction.commit();
        session.close();
        return result;
    }
}
