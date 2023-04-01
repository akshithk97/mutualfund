package com.aliceblue.mutualfund.v3.soapclient;

import com.aliceblue.mutualfund.v3.Utility;
import com.aliceblue.mutualfund.v3.model.MFOrder;
import com.aliceblue.mutualfund.v3.repository.MFPasswordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import java.net.URISyntaxException;

@Service
@Slf4j
public class MFOrderClient extends WebServiceGatewaySupport {

    @Autowired
    MFPasswordRepository mfPasswordRepository;

    private final in.bsestarmf.ObjectFactory objectFactory;

    public MFOrderClient() {
        this.objectFactory = new in.bsestarmf.ObjectFactory();
    }

    public void sendOrder(MFOrder mfOrder)
    {
        in.bsestarmf.OrderEntryParam orderEntryParam = new in.bsestarmf.OrderEntryParam();
        orderEntryParam.setOrderId(objectFactory.createOrderEntryParamOrderId(mfOrder.getOrderId()));
    }

    public String getPassword(String UserId) {
        String passkey = Utility.passKeyGeneration();
        String Password = mfPasswordRepository.findAll().get(0).getPassword();

        in.bsestarmf.GetPassword getPassword = new in.bsestarmf.GetPassword();
        getPassword.setUserId(objectFactory.createGetPasswordUserId(UserId));
        getPassword.setPassword(objectFactory.createGetPasswordPassword(Password));
        getPassword.setPassKey(objectFactory.createGetPasswordPassKey(passkey));

        try {
            in.bsestarmf.GetPasswordResponse getPasswordResponse = (in.bsestarmf.GetPasswordResponse) makeRequest(getPassword, Utility.MF_PASSWORD_URI);
            return getPasswordResponse.getGetPasswordResult().getValue();
        } catch (URISyntaxException | SOAPException e) {
            log.error("GENERATE MF PASSWORD ERROR - {}", e.getMessage());
            return e.getMessage();
        }
    }

    private Object makeRequest(Object request, String URI) throws URISyntaxException, SOAPException {
        ActionCallback callback = new ActionCallback(URI);

        MessageFactory msgFactory = MessageFactory.newInstance(javax.xml.soap.SOAPConstants.SOAP_1_2_PROTOCOL);
        SaajSoapMessageFactory saajSoapMessageFactory = new SaajSoapMessageFactory(msgFactory);
        saajSoapMessageFactory.setSoapVersion(SoapVersion.SOAP_12);
        getWebServiceTemplate().setMessageFactory(saajSoapMessageFactory);

        WebServiceTemplate template = getWebServiceTemplate();
        template.setMessageFactory(saajSoapMessageFactory);

        return template.marshalSendAndReceive(request, callback);
    }
}
