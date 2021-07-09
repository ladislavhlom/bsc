package com.komix.application.service;

import com.komix.application.input.dto.ParsedInput;
import com.komix.application.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DataProcessService {

    private final RecordRepository recordRepository;

    public void process(ParsedInput line) {
        recordRepository.putRecord(line.getPostalCode(), line.getWeight());
    }

}
