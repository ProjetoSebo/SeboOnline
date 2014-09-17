
package negocio;

import entidades.Usuario;
import excecoes.CampoPreenchidoComValorInvalidoException;
import interfaces.Cadastro;
import interfaces.Repositorio;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;


public class CadastroUsuario implements Cadastro<Usuario> {
    private Repositorio<Usuario> repositorio;
    
    public CadastroUsuario(Repositorio<Usuario> repositorio){
        super();
        this.repositorio=repositorio;
    }
   

    @Override
    public void salvar(Usuario obj) throws Exception {
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
    public void alterar(Usuario obj) throws Exception {
        if(validar(obj)){
           repositorio.alterar(obj);
        }
    }

    @Override
    public List<Usuario> filtrar(Usuario filtro) throws Exception {
        return repositorio.filtrar(filtro);
    }
   
    @Override
    public boolean validar(Usuario obj) throws Exception {
        
        String bairro = obj.getBairro();
        String celular = obj.getCelular();
        String cep = obj.getCep();
        String cidade = obj.getCidade();
        String complemento = obj.getComplemento();
        String cpf = obj.getCpf();
        Date data = obj.getDataNascimento();
        String email = obj.getEmail();
        String estado = obj.getEstado();
        String login = obj.getLogin();
        String logradouro = obj.getLogradouro();
        String nome = obj.getNome();
        String numero = obj.getNumero();
        String rg = obj.getRg();
        String senha = obj.getSenha();
        
        
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
    
    	private void gerarSenhaCriptografada(Usuario obj)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(obj.getSenha().getBytes("UTF-8"));

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String senha = hexString.toString();
		obj.setSenha(senha);
	}
        	public Usuario login(Usuario usuario) throws Exception {

		List<Usuario> lista = null;

		if (validar(usuario)) {

			gerarSenhaCriptografada(usuario);

			lista = repositorio.filtrar(usuario);
		}
		if (lista== null || lista.size() ==0) {

			throw new Exception("UsuÃ¡rio " + usuario.getLogin() + " nÃ£o encontrado ou senha invÃ¡lida !");
		}

		Usuario retorno = lista.get(0);

		return retorno;
	}
        public void resetarSenhaUsuario(String emailUsuario) throws Exception {
		
        Usuario usuario = new Usuario();
		
	usuario.setEmail(emailUsuario);
		
	List<Usuario> lista = filtrar(usuario);
		
	usuario = lista.get(0);
	
	String senha = usuario.getLogin().substring(1, 3) + (usuario.getId() * 89 + 31);
		
	usuario.setSenha(senha);
		
	gerarSenhaCriptografada(usuario);
		
	alterar(usuario);
		
	//enviar email para o usuÃ¡rio
	}
}
