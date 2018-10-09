package br.com.br.dbc.paiscidade.paiscidade.entity;

import br.com.br.dbc.paiscidade.paiscidade.entity.Cidade;
import br.com.br.dbc.paiscidade.paiscidade.entity.Pais;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-09T16:31:10")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile SingularAttribute<Estado, Pais> fkIdpais;
    public static volatile CollectionAttribute<Estado, Cidade> cidadeCollection;
    public static volatile SingularAttribute<Estado, String> nomeestado;
    public static volatile SingularAttribute<Estado, String> estadosigla;
    public static volatile SingularAttribute<Estado, Long> idestado;

}