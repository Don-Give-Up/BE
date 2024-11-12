package com.virtukch.dongiveupbe.domain.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "BankLogClient", url = "")
public interface BankLogClient {
}
