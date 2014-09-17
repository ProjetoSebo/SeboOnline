

package interfaces;

import java.util.List;

public interface Repositorio<T> {
    	void salvar (T obj) throws Exception;
	void remover (String chave) throws Exception;
	void alterar (T obj) throws Exception;
	List <T> filtrar (T filtro)throws Exception;
    
}
