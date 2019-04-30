package edu.bearcat.microservice.controller;

import edu.bearcat.microservice.entities.Menu;
import edu.bearcat.microservice.service.MenuClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haohao on 2019-4-12.
 */

@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/consumer/menu")
public class MenuConsumerController {

    @Autowired
    private MenuClientService menuClientService;

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, Object> findById(Menu menu) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("menu",menuClientService.findById(menu));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, Object> addMenu(@RequestBody Menu menu) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("addFlag",menuClientService.addMenu(menu));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Map<String, Object> modifyMenu(@RequestBody Menu menu) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("modifyFlag",menuClientService.modifyMenu(menu));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public Map<String, Object> deleteMenu(@RequestBody Menu menu) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("removeFlag",menuClientService.removeMenu(menu));
        return resultMap;
    }
}
