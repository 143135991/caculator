package com.cloud.client.caculator.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "cloud-provider", name = "cloud-provider")
public interface caculatorFeignClient {
    @RequestMapping(value = "/{tokens}", method = RequestMethod.GET)
    String getresult(@PathVariable("tokens") String tokens);
}
