
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
        
        String ano =obj.getAno().trim();
        String autor = obj.getAutor();
        String descricao= obj.getDescricao();
        String disponibilidade = obj.getDisponibilidade();
        String edicao = obj.getEdicao();
        String editora = obj.getEditora();
        String quantidade = obj.getQuantidade().trim();
        String titulo = obj.getTitulo();
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
        obj.setAutor(autor.toUpperCase());
        obj.setDescricao(descricao.toUpperCase());
        obj.setDisponibilidade(disponibilidade.toUpperCase());
        obj.setEdicao(edicao.toUpperCase());
        obj.setEditora(editora.toUpperCase());
        obj.setTitulo(titulo.toUpperCase());
        
        
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
