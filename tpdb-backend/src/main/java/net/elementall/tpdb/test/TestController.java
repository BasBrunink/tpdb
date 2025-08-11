package net.elementall.tpdb.test;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/public/hello")
    public String publicHello(){
        return "Hello from public Endpoint";
    }
    @RolesAllowed("ADMIN")
    @GetMapping("/admin/hello")
    public String adminHello() {
        return "Hello from Admin endpoint";
    }
}
