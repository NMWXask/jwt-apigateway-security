package com.project.gatewayservice.filter;

import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> openApiEndpoints = List.of(
      "/auth/register",
      "/auth/token",
      "/eureka"
    );

    public Predicate<ServletServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}