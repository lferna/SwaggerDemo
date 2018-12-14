package com.swagger.tutorial.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 *
 * @author lfernan2
 *
 */

@RestController
@Produces({ "application/json", "application/xml" })
@Api(tags = "demo")
public class DemoController {

  /**
   * Rest controller for application
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

  @GET
  @Path("/isAlive")
  @GetMapping("/isAlive")
  @ApiOperation(value = "Is Alive operation", notes = "Return is the microservice is alive with a get operation returning the time")
  @ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
  @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL ERROR SERVER"),
  @ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "UNAUTHORIZED"),
  @ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "FORBIDDEN"),
  @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "ELEMENTO NOT FOUND") })
  public ResponseEntity<String> isAlive() {

    Date tmpDate = new Date();
    return new ResponseEntity<String>(tmpDate.toString(), HttpStatus.OK);
  }

  @GET
  @Path("/helloWorld")
  @GetMapping("/helloWorld")
  @ApiOperation(value = "Hello World operation", notes = "Return hello world string")
  @ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
  @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL ERROR SERVER"),
  @ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "UNAUTHORIZED"),
  @ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "FORBIDDEN"),
  @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "ELEMENTO NOT FOUND") })
  public String helloWorld() {

    return "Hello World";
  }

}
