package br.com.br.dbc.paiscidade.paiscidade.entity;

import br.com.br.dbc.paiscidade.paiscidade.entity.Estado;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-09T16:31:10")
@StaticMetamodel(Cidade.class)
public class Cidade_ { 

    public static volatile SingularAttribute<Cidade, Estado> fkIdestado;
    public static volatile SingularAttribute<Cidade, String> nomecidade;
    public static volatile SingularAttribute<Cidade, String> cidadesigla;
    public static volatile SingularAttribute<Cidade, BigDecimal> idcidade;

}