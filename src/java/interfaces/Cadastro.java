

package interfaces;

public interface Cadastro<T> extends Repositorio<T> {
    
    	boolean validar(T obj) throws Exception;
}
