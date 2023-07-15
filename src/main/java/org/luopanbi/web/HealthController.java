package org.luopanbi.web;

import org.luopanbi.common.web.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping()
    public R<String> health() {
        return R.ok("ok");
    }
}
