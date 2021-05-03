package tms.diplom_ivan_dima.configuration;

import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import tms.diplom_ivan_dima.Model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class StartupEvent implements ApplicationListener<ContextRefreshedEvent> {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        SearchSession searchSession = Search.session(entityManager);
        MassIndexer indexer = searchSession.massIndexer(Product.class).threadsToLoadObjects(7);
        try {
            indexer.startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
