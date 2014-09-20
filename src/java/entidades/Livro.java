package entidades;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


public class Livro {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private String livro_id;
    @Column (name="titulo")
    private String livro_titulo;
    @Column (name="editora")
    private String livro_editora;
    @Column (name="edicao")
    private String livro_edicao;
    @Column (name="ano")
    private String livro_ano;
    @Column (name="autor")
    private String livro_autor;
    @Column (name="disponibilidade")
    private String livro_disponibilidade;
    @Column (name="quantidade")
    private String livro_quantidade;
    @Column (name="descricao")
    private String livro_descricao;
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade (CascadeType.SAVE_UPDATE)
    @Fetch (FetchMode.JOIN)
    @JoinColumn(name ="id_usuario")
    private Usuario usuario;

    /**
     * @return the livro_id
     */
    public String getLivro_id() {
        return livro_id;
    }

    /**
     * @param livro_id the livro_id to set
     */
    public void setLivro_id(String livro_id) {
        this.livro_id = livro_id;
    }

    /**
     * @return the livro_titulo
     */
    public String getLivro_titulo() {
        return livro_titulo;
    }

    /**
     * @param livro_titulo the livro_titulo to set
     */
    public void setLivro_titulo(String livro_titulo) {
        this.livro_titulo = livro_titulo;
    }

    /**
     * @return the livro_editora
     */
    public String getLivro_editora() {
        return livro_editora;
    }

    /**
     * @param livro_editora the livro_editora to set
     */
    public void setLivro_editora(String livro_editora) {
        this.livro_editora = livro_editora;
    }

    /**
     * @return the livro_edicao
     */
    public String getLivro_edicao() {
        return livro_edicao;
    }

    /**
     * @param livro_edicao the livro_edicao to set
     */
    public void setLivro_edicao(String livro_edicao) {
        this.livro_edicao = livro_edicao;
    }

    /**
     * @return the livro_ano
     */
    public String getLivro_ano() {
        return livro_ano;
    }

    /**
     * @param livro_ano the livro_ano to set
     */
    public void setLivro_ano(String livro_ano) {
        this.livro_ano = livro_ano;
    }

    /**
     * @return the livro_autor
     */
    public String getLivro_autor() {
        return livro_autor;
    }

    /**
     * @param livro_autor the livro_autor to set
     */
    public void setLivro_autor(String livro_autor) {
        this.livro_autor = livro_autor;
    }

    /**
     * @return the livro_disponibilidade
     */
    public String getLivro_disponibilidade() {
        return livro_disponibilidade;
    }

    /**
     * @param livro_disponibilidade the livro_disponibilidade to set
     */
    public void setLivro_disponibilidade(String livro_disponibilidade) {
        this.livro_disponibilidade = livro_disponibilidade;
    }

    /**
     * @return the livro_quantidade
     */
    public String getLivro_quantidade() {
        return livro_quantidade;
    }

    /**
     * @param livro_quantidade the livro_quantidade to set
     */
    public void setLivro_quantidade(String livro_quantidade) {
        this.livro_quantidade = livro_quantidade;
    }

    /**
     * @return the livro_descricao
     */
    public String getLivro_descricao() {
        return livro_descricao;
    }

    /**
     * @param livro_descricao the livro_descricao to set
     */
    public void setLivro_descricao(String livro_descricao) {
        this.livro_descricao = livro_descricao;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    
}
