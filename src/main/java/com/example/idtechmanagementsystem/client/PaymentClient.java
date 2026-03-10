package com.example.idtechmanagementsystem.client;


import com.example.idtechmanagementsystem.dto.request.AddStudentToGroupDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "ms-cards", url = "${client.payments.url}")
public interface PaymentClient {
    @PostMapping("/v1/payments")
    void enrollmentPayment(@RequestBody AddStudentToGroupDto addStudentToGroupDto);
}