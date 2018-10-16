package org.danit.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionRestService {


    @RequestMapping(path = "/version", method = RequestMethod.GET)
    public static String getVersion() {
        return "0.0.1";
    }
}
