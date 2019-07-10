package pl.babel;

import java.util.Optional;

class LangRepository {
    Optional<Lang> findById(Integer id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = Optional.ofNullable(session.get(Lang.class, id));
        transaction.commit();
        session.close();
        return result;
    }
}
