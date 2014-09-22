
package negocio;

import entidades.Livro;
import excecoes.CampoObrigatorioNaoPreenchidoException;
import excecoes.CampoPreenchidoComValorInvalidoException;
import interfaces.Cadastro;
import interfaces.Repositorio;
import java.util.List;

public class CadastroLivro implements Cadastro<Livro> {
    
    private Repositorio<Livro> repositorio;
    
    public CadastroLivro(Repositorio<Livro> repositorio){
        super();
        this.repositorio=repositorio;
    }
   

    @Override
    public void salvar(Livro obj) throws Exception {
        if(validar(obj)){
            repositorio.salvar(obj);
        }
        
    }

    @Override
    public void remover(String chave) throws Exception {
        if(chave==null || chave.equals("")){
            throw new Exception("Erro Ao Tentar Remover!");
        }
       repositorio.remover(chave);
    }

    @Override
    public void alterar(Livro obj) throws Exception {
        if(validar(obj)){
           repositorio.alterar(obj);
        }
    }

    @Override
    public List<Livro> filtrar(Livro filtro) throws Exception {
        return repositorio.filtrar(filtro);
    }
   
    @Override
    public boolean validar(Livro obj) throws Exception {
        
        String ano =obj.getLivro_ano().trim();
        String autor = obj.getLivro_autor();
        String descricao= obj.getLivro_descricao();
        String disponibilidade = obj.getLivro_disponibilidade();
        String edicao = obj.getLivro_edicao();
        String editora = obj.getLivro_editora();
        String quantidade = obj.getLivro_quantidade().trim();
        String titulo = obj.getLivro_titulo();
        if (ano == null || ano.isEmpty()) {
			throw new CampoObrigatorioNaoPreenchidoException("O Campo Ano não preenchido, favor insira o nome do Livro !");
		}
        if(!validarCampoNumerico(ano, "Ano") || ano.length()!=4){
            throw new CampoPreenchidoComValorInvalidoException("Campo Ano não preenchido corretamente, por favor insira novamente os dados!");
        }
        if (autor == null || autor.isEmpty()) {
			throw new CampoObrigatorioNaoPreenchidoException("O Campo Autor não preenchido, favor insira o nome do Livro !");
		}        
        if (descricao == null || descricao.isEmpty()) {
			throw new CampoObrigatorioNaoPreenchidoException("O Campo Descrição não preenchido, favor insira o nome do Livro !");
		}
        if (disponibilidade == null || disponibilidade.isEmpty()) {
			throw new CampoObrigatorioNaoPreenchidoException("O Campo Disponibilidade nãoo preenchido, favor insira o nome do Livro !");
		}
        if (edicao == null || edicao.isEmpty()) {
			throw new CampoObrigatorioNaoPreenchidoException("O Campo Edição não preenchido, favor insira o nome do Livro !");
		}
        if (editora == null || editora.isEmpty()) {
			throw new CampoObrigatorioNaoPreenchidoException("O Campo Editora não preenchido, favor insira o nome do Livro !");
		}
        if (quantidade == null || quantidade.isEmpty() || quantidade.equals("0")) {
			throw new CampoObrigatorioNaoPreenchidoException("O Campo Quantidade não preenchido, favor insira o nome do Livro !");
		}
        if (titulo == null || titulo.isEmpty()) {
			throw new CampoObrigatorioNaoPreenchidoException("O Campo Titulo não preenchido, favor insira o nome do Livro !");
		}
        obj.setLivro_autor(autor.toUpperCase());
        obj.setLivro_descricao(descricao.toUpperCase());
        obj.setLivro_disponibilidade(disponibilidade.toUpperCase());
        obj.setLivro_edicao(edicao.toUpperCase());
        obj.setLivro_editora(editora.toUpperCase());
        obj.setLivro_titulo(titulo.toUpperCase());
        
        
        return true;
    }
    
    private boolean validarCampoNumerico(String chave, String nomeCampo) throws Exception {
		for (int i = 0; i < chave.length(); i++) {
			int numero = chave.charAt(i);
			if (numero < 48 || numero > 57) {
				throw new CampoPreenchidoComValorInvalidoException("Campo numérico: " + nomeCampo + " preenchido com letras, favor corrija e tente novamente !");
			}
		}
		return true;
	}
}
