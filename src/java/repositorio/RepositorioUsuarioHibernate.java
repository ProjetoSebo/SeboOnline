/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repositorio;

import entidades.Livro;
import entidades.Usuario;
import interfaces.Repositorio;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

/**
 *
 * @author Daniele
 */
public class RepositorioUsuarioHibernate implements Repositorio<Usuario> {

       private EntityManager manager;
    
    public RepositorioUsuarioHibernate(EntityManager manager){
        this.manager=manager;
    }

    @Override
    public void salvar(Usuario obj) throws Exception {
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
    public void alterar(Usuario obj) throws Exception {
        manager.getTransaction().begin();
        manager.merge(obj);
        manager.getTransaction().commit();
    }

    @Override
    public List<Usuario> filtrar(Usuario filtro) throws Exception {
         Session session = (Session) manager.getDelegate();
        Criteria  criteria = session.createCriteria(Usuario.class);
        return criteria.add(Example.create(filtro).enableLike(MatchMode.ANYWHERE).ignoreCase()).list();
    }
    
}
