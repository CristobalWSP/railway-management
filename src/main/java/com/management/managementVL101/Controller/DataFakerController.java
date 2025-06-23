package com.management.managementVL101.Controller;
import net.datafaker.Faker;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/fake")
public class DataFakerController {

    private final Faker faker = new Faker();

    @GetMapping("/user")
    public EntityModel<Map<String, String>> getFakeUser() {
        Map<String, String> user = new HashMap<>();
        user.put("name", faker.name().fullName());
        user.put("email", faker.internet().emailAddress());
        user.put("address", faker.address().fullAddress());

        EntityModel<Map<String, String>> resource = EntityModel.of(user);
        Link selfLink = linkTo(methodOn(DataFakerController.class).getFakeUser()).withSelfRel();
        resource.add(selfLink);

        return resource;
    }
}