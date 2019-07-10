package pl.babel.lang;

import pl.babel.HibernateUtil;

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
}
