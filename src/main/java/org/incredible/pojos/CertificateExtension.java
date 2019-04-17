package org.incredible.pojos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * An extension to Assertion class
 */
public class CertificateExtension extends Assertion {
    /**
     * Service or program through which the credential is awarded
     */
    private String awardedThrough;

    /**
     * List of IRIs to SignatoryExtension
     */
    private String[] signatory;

    /**
     * A HTTP URL to a printable version of this certificate.
     * The URL points to a base64 encoded data, like data:application/pdf;base64
     * or data:image/jpeg;base64
     */
    private String printUri;

    /**
     * DateTime string compatible with ISO 8601 guideline
     * For example, 2016-12-31T00:00:00+00:00
     * Set time to 00:00:00 if you only need the date
     */
    private String validFrom;

    /**
     * The signature value (hash typically generated using private key)
     */
    private String signature;

    private static final ObjectMapper mapper = new ObjectMapper();

    public CertificateExtension() {
        String[] type = new String[]{"Assertion", "Extension", "extensions:CertificateExtension"};
        setType(type);
    }

    public String getAwardedThrough() {
        return awardedThrough;
    }

    public void setAwardedThrough(String awardedThrough) {
        this.awardedThrough = awardedThrough;
    }

    public String[] getSignatory() {
        return signatory;
    }

    public void setSignatory(String[] signatory) {
        this.signatory = signatory;
    }

    public String getPrintUri() {
        return printUri;
    }

    public void setPrintUri(String printUri) {
        this.printUri = printUri;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        String stringRep = null;
        try {
            stringRep = mapper.writeValueAsString(this);
        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();
        }
        return stringRep;
    }
}
