package br.com.br.dbc.paiscidade.paiscidade.entity;

import br.com.br.dbc.paiscidade.paiscidade.entity.Estado;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-09T16:31:10")
@StaticMetamodel(Pais.class)
public class Pais_ { 

    public static volatile SingularAttribute<Pais, String> siglapais;
    public static volatile CollectionAttribute<Pais, Estado> estadoCollection;
    public static volatile SingularAttribute<Pais, BigDecimal> idpais;
    public static volatile SingularAttribute<Pais, String> nomepais;

}