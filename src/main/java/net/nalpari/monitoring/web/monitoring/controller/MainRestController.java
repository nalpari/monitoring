package net.nalpari.monitoring.web.monitoring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nalpari.monitoring.config.exception.AppError;
import net.nalpari.monitoring.config.exception.FilePathException;
import net.nalpari.monitoring.web.utils.UtilsFile;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/thymeleaf")
@Slf4j
public class MainRestController {

    @PostMapping("/chkFilePath")
    public String chkFilePath(String filePath) throws Exception {
        log.info("########### filePath: " + filePath);
        return UtilsFile.validateFilePath(filePath);
    }

    @ExceptionHandler(FilePathException.class)
    public @ResponseBody AppError filePathError(FilePathException e) {
        AppError errResult = AppError
                                .builder()
                                .message("filePath를 확인해 주세요.")
                                .reason("filePath가 /data/cdn 으로 시작되지 않았습니다.")
                                .build();

        return errResult;
    }
}
