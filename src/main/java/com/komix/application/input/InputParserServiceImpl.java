package com.komix.application.input;

import com.komix.application.input.dto.ParsedInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class InputParserServiceImpl implements InputParserService {

    private static final Pattern PATTERN_INPUT = Pattern.compile("^(\\d*\\.?\\d+) (\\d+)$");

    @Override
    public ParsedInput parseInput(String line) {
        Matcher matcher = PATTERN_INPUT.matcher(line);
        matcher.matches();

        return ParsedInput.builder()
                .postalCode(matcher.group(2))
                .weight(new BigDecimal(matcher.group(1)))
                .build();
    }
}
