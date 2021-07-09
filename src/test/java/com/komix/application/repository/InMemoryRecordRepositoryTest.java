package com.komix.application.repository;

import com.komix.application.repository.dto.ExportData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

class InMemoryRecordRepositoryTest {

    private InMemoryRecordRepository inMemoryRecordRepository;

    private static final String POSTAL_CODE = "12345";

    @BeforeEach
    void init() {
        inMemoryRecordRepository = new InMemoryRecordRepository();
    }

    @ParameterizedTest
    @MethodSource("provideDataForRecordWithExpectedResult")
    void putRecord_recordsWithSameKey_makeSumOfSameRecords(double input, double input2, double expected) {
        inMemoryRecordRepository.putRecord(POSTAL_CODE, BigDecimal.valueOf(input));
        inMemoryRecordRepository.putRecord(POSTAL_CODE, BigDecimal.valueOf(input2));

        List<ExportData> result = inMemoryRecordRepository.exportData();

        Assertions.assertEquals(BigDecimal.valueOf(expected), result.get(0).getWeight(), "Chybny soucet");
    }

    private static Stream<Arguments> provideDataForRecordWithExpectedResult() {
        return Stream.of(
                Arguments.of(100.1, 100.55, 200.65),
                Arguments.of(100.1, 100, 200.1),
                Arguments.of(100, 100, 200)
        );
    }

}
