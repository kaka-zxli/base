package com.kaka.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzx on 2014/9/17.
 */
@RestController
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        System.out.println("aaaaaaaaaaa");
        return "two";
    }

    @RequestMapping("/b")
    public String greetingb(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        System.out.println("bbbbbbbbbbb");
        logger.info("info------");
        logger.debug("debug------");
        return "two";
    }

    @RequestMapping("/c")
    public Map greetingc(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        System.out.println("ccc");
        Map map = new HashMap();
        logger.warn("info------");
        logger.error("info------");
        logger.info("info------");
        logger.debug("debug------");
        map.put("name", "xxxx");
        map.put("aaa", new ArrayList());
        return map;
    }
}
