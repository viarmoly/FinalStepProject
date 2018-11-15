package org.danit.luckyfit.controller;

import org.danit.luckyfit.entity.Status;
import org.danit.luckyfit.service.impl.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/statuses"
    //, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
public class StatusController {

  @Autowired
  private StatusService statusService;

  @GetMapping
  public List<Status> findAll() {
    return statusService.findAll();
  }

  @DeleteMapping(value = "statuses/{id}")
  public void deleteByStatusId(@PathVariable int id) {
    statusService.deleteByStatusId(id);
  }

  @PostMapping
  public void add(@RequestBody Status status) {
    statusService.add(status);
  }

  @PutMapping(value = "/{id}")
  public Status modify(@RequestBody Status status) {
    return statusService.modify(status);
  }
}
