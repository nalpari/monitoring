package net.nalpari.monitoring.config.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomExceptionAdvice {

    @ExceptionHandler(FilePathException.class)
    public @ResponseBody
    AppError filePathError(FilePathException e) {
        AppError errResult = AppError
                .builder()
                .message("filePath를 확인해 주세요.")
                .reason("filePath가 /data/cdn 으로 시작되지 않았습니다.")
                .build();

        return errResult;
    }
}
