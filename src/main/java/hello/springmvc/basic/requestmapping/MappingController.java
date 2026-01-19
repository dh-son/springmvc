package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@Slf4j
public class MappingController {

    @RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mappingGetV2");
        return "ok";
    }

    // http://localhost:8080/mapping/userA
    @GetMapping(value = "/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId = {}", data);
        return "ok";
    }

    @GetMapping(value = "/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    @GetMapping(value = "mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    @GetMapping(value = "mapping-header", params = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    // http header: Content-Type
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsume");
        return "ok";
    }

    // http header: Accept
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduce() {
        log.info("mappingProduce");
        return "ok";
    }
}
