//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2018.11.06 às 06:14:34 PM BRST 
//


package br.com.dbc.locadora.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de objetoPostalPK complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="objetoPostalPK"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoEtiqueta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="plpNu" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "objetoPostalPK", propOrder = {
    "codigoEtiqueta",
    "plpNu"
})
public class ObjetoPostalPK {

    protected String codigoEtiqueta;
    protected long plpNu;

    /**
     * Obtém o valor da propriedade codigoEtiqueta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoEtiqueta() {
        return codigoEtiqueta;
    }

    /**
     * Define o valor da propriedade codigoEtiqueta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoEtiqueta(String value) {
        this.codigoEtiqueta = value;
    }

    /**
     * Obtém o valor da propriedade plpNu.
     * 
     */
    public long getPlpNu() {
        return plpNu;
    }

    /**
     * Define o valor da propriedade plpNu.
     * 
     */
    public void setPlpNu(long value) {
        this.plpNu = value;
    }

}
