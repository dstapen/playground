package com.dstapen.mvc;

import org.iq80.leveldb.*;

import static org.iq80.leveldb.impl.Iq80DBFactory.*;

import java.io.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

    static final Options OPTIONS = new Options().createIfMissing(true);


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String printHello() {
        return "It works!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "leveldb-test")
    @ResponseBody
    public String checkLevelDB() {
        try (final DB db = factory.open(new File("example"), OPTIONS)) {
            db.put("hello LevelDB".getBytes(), "SUCCESS".getBytes());
            return new String(db.get("hello LevelDB".getBytes()));
        } catch (Exception e) {
            return "FAILED";
        }
    }

}
