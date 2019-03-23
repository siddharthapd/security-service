package com.techopedia.security.endpoint;

import com.techopedia.security.domain.Token;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api(position = 1, value = "/login", tags = "Login", description = "Login controller for authenticating users and its operations")
@RefreshScope
@RestController
@RequestMapping(value = "/login")
public class LoginRestController {

    @Value("${eureka.instance.instance-id:Instance id not found}")
    private String instanceId;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(position = 1, value = "Authenticate user & Generate token", notes = "fetch user id and password and generate token", response = Token.class)
   @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "User's name", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "User's password", required = true, dataType = "string", paramType = "query", format = "password")
    })
    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Token generateToken(@RequestParam("user") String user, @RequestParam("password") String password){
        logger.info("Username : {}, Password : {}, Instance id : {}", user, password, instanceId);
        Token token = new Token("HASAH-12", Boolean.TRUE, "Instance id - ".concat(instanceId));
        return token;
    }
}
