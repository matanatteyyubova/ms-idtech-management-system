package com.example.idtechmanagementsystem.queue;

import com.example.idtechmanagementsystem.dto.response.StudentDto;import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;


@Component
@RequiredArgsConstructor
@Slf4j
public class QueueSender {
    private final ObjectMapper objectMapper;
    private final AmqpTemplate amqpTemplate;


    @Value("${rabbitmq.queue.student}")
    private String studentQueue;

    public void sendStudentIdToCardQueue(StudentDto studentDto) {
        try {
            String message = objectMapper.writeValueAsString(studentDto);
            amqpTemplate.convertAndSend(studentQueue, message);
            log.info("Successfully sent student to queue: {}", studentDto.getId());
        } catch (Exception e) {
            log.error("Error when serializing student object to JSON for ID: {}", studentDto.getId(), e);
        }
    }
}
