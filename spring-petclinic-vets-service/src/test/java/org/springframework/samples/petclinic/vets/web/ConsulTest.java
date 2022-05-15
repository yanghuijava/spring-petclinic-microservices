package org.springframework.samples.petclinic.vets.web;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.ConsulRawClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.catalog.CatalogServicesRequest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class ConsulTest {

    @Test
    public void test() throws InterruptedException {
        ConsulRawClient.Builder builder = ConsulRawClient.Builder.builder().setHost("10.9.60.43")
            .setPort(30000);
        ConsulClient consulClient = new ConsulClient(builder.build());

        while(true){
            CatalogServicesRequest request = CatalogServicesRequest.newBuilder()
                .setQueryParams(new QueryParams(2, 4251))
                .build();
            Response<Map<String, List<String>>> response =  consulClient.getCatalogServices(request);
            System.out.println(response);
            Thread.sleep(1000);
        }
    }
}
