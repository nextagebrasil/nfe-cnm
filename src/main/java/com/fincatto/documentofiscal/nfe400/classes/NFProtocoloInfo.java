package com.fincatto.documentofiscal.nfe400.classes;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NFProtocoloInfo extends DFBase {
    private static final long serialVersionUID = -7256753142051587115L;

    @Attribute(name = "Id", required = false)
    private String identificador;

    @Attribute(name = "id", required = false)
    private String id;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;
    
    @Element(name = "verAplic")
    private String versaoAplicacao;
    
    @Element(name = "chNFe")
    private String chave;
    
    @Element(name = "dhRecbto")
    private String dataRecebimento;

    @Element(name = "nProt", required = false)
    private String numeroProtocolo;

    @Element(name = "digVal", required = false)
    private String validador;
    
    @Element(name = "cStat")
    private String status;

    @Element(name = "xMotivo", required = false)
    private String motivo;

    @Element(name = "cMsg", required = false)
    private String codigoMessage;

    @Element(name = "xMsg", required = false)
    private String mensagem;

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public void setVersaoAplicacao(final String versaoAplicacao) {
        this.versaoAplicacao = versaoAplicacao;
    }

    public void setChave(final String chave) {
        this.chave = chave;
    }

    public void setDataRecebimento(final String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public void setNumeroProtocolo(final String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public void setValidador(final String validador) {
        this.validador = validador;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public String getVersaoAplicacao() {
        return this.versaoAplicacao;
    }

    public String getChave() {
        return this.chave;
    }


    public LocalDateTime getDataRecebimento() {
        try {
            return LocalDateTime.parse(this.dataRecebimento, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        } catch (final Exception e) {
            return LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")
                    .parse(this.dataRecebimento));
        }
    }

    public String getNumeroProtocolo() {
        return this.numeroProtocolo;
    }

    public String getValidador() {
        return this.validador;
    }

    public String getStatus() {
        return this.status;
    }

    public String getMotivo() {
    	if (StringUtils.isBlank(this.motivo))
    	    //quando nao tiver um retorno, usa o motivo padrao identificado pelo cStat
            return ObjectUtils.defaultIfNull(NFRetornoStatus.valueOfCodigo(this.status), NFRetornoStatus.CODIGO_999 ).getMotivo();
        return this.motivo;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(final String identificador) {
        this.identificador = identificador;
    }

    public String getCodigoMessage() {
        return codigoMessage;
    }

    public void setCodigoMessage(String codigoMessage) {
        this.codigoMessage = codigoMessage;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
