package com.linxi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author linxi
 * @function
 * @project linxiblog
 * @package com.linxi
 * @date 2020/4/28-12:25 上午
 */
//在NOT_FOUND时返回NotFoundException
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
