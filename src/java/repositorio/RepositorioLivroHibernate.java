
package repositorio;

import entidades.Livro;
import interfaces.Repositorio;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

public class RepositorioLivroHibernate implements Repositorio<Livro> {
    private EntityManager manager;
    
    public RepositorioLivroHibernate(EntityManager manager){
        this.manager=manager;
    }

    @Override
    public void salvar(Livro obj) throws Exception {
        manager.getTransaction().begin();
        manager.persist(obj);
        manager.getTransaction().commit();
        
    }

    @Override
    public void remover(String chave) throws Exception {
        manager.getTransaction().begin();
        manager.remove(chave);
        manager.getTransaction().commit();
       
    }

    @Override
    public void alterar(Livro obj) throws Exception {
        manager.getTransaction().begin();
        manager.merge(obj);
        manager.getTransaction().commit();
    }

    @Override
    public List<Livro> filtrar(Livro filtro) throws Exception {
         Session session = (Session) manager.getDelegate();
        Criteria  criteria = session.createCriteria(Livro.class);
        return criteria.add(Example.create(filtro).enableLike(MatchMode.ANYWHERE).ignoreCase()).list();
    }
    
}
