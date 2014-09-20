
package entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private Integer usuario_id;
    @Column (name="login")
    private String usuario_login;
    @Column (name="senha")
    private String usuario_senha;
    @Column (name="nome")
    private String usuario_nome;
    @Column (name="cpf")
    private String usuario_cpf;
    @Column (name="rg")
    private String usuario_rg;
    @Column (name="dataNascimento")
    private Date usuario_dataNascimento;
    @Column (name="email")
    private String usuario_email;
    @Column (name="telefone")
    private String usuario_telefone;
    @Column (name="celular")
    private String usuario_celular;
    @Column (name="logradouro")
    private String usuario_logradouro;
    @Column (name="bairro")
    private String usuario_bairro;
    @Column (name="cidade")
    private String usuario_cidade;
    @Column (name="cep")
    private String usuario_cep;
    @Column (name="numero")
    private String usuario_numero;
    @Column (name="complemento")
    private String usuario_complemento;
    @Column (name="estado")
    private String usuario_estado;

    /**
     * @return the usuario_id
     */
    public Integer getUsuario_id() {
        return usuario_id;
    }

    /**
     * @param usuario_id the usuario_id to set
     */
    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    /**
     * @return the usuario_login
     */
    public String getUsuario_login() {
        return usuario_login;
    }

    /**
     * @param usuario_login the usuario_login to set
     */
    public void setUsuario_login(String usuario_login) {
        this.usuario_login = usuario_login;
    }

    /**
     * @return the usuario_senha
     */
    public String getUsuario_senha() {
        return usuario_senha;
    }

    /**
     * @param usuario_senha the usuario_senha to set
     */
    public void setUsuario_senha(String usuario_senha) {
        this.usuario_senha = usuario_senha;
    }

    /**
     * @return the usuario_nome
     */
    public String getUsuario_nome() {
        return usuario_nome;
    }

    /**
     * @param usuario_nome the usuario_nome to set
     */
    public void setUsuario_nome(String usuario_nome) {
        this.usuario_nome = usuario_nome;
    }

    /**
     * @return the usuario_cpf
     */
    public String getUsuario_cpf() {
        return usuario_cpf;
    }

    /**
     * @param usuario_cpf the usuario_cpf to set
     */
    public void setUsuario_cpf(String usuario_cpf) {
        this.usuario_cpf = usuario_cpf;
    }

    /**
     * @return the usuario_rg
     */
    public String getUsuario_rg() {
        return usuario_rg;
    }

    /**
     * @param usuario_rg the usuario_rg to set
     */
    public void setUsuario_rg(String usuario_rg) {
        this.usuario_rg = usuario_rg;
    }

    /**
     * @return the usuario_dataNascimento
     */
    public Date getUsuario_dataNascimento() {
        return usuario_dataNascimento;
    }

    /**
     * @param usuario_dataNascimento the usuario_dataNascimento to set
     */
    public void setUsuario_dataNascimento(Date usuario_dataNascimento) {
        this.usuario_dataNascimento = usuario_dataNascimento;
    }

    /**
     * @return the usuario_email
     */
    public String getUsuario_email() {
        return usuario_email;
    }

    /**
     * @param usuario_email the usuario_email to set
     */
    public void setUsuario_email(String usuario_email) {
        this.usuario_email = usuario_email;
    }

    /**
     * @return the usuario_telefone
     */
    public String getUsuario_telefone() {
        return usuario_telefone;
    }

    /**
     * @param usuario_telefone the usuario_telefone to set
     */
    public void setUsuario_telefone(String usuario_telefone) {
        this.usuario_telefone = usuario_telefone;
    }

    /**
     * @return the usuario_celular
     */
    public String getUsuario_celular() {
        return usuario_celular;
    }

    /**
     * @param usuario_celular the usuario_celular to set
     */
    public void setUsuario_celular(String usuario_celular) {
        this.usuario_celular = usuario_celular;
    }

    /**
     * @return the usuario_logradouro
     */
    public String getUsuario_logradouro() {
        return usuario_logradouro;
    }

    /**
     * @param usuario_logradouro the usuario_logradouro to set
     */
    public void setUsuario_logradouro(String usuario_logradouro) {
        this.usuario_logradouro = usuario_logradouro;
    }

    /**
     * @return the usuario_bairro
     */
    public String getUsuario_bairro() {
        return usuario_bairro;
    }

    /**
     * @param usuario_bairro the usuario_bairro to set
     */
    public void setUsuario_bairro(String usuario_bairro) {
        this.usuario_bairro = usuario_bairro;
    }

    /**
     * @return the usuario_cidade
     */
    public String getUsuario_cidade() {
        return usuario_cidade;
    }

    /**
     * @param usuario_cidade the usuario_cidade to set
     */
    public void setUsuario_cidade(String usuario_cidade) {
        this.usuario_cidade = usuario_cidade;
    }

    /**
     * @return the usuario_cep
     */
    public String getUsuario_cep() {
        return usuario_cep;
    }

    /**
     * @param usuario_cep the usuario_cep to set
     */
    public void setUsuario_cep(String usuario_cep) {
        this.usuario_cep = usuario_cep;
    }

    /**
     * @return the usuario_numero
     */
    public String getUsuario_numero() {
        return usuario_numero;
    }

    /**
     * @param usuario_numero the usuario_numero to set
     */
    public void setUsuario_numero(String usuario_numero) {
        this.usuario_numero = usuario_numero;
    }

    /**
     * @return the usuario_complemento
     */
    public String getUsuario_complemento() {
        return usuario_complemento;
    }

    /**
     * @param usuario_complemento the usuario_complemento to set
     */
    public void setUsuario_complemento(String usuario_complemento) {
        this.usuario_complemento = usuario_complemento;
    }

    /**
     * @return the usuario_estado
     */
    public String getUsuario_estado() {
        return usuario_estado;
    }

    /**
     * @param usuario_estado the usuario_estado to set
     */
    public void setUsuario_estado(String usuario_estado) {
        this.usuario_estado = usuario_estado;
    }
    
    
}
