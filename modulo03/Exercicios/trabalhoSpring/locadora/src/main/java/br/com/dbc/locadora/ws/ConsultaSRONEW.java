//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2018.11.07 às 01:52:17 PM BRST 
//


package br.com.dbc.locadora.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de consultaSRO_NEW complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="consultaSRO_NEW"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="listaObjetos" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="tipoResultado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="usuarioSro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="senhaSro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaSRO_NEW", propOrder = {
    "listaObjetos",
    "tipoResultado",
    "usuarioSro",
    "senhaSro"
})
public class ConsultaSRONEW {

    protected List<String> listaObjetos;
    protected String tipoResultado;
    protected String usuarioSro;
    protected String senhaSro;

    /**
     * Gets the value of the listaObjetos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaObjetos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaObjetos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getListaObjetos() {
        if (listaObjetos == null) {
            listaObjetos = new ArrayList<String>();
        }
        return this.listaObjetos;
    }

    /**
     * Obtém o valor da propriedade tipoResultado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoResultado() {
        return tipoResultado;
    }

    /**
     * Define o valor da propriedade tipoResultado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoResultado(String value) {
        this.tipoResultado = value;
    }

    /**
     * Obtém o valor da propriedade usuarioSro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioSro() {
        return usuarioSro;
    }

    /**
     * Define o valor da propriedade usuarioSro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioSro(String value) {
        this.usuarioSro = value;
    }

    /**
     * Obtém o valor da propriedade senhaSro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenhaSro() {
        return senhaSro;
    }

    /**
     * Define o valor da propriedade senhaSro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenhaSro(String value) {
        this.senhaSro = value;
    }

}
