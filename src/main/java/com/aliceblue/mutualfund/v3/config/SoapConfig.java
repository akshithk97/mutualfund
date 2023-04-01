package com.aliceblue.mutualfund.v3.config;

import com.aliceblue.mutualfund.v3.Utility;
import com.aliceblue.mutualfund.v3.soapclient.MFOrderClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("in.bsestarmf", "com.aliceblue.mutualfund.in.istarmfwebservice");
        return marshaller;
    }

    @Bean
    public MFOrderClient mfOrderClient(Jaxb2Marshaller marshaller) {
        MFOrderClient client = new MFOrderClient();
        client.setDefaultUri(Utility.MF_DEFAULT_URI);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
