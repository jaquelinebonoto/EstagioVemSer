package aula7;

import java.util.Objects;
//versão mais antiga
public class Pessoa implements Comparable {
//versão mais atual
//public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private String telefone;
    private String endereco;

    //versão mais antiga
    @Override
    public int compareTo(Object obj) {
        final Pessoa objPessoa = (Pessoa) obj;
        return this.nome.compareTo(objPessoa.nome);
    }
    //OU:
    //versão mais atual
    /*
    @Override
    public int compareTo(Pessoa obj) {
        return this.nome.compareTo(obj.nome);
    }
    */
    public Pessoa() {
    }

    public Pessoa(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + "]";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

}
